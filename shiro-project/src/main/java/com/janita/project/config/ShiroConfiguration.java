package com.janita.project.config;

import com.janita.project.shiro.OnlineSessionFactory;
import  com.janita.project.shiro.realm.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Created by Janita on 2017/6/20 0020-上午 9:38
 * 该类是：
 */
@Configuration
public class ShiroConfiguration {


    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:cache/ehcache.xml");
        return cacheManager;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //凭证匹配器
    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        //指定密码加密的算法
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //会自动把前台输入的密码用 md5 加密
        matcher.setHashAlgorithmName("MD5");
        //指定加密的次数
        matcher.setHashIterations(1024);
        //TODO
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public Realm realm() {
        LoginRealm realm = new LoginRealm();
        realm.setCredentialsMatcher(credentialsMatcher());
        //启用缓存，默认false
        realm.setCachingEnabled(true);
        //禁用权限缓存，防止修改权限之后不能立即生效的问题
        //启用身份验证缓存，即缓存AuthenticationInfo 信息，默认false
        realm.setAuthenticationCachingEnabled(false);
        //缓存AuthenticationInfo信息的缓存名称
        realm.setAuthenticationCacheName("authenticationCache");
        //启用授权缓存，即缓存AuthorizationInfo信息，默认false
        realm.setAuthorizationCachingEnabled(false);
        //缓存AuthorizationInfo信息的缓存名称
        realm.setAuthorizationCacheName("authorizationCache");
        return realm;
    }

    /**
     * 会话Cookie模板
     * @return
     */
    @Bean(name = "sessionIdCookie")
    public Cookie sessionIdCookie () {
        SimpleCookie cookie = new SimpleCookie("sid");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        return cookie;
    }

    @Bean(name = "rememberMeCookie")
    public Cookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        return cookie;
    }

    /**
     * rememberMe管理器
     * @return
     */
    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        //<property name="cipherKey" value="#{T(org.apache.shiro.codec.Base64).decode('4AvVhmFLUs0KTA3Kprsdag==')}"/>
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    /**
     * 会话ID生成器
     * @return
     */
    @Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * 会话DAO
     * @return
     */
    @Bean
    public SessionDAO sessionDAO() {
        EnterpriseCacheSessionDAO dao = new EnterpriseCacheSessionDAO();
        //名字在 缓存配置文件中
        dao.setActiveSessionsCacheName("shiro-activeSessionCache");
        dao.setSessionIdGenerator(sessionIdGenerator());
        return dao;
    }

    /**
     * 会话工厂
     * @return
     */
    @Bean
    public OnlineSessionFactory onlineSessionFactory() {
        return new OnlineSessionFactory();
    }

    @Bean
    public DefaultSessionManager sessionManager() {
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        //会话验证调度器 --><!-- org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler
        sessionManager.setSessionValidationScheduler(null);
        sessionManager.setSessionDAO(sessionDAO());
        return sessionManager;
    }


    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public ModularRealmAuthenticator authenticator() {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return authenticator;
    }


    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //多个 realm 最终还是配置到这里的
        securityManager.setAuthenticator(authenticator());
        securityManager.setCacheManager(getEhCacheManager());
        Collection<Realm> realmCollection = new ArrayList<>();
        realmCollection.add(realm());
        securityManager.setRealms(realmCollection);
        //配置 sessionDao
        securityManager.setSessionManager(sessionManager());
        securityManager.setRememberMeManager(cookieRememberMeManager());
        return securityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(getDefaultWebSecurityManager());
        return new AuthorizationAttributeSourceAdvisor();
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        //配置登录接口，当调用登出接口之后，默认会调用此接口
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        //统一管理资源权限
        shiroFilterFactoryBean.setFilterChainDefinitionMap(buildFilterChainDefinitionMap());
        return shiroFilterFactoryBean;
    }

    /**
     * 配置一个bean ，该 bean 实际上就是一个 map
     * 实际上我们需要从数据库中查询
     * 仍然是优先匹配原则
     */
    @Bean
    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/login", "anon");
//        map.put("/**", "authc");
        return map;
    }
}

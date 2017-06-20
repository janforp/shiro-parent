package com.janita.shiro.config;

import com.janita.shiro.realms.SecondShiroRealm;
import com.janita.shiro.realms.FirstShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * Created by Janita on 2017/6/20 0020-上午 9:38
 * 该类是：
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public Realm firstRealm() {
        FirstShiroRealm realm = new FirstShiroRealm();
        //指定密码加密的算法
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //会自动把前台输入的密码用 md5 加密
        matcher.setHashAlgorithmName("MD5");
        //指定加密的次数
        matcher.setHashIterations(1024);
        realm.setCredentialsMatcher(matcher);
        return realm;
    }

    @Bean
    public Realm secondRealm() {
        SecondShiroRealm realm = new SecondShiroRealm();
        //指定密码加密的算法
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //会自动把前台输入的密码用 md5 加密
        matcher.setHashAlgorithmName("SHA1");
        //指定加密的次数
        matcher.setHashIterations(1024);
        realm.setCredentialsMatcher(matcher);
        return realm;
    }

    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }

    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
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
        //配置多个 realm
//        Collection<Realm> realmCollection = new ArrayList<>();
//        realmCollection.add(firstRealm());
//        realmCollection.add(secondRealm());
//        authenticator.setRealms(realmCollection);
        //策略：不同的策略
        //AtLeastOneSuccessfulStrategy
        //AllSuccessfulStrategy
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return authenticator;
    }


    @Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    @Bean
    public SessionDAO sessionDAO() {
        EnterpriseCacheSessionDAO dao = new EnterpriseCacheSessionDAO();
        //名字在 缓存配置文件中
        dao.setActiveSessionsCacheName("cache");
        dao.setSessionIdGenerator(sessionIdGenerator());
        return dao;
    }

    @Bean
    public DefaultSessionManager sessionManager() {

        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionDAO(sessionDAO());

        return sessionManager;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //多个 realm 最终还是配置到这里的
        securityManager.setAuthenticator(authenticator());
        securityManager.setCacheManager(getEhCacheManager());
        Collection<Realm> realmCollection = new ArrayList<>();
        realmCollection.add(firstRealm());
        realmCollection.add(secondRealm());
        securityManager.setRealms(realmCollection);

        //配置 sessionDao
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(getDefaultWebSecurityManager());
        return new AuthorizationAttributeSourceAdvisor();
    }

    /**
     * <property name="securityManager" ref="securityManager" />
     <property name="loginUrl" value="/login" />
     <property name="successUrl" value="/login/loginSuccessFull" />
     <property name="unauthorizedUrl" value="/login/unauthorized" />
     <property name="filterChainDefinitions">
     <value>
     /home* = anon
     / = anon
     /logout = logout
     /role/** = roles[admin]
     /permission/** = perms[permssion:look]
     /** = authc
     </value>
     </property>
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        //配置登录接口，当调用登出接口之后，默认会调用此接口
        shiroFilterFactoryBean.setLoginUrl("/shiro");
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
        //跳转登录页面的接口时可以匿名访问的
        map.put("/shiro", "anon");
        //登录接口也可以匿名
        map.put("/shiro/login", "anon");
        //登出
        map.put("/shiro/logout", "logout");
        //给不同的角色不同的权限
        //TODO,权限配置，需要实现授权的 realm
        map.put("/admin", "roles[admin]");
        map.put("/user", "roles[user]");
        //需要认证之后的接口
        map.put("/**", "authc");
        return map;
    }
}

package com.janita.shiro.config;

import com.janita.shiro.realms.SecondShiroRealm;
import com.janita.shiro.realms.FirstShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
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
    public ModularRealmAuthenticator authenticator() {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        //配置多个 realm
        Collection<Realm> realmCollection = new ArrayList<>();
        realmCollection.add(firstRealm());
        realmCollection.add(secondRealm());
        authenticator.setRealms(realmCollection);
        //策略
        authenticator.setAuthenticationStrategy(new AllSuccessfulStrategy());
        return authenticator;
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
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //多个 realm 最终还是配置到这里的
        securityManager.setAuthenticator(authenticator());
        securityManager.setCacheManager(getEhCacheManager());
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

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        //跳转登录页面的接口时可以匿名访问的
        filterChainDefinitionMap.put("/shiro", "anon");
        //登录接口也可以匿名
        filterChainDefinitionMap.put("/shiro/login", "anon");
        //登出
        filterChainDefinitionMap.put("/shiro/logout", "logout");
        //需要认证之后的接口
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
}

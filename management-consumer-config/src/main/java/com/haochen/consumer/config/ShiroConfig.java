package com.haochen.consumer.config;

import com.haochen.consumer.shiro.cache.JedisManager;
import com.haochen.consumer.shiro.cache.JedisShiroSessionRepository;
import com.haochen.consumer.shiro.cache.impl.CustomShiroCacheManager;
import com.haochen.consumer.shiro.cache.impl.JedisShiroCacheManager;
import com.haochen.consumer.shiro.credential.CustomCredentialsMatcher;
import com.haochen.consumer.shiro.dao.CustomShiroSessionDAO;
import com.haochen.consumer.shiro.filter.AccessControlFilter;
import com.haochen.consumer.shiro.filter.JWTFilter;
import com.haochen.consumer.shiro.filter.KickoutSessionControlFilter;
import com.haochen.consumer.shiro.filter.SimpleFilter;
import com.haochen.consumer.shiro.realm.MyRealm;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;
import redis.clients.jedis.JedisPool;

import javax.servlet.Filter;
import java.util.Map;

/**
 * @author YangChao
 */
@Configuration
public class ShiroConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        //  该值缺省为false,表示生命周期由SpringApplicationContext管理,设置为true则表示由ServletContainer管理
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean shiroJWTFilterRegistration(JWTFilter jwtFilter) {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(jwtFilter);
        filterRegistration.setEnabled(false);
        return filterRegistration;
    }


    @Bean
    public FilterRegistrationBean shiroSimpleFilterRegistration(SimpleFilter simpleFilter) {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(simpleFilter);
        filterRegistration.setEnabled(false);
        return filterRegistration;
    }


    @Bean
    public FilterRegistrationBean shiroAccessControlFilterRegistration(AccessControlFilter accessControlFilter) {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(accessControlFilter);
        filterRegistration.setEnabled(false);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean shiroKickoutSessionControlFilterFilterRegistration(KickoutSessionControlFilter kickoutSessionControlFilter) {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(kickoutSessionControlFilter);
        filterRegistration.setEnabled(false);
        return filterRegistration;
    }



    @Bean
    public JedisManager jedisManager(JedisPool jedisPool) {
        JedisManager jedisManager = new JedisManager();
        jedisManager.setJedisPool(jedisPool);
        return jedisManager;
    }

    @Bean
    public JedisShiroSessionRepository jedisShiroSessionRepository(JedisPool jedisPool) {
        JedisShiroSessionRepository jedisShiroSessionRepository = new JedisShiroSessionRepository();
        jedisShiroSessionRepository.setJedisManager(jedisManager(jedisPool));
        return jedisShiroSessionRepository;
    }

    @Bean
    public JedisShiroCacheManager jedisShiroCacheManager(JedisPool jedisPool) {
        JedisShiroCacheManager jedisShiroCacheManager = new JedisShiroCacheManager();
        jedisShiroCacheManager.setJedisManager(jedisManager(jedisPool));
        return jedisShiroCacheManager;
    }

    @Bean
    public CustomShiroCacheManager cacheManager(JedisPool jedisPool) {
        CustomShiroCacheManager cacheManager = new CustomShiroCacheManager();
        cacheManager.setShiroCacheManager(jedisShiroCacheManager(jedisPool));
        return cacheManager;
    }

    @Bean
    public CustomShiroSessionDAO customShiroSessionDAO(JedisPool jedisPool) {
        CustomShiroSessionDAO customShiroSessionDAO = new CustomShiroSessionDAO();
        customShiroSessionDAO.setShiroSessionRepository(jedisShiroSessionRepository(jedisPool));
        return customShiroSessionDAO;
    }


    @Bean
    public CustomCredentialsMatcher credentialsMatcher() {
        return new CustomCredentialsMatcher();
    }

    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getManager(MyRealm realm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 使用自己的realm
        manager.setRealm(realm);

        /*
         * 关闭shiro自带的session，详情见文档
         * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        manager.setSubjectDAO(subjectDAO);

        return manager;
    }


    @Bean
    public JWTFilter jwtFilter() {
        return new JWTFilter();
    }

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

    @Bean
    public AccessControlFilter accessControlFilter() {
        return new AccessControlFilter();
    }

    @Bean
    public KickoutSessionControlFilter kickoutSessionControlFilter(JedisPool jedisPool) {
        KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
        kickoutSessionControlFilter.setCacheManager(cacheManager(jedisPool));
        return kickoutSessionControlFilter;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String, Filter> filterMap = shiroFilterFactoryBean.getFilters();
        filterMap.put("jwt", jwtFilter());
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setUnauthorizedUrl("/401");
        shiroFilterFactoryBean.setFilters(filterMap);

        Map<String, String> filterChainDefinitionMap = shiroFilterFactoryBean.getFilterChainDefinitionMap();

        // 所有请求通过我们自己的JWT Filter
        // 访问401和404页面不通过我们的Filter
        filterChainDefinitionMap.put("/401", "anon");
        filterChainDefinitionMap.put("/user/login", "anon");
//        filterChainDefinitionMap.put("/common/**", "anon");
        filterChainDefinitionMap.put("/**", "jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 下面的代码是添加注解支持
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        // https://zhuanlan.zhihu.com/p/29161098
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }


}

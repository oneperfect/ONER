package com.demon.admin.core.config;

import com.demon.admin.core.shiro.AuthorRealm;
import com.demon.admin.core.shiro.UserAuthorFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Auther: oneperfect
 * @Date: 2019/3/22
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     * shiro过滤bean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * 添加自定义拦截器，重写user认证方法，处理session超时问题
         */
        HashMap<String, Filter> filter = new HashMap<>();
        filter.put("userAuthor", new UserAuthorFilter());
        shiroFilterFactoryBean.setFilters(filter);

        // 添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *  常用的过滤器：
         *      anon: 无需认证（登录）可以访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用rememberMe功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login/**", "anon");
        filterMap.put("/assets/**", "anon");
        filterMap.put("/lib/**", "anon");
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/**", "userAuthor");

        // 设置过滤规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        // 跳转登录界面
        shiroFilterFactoryBean.setLoginUrl("/login/");
        // 未授权错误页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(AuthorRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean
    public AuthorRealm getRealm() {
        return new AuthorRealm();
    }
}

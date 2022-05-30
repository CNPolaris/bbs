package com.polaris.bbs.config;

import com.polaris.bbs.pojo.Permission;
import com.polaris.bbs.security.component.DynamicSecurityService;
import com.polaris.bbs.security.config.SecurityConfig;
import com.polaris.bbs.service.IPermissionService;
import com.polaris.bbs.service.IBbsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @author CNPolaris
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BbsSecurityConfig extends SecurityConfig {
    @Autowired
    private IBbsUserService userService;
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private DynamicSecurityService dynamicSecurityService;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> userService.loadUserByUsername(username);
    }
    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<Permission> resourceList = permissionService.queryAll();
                for (Permission resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }

}

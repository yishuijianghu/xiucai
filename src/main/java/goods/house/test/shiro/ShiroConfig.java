package goods.house.test.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 09:21
 * @Description:
 */
@Configuration
public class ShiroConfig {

        private static String loginUrl = "/login";

        @Bean
        public UserRealm userRealm(){
            UserRealm userRealm = new UserRealm();
            return userRealm;
        }

        /*
        配置安全管理器
         */
        @Bean
        public SecurityManager manager(){
            DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
            securityManager.setRealm(userRealm());
            return securityManager;
        }

        @Bean
        public ShiroFilterFactoryBean shiroFilter(SecurityManager manager){
            ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
            bean.setSecurityManager(manager);
            //身份认证失败，则跳转到登录页面的配置
            bean.setLoginUrl(loginUrl);
            // Shiro连接约束配置，即过滤链的定义
            LinkedHashMap<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
            // 对静态资源设置匿名访问
            filterChainDefinitionMap.put("/css/**", "anon");
            filterChainDefinitionMap.put("/bootstrap/**", "anon");
            filterChainDefinitionMap.put("/fonts/**", "anon");
            filterChainDefinitionMap.put("/font-awesome/**", "anon");
            filterChainDefinitionMap.put("/images/**", "anon");
            filterChainDefinitionMap.put("/img/**", "anon");
            filterChainDefinitionMap.put("/js/**", "anon");
            filterChainDefinitionMap.put("/layer/**", "anon");
            filterChainDefinitionMap.put("/ico/**", "anon");

            // 不需要拦截的访问
            filterChainDefinitionMap.put("/login", "anon");
            filterChainDefinitionMap.put("/do_login", "anon");

            // 所有请求需要认证
            filterChainDefinitionMap.put("/**", "authc");
            bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
            return bean;
        }


}

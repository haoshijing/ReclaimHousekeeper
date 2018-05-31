package com.duyun.huihsou.housekepper.portal.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.web
 * @email cn.lu.duke@gmail.com
 * @date January 14, 2018
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.duyun.huihsou.housekepper.portal.controller")
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
@Slf4j
public class WebMvcConf extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginFilter loginFilter;

    /**
     * 请求拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册监控拦截器
        registry.addInterceptor(loginFilter)
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger2-ui.html")
                .excludePathPatterns("/swagger-resources/**")
                //微信授权api1.0
                .excludePathPatterns("/wechat/auth/check_access")
                //微信授权api2.0
                .excludePathPatterns("/auth/wechat/callback/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*/*")
                .allowedMethods("*")
                .maxAge(120);
    }


    @Override public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("swagger-ui.html");
    }

    @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("/swagger-resources/configuration/ui")
                .addResourceLocations("/META-INF/resources/**");
    }
}

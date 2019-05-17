package com.lee.gmall.config;

import com.lee.gmall.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {


    
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}

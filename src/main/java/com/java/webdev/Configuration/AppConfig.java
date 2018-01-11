package com.java.webdev.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by M Nurul Fikri on 06/01/2018
 */
@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/resources/templates/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/static/js/**")
                .addResourceLocations("/resources/static/js/");
        registry.addResourceHandler("/resources/static/css/**")
                .addResourceLocations("/resources/static/css/");
        registry.addResourceHandler("/resources/views/**") //html
                .addResourceLocations("/resources/views/");
        registry.addResourceHandler("/resources/static/images/**") //umum.bisa utk img
                .addResourceLocations("/resources/static/images/");
        registry.addResourceHandler("/webjars/**") //library
                .addResourceLocations("/webjars/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}
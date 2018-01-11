package com.java.webdev.Configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by M Nurul Fikri on 06/01/2018
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //add config .class
    @Override
    protected Class <?>[] getRootConfigClasses(){
        return new Class[] {AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses(){
        return null;
    }

    @Override
    protected String[] getServletMappings(){
        return new String[] {"/"};
    }
}

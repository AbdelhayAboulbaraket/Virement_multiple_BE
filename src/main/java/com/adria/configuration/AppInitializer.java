package com.adria.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.adria.configuration.security.AppSecurityConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	 @Override
	    protected Class <?> [] getRootConfigClasses() {
	        return new Class[] {  AppSecurityConfig.class, PersistenceJPAConfig.class };
	        
	    }

	    @Override
	    protected Class <?> [] getServletConfigClasses() {
	        return new Class[] {WebMvcConfig.class};
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] {"/"};
	    }


}
package com.auki.core.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.Testservice;


@Component(service = Testservice.class, immediate=true)

public class Trainingimpl implements Testservice 
	{
		
		
		@Reference
		private ResourceResolverFactory resourceResolverFactory;
	
		
		@Override
		public String testing()
		{
			final Map<String, Object> params=new HashMap<>();
			params.put(ResourceResolverFactory.SUBSERVICE, "testing");
			
			ResourceResolver resourceResolver=null;
			
				try {
					resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
				} catch (LoginException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			Resource resource= resourceResolver.getResource("/content/auki/en");
			return resource.getResourceType();
		}
		
		
	}

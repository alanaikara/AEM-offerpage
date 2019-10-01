package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.Testservice;
import com.auki.core.services.Testservice2;

@Component(service = Testservice.class, immediate=true)
public class Trainingimpl implements Testservice  {
	
	@Reference
	private Testservice2 testservice2;
	@Override
	public String hello()
	{
		return testservice2.hii();
	}
	
	
}

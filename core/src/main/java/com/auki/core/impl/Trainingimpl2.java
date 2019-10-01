package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;

import com.auki.core.services.Testservice2;

@Component(service = Testservice2.class, immediate=true)
public class Trainingimpl2 implements Testservice2  {
	@Override
	public String hii()
	{
		return "testing with Interface2";
	}
	
}
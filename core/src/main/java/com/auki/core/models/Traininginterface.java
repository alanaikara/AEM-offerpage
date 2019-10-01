package com.auki.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import com.auki.core.services.Testservice;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Traininginterface {
	
	@Inject @Optional
	private String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Testservice getTestservice() {
		return testservice;
	}

	public void setTestservice(Testservice testservice) {
		this.testservice = testservice;
	}

	@Inject @Optional
	private Testservice testservice;
	
	@PostConstruct
	protected void testConstruct() {
		this.text = testservice.hello();
	}


}

package com.auki.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.auki.core.services.Offerlist;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Listchildmodel {
	@Inject
	private Offerlist offerlist;
	private List<ListPageDetail> newList = new ArrayList<ListPageDetail>();
	
	@PostConstruct
	protected void offerlist() {
		newList=offerlist.getoffer(); 
		
	}

	public List<ListPageDetail> getNewList() {
		return newList;
	}

	

}

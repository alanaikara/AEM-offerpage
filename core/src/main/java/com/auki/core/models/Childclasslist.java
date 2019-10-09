package com.auki.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;

import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class)

public class Childclasslist {
	
	@Inject
	@Source("sling-object")
	
	private ResourceResolver resourceResolver;
	private List<ListPageDetail> datafromModelList = new ArrayList<ListPageDetail>();
	
	@PostConstruct
	public void init() {
		try {
				Resource resource = resourceResolver.getResource("/content/aemtraining2/en/offers-page");
				if(resource!=null)
				{
					Page parentPage = resource.adaptTo(Page.class);
					if(parentPage!=null)
					{ int i =0;
						Iterator<Page> listChildPages = parentPage.listChildren(); 
						while(listChildPages.hasNext()) {
							i++;
							Page childPage = listChildPages.next();
							ListPageDetail detail = new ListPageDetail();
							detail.setTitle(childPage.getTitle());
							detail.setId(i);
							
							try {
								resource = resourceResolver.getResource("/content/aemtraining2/en/offers-page/"+childPage.getName()+"/jcr:content/root/responsivegrid/teaser");
								ValueMap properties= resource.adaptTo(ValueMap.class);
								detail.setImage(properties.get("fileReference",(String) null));
								detail.setTeasertitle(properties.get("jcr:title",(String) null));
								detail.setDescription(properties.get("jcr:description",(String) null));
								detail.setStartDate(properties.get("eventStartDate",(String) null));
								detail.setEndDate(properties.get("eventEndDate",(String) null));
								detail.setLink("/content/aemtraining2/en/offers-page/"+childPage.getName());

							
							}
							catch(Exception e) { e.printStackTrace();}
							datafromModelList.add(detail);
						}
					}
				}
		}
		catch(Exception e) { e.printStackTrace();}
		
	}
	public List<ListPageDetail> getDatafromModelList(){
		return datafromModelList;
	}
}

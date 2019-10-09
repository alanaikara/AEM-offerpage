package com.auki.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import com.auki.core.models.ListPageDetail;
import com.auki.core.services.Offerlist;
import com.day.cq.wcm.api.Page;

@Component(service = Offerlist.class, immediate=true)
@Designate(ocd =Offerlistimpl.Config.class)
public class Offerlistimpl implements Offerlist {
	
	
	@ObjectClassDefinition( name ="test config", description = "test config properties")
	public static @interface Config{
		
		@AttributeDefinition(name = "path value")
		String path_value() default "/content/aemtraining2/en/offers-page/";
		
		@AttributeDefinition(name = "max offer")
		int max_offer() default 4;
	}
	
	
	
	@Reference
	private ResourceResolverFactory resourceResolverFactory;
	
	private String pathValue;
	
	@Activate
	protected void activate (final Config config) {
		this.pathValue=config.path_value();
		
	}
	
	@Override
	public List<ListPageDetail> getoffer(){
		
		final Map<String, Object> params=new HashMap<>();
		params.put(ResourceResolverFactory.SUBSERVICE, "testing");
		
		ResourceResolver resourceResolver=null;
		
		try {
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<ListPageDetail> datafromModelList = new ArrayList<ListPageDetail>();
			try {
					Resource resource = resourceResolver.getResource(pathValue);
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
									resource = resourceResolver.getResource(pathValue+childPage.getName()+"/jcr:content/root/responsivegrid/teaser");
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
			return datafromModelList;
		}
	

}

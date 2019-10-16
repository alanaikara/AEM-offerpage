package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;
  
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
  
import com.auki.core.services.PageService;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
 
 
@Component
public class PageServiceImp implements PageService {
     
    private String user = "alan";
     
    private Session session;
     
    //Inject a Sling ResourceResolverFactory
    @Reference
    private ResourceResolverFactory resolverFactory;
     
     
    public String CreatePage(String pageName,String image,String startDate,String endDate,String desc) 
    {
    String pagePath = "/content/aemtraining2/en/offers-page";
    String templatePath = "/conf/aemtraining2/settings/wcm/templates/offerspagetemplate";
    String pageTitle = "newpage";
    Page newPage;
    PageManager pageManager; 
    ResourceResolver resolver = null;
    
    Map<String, Object> authInfo = new HashMap<>();
	authInfo.put(ResourceResolverFactory.SUBSERVICE, "testing");
       
    try {
                  
        //Invoke the adaptTo method to create a Session 
        resolver = resolverFactory.getServiceResourceResolver(authInfo);
         
        session = resolver.adaptTo(Session.class);
                 
        //create a page manager instance
        pageManager = resolver.adaptTo(PageManager.class); 
         
        //create a new page
        newPage = pageManager.create(pagePath, pageName, templatePath, pageTitle);
        if (newPage != null) {
 
            Node newNode = newPage.adaptTo(Node.class);
            Node cont = newNode.getNode("jcr:content");
            if (cont != null) {
	        	Node offerNode = JcrUtils.getNodeIfExists(cont, "root/responsivegrid/teaser");
	        	offerNode.setProperty("jcr:createdBy", user);
	        	offerNode.setProperty("jcr:title", pageName);
	        	offerNode.setProperty("eventEndDate", endDate);
	        	offerNode.setProperty("eventStartDate", startDate);
	        	offerNode.setProperty("fileReference", image);
	        	offerNode.setProperty("jcr:description", desc);
                session.save();
            }
        }
         
        return pageName; 
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     
    return ""  ; 
 
}
 
}
package com.auki.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.PageService;

@Component(service=Servlet.class,
property={
		 Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
	        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
	        "sling.servlet.paths="+ "/bin/test5",
	        "sling.servlet.extensions=" + "txt/html"
	
	
})

public class OfferServlet  extends SlingAllMethodsServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Reference
	private PageService pageService;

	@Override
	protected void doPost(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
			String image = req.getParameter("image");
	        String title = req.getParameter("title");
			String desc = req.getParameter("desc");
	        String startDate = req.getParameter("startdate");
	        String endDate = req.getParameter("enddate");
	        pageService.CreatePage(title, image, startDate, endDate, desc);
	        JSONObject obj=new JSONObject();

			 try {
				obj.put("image",image);
				obj.put("title",title);
				obj.put("desc",desc);
				obj.put("date",startDate);
				obj.put("date",endDate);
			

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 

		 			resp.setContentType("application/json");
		 			resp.setCharacterEncoding("utf-8");
		 		
		 			resp.getWriter().write(obj.toString());

		 			
		 		}
	 
}
	

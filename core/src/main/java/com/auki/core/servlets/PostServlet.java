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

@Component(service=Servlet.class,
property={
		 Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
	        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
	        "sling.servlet.paths="+ "/bin/test4",
	        "sling.servlet.extensions=" + "txt/html"
	
	
})

public class PostServlet  extends SlingAllMethodsServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
			String username = req.getParameter("username");
	        String password = req.getParameter("password");
	         
	        JSONObject obj=new JSONObject();

			 try {
				obj.put("username",username);
				obj.put("password",password);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 

		 			resp.setContentType("application/json");
		 			resp.setCharacterEncoding("utf-8");
		 		
		 			resp.getWriter().write(obj.toString());

		 			
		 		}
	 
}
	

package com.auki.core.models;


import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import com.auki.core.services.PageService;

@Model(adaptables = { Resource.class })
public class Trial {
// @Inject
//private PageService ps;
	 

 @Inject @Optional
 private String text;
 @Inject @Optional
 private String pathbrowser;
 
 @Inject @Optional
 private String fileReference;

public String getText() {
	return text;
}
public String getFileReference() {
	return fileReference;
}
public void setFileReference(String fileReference) {
	this.fileReference = fileReference;
}
public void setText(String text) {
	this.text = text;
}
public String getPathbrowser() {
	return pathbrowser;
}
public void setPathbrowser(String pathbrowser) {
	this.pathbrowser = pathbrowser;
}

@PostConstruct
protected void testConstruct() {
	this.text = "auki";
}

 
}

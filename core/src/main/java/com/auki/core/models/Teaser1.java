package com.auki.core.models;



import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = { Resource.class })
public class Teaser1 {


 @Inject @Optional
 private String date;



 
}

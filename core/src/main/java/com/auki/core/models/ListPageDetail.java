package com.auki.core.models;

import javax.inject.Inject;

import org.apache.sling.models.annotations.Optional;

public class ListPageDetail {
	@Inject @Optional
	private String title;
	private String description;
	private String teasertitle;
	private String image;
	private String startDate;
	private String endDate;
	private int id;
	private String link;

	public String getTeasertitle() {
		return teasertitle;
	}

	public void setTeasertitle(String teasertitle) {
		this.teasertitle = teasertitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	

}

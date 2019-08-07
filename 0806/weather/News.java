package com.ssafy.news;

public class News {
	String title;
	String desc;
	String link;
	public News() {
		super();
	}
	public News(String title, String desc, String link) {
		super();
		this.title = title;
		this.desc = desc;
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "News [title=" + title + ", desc=" + desc + ", link=" + link + "]";
	}
	
	

}

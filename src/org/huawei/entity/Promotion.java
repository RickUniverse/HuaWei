package org.huawei.entity;

import java.io.Serializable;

/**
 * 促销表
 * @author Administrator
 *
 */
public class Promotion implements Serializable {
	/**
	 * 促销id
	 */
	private int id;
	/**
	 * 促销标题
	 */
	private String title;
	/**
	 * 促销内容
	 */
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Promotion() {
		super();
	}
	public Promotion(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
}

package org.huawei.entity;

import java.io.Serializable;

/**
 * ������
 * @author Administrator
 *
 */
public class Promotion implements Serializable {
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ��������
	 */
	private String title;
	/**
	 * ��������
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

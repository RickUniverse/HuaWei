package org.huawei.entity;

import java.io.Serializable;

/**
 * �ֲ�ʵ����
 * 
 * @author Administrator
 *
 */
public class Carousel implements Serializable {
	/**
	 * �ֲ�id
	 */
	private int id;
	/**
	 * �ֲ�ͼƬ
	 */
	private String image;
	/**
	 * �ֲ����ӵ�ַ
	 */
	private String href;
	/**
	 * �ֲ���Ʒid
	 */
	private int colorandconfigureId;

	/**
	 * ���ö���
	 */
	private ColorandConfigure colorandConfigure;
	/**
	 * ����λ��
	 */
	private int orders;

	public Carousel(int id, String image, String href, int colorandconfigureId, ColorandConfigure colorandConfigure,
			int orders) {
		super();
		this.id = id;
		this.image = image;
		this.href = href;
		this.colorandconfigureId = colorandconfigureId;
		this.colorandConfigure = colorandConfigure;
		this.orders = orders;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getHref() {
		return href;
	}

	public int getColorandconfigureId() {
		return colorandconfigureId;
	}

	public ColorandConfigure getColorandConfigure() {
		return colorandConfigure;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setColorandconfigureId(int colorandconfigureId) {
		this.colorandconfigureId = colorandconfigureId;
	}

	public void setColorandConfigure(ColorandConfigure colorandConfigure) {
		this.colorandConfigure = colorandConfigure;
	}

	public Carousel() {
		super();
	}

	public Carousel(int id, String image, String href, int colorandconfigureId, ColorandConfigure colorandConfigure) {
		super();
		this.id = id;
		this.image = image;
		this.href = href;
		this.colorandconfigureId = colorandconfigureId;
		this.colorandConfigure = colorandConfigure;
	}

	@Override
	public String toString() {
		return "Carousel [id=" + id + ", image=" + image + ", href=" + href + ", colorandconfigureId="
				+ colorandconfigureId + ", colorandConfigure=" + colorandConfigure + "]";
	}

}

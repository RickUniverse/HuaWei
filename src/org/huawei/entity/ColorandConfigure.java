package org.huawei.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ��ɫ�����ñ�
 * @author Administrator
 *
 */
public class ColorandConfigure implements Serializable {
	/**
	 * ��ɫ������id
	 */
	private int id;
	/**
	 * ���
	 */
	private int store;
	/**
	 * �۸�
	 */
	private double price;
	/**
	 * ��ɫ��ӦͼƬ
	 */
	private String images;
	/**
	 * ������Ʒ����
	 */
	private String title;
	/**
	 * ������Ʒ����
	 */
	private String descs;
	
	/**
	 * ����id
	 */
	private int promotionId;
	/**
	 * ��Ʒid
	 */
	private int commodityId;
	/**
	 * ����id
	 */
	private int configureId;
	/**
	 * ��ɫid
	 */
	private int colorId;
	/**
	 * ��������
	 */
	private Promotion promotion;
	/**
	 * ��Ʒ����
	 */
	private Commodity commodity;
	/**
	 * ���ö���
	 */
	private Configure configure;
	/**
	 * ��ɫ����
	 */
	private Color color;
	/**
	 * ��������
	 */
	private List<Promotion> promotionLi;
	
	/**
	 * ����¥��
	 */
	private int floorId;
	/**
	 * ����¥��
	 */
	private int scormId;
	
	
	
	
	
	public int getScormId() {
		return scormId;
	}
	public void setScormId(int scormId) {
		this.scormId = scormId;
	}
	public int getFloorId() {
		return floorId;
	}
	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}
	public ColorandConfigure(int id, int store, double price, String images, String title, String descs,
			int promotionId, int commodityId, int configureId, int colorId, Promotion promotion, Commodity commodity,
			Configure configure, Color color, List<Promotion> promotionLi) {
		super();
		this.id = id;
		this.store = store;
		this.price = price;
		this.images = images;
		this.title = title;
		this.descs = descs;
		this.promotionId = promotionId;
		this.commodityId = commodityId;
		this.configureId = configureId;
		this.colorId = colorId;
		this.promotion = promotion;
		this.commodity = commodity;
		this.configure = configure;
		this.color = color;
		this.promotionLi = promotionLi;
	}
	public List<Promotion> getPromotionLi() {
		return promotionLi;
	}
	public void setPromotionLi(List<Promotion> promotionLi) {
		this.promotionLi = promotionLi;
	}
	public int getId() {
		return id;
	}
	public int getStore() {
		return store;
	}
	public double getPrice() {
		return price;
	}
	public String getImages() {
		return images;
	}
	public String getTitle() {
		return title;
	}
	public String getDescs() {
		return descs;
	}
	public int getPromotionId() {
		return promotionId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public int getConfigureId() {
		return configureId;
	}
	public int getColorId() {
		return colorId;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public Configure getConfigure() {
		return configure;
	}
	public Color getColor() {
		return color;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public void setConfigureId(int configureId) {
		this.configureId = configureId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public void setConfigure(Configure configure) {
		this.configure = configure;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public ColorandConfigure() {
		super();
	}
	public ColorandConfigure(int id, int store, double price, String images, String title, String descs,
			int promotionId, int commodityId, int configureId, int colorId, Promotion promotion, Commodity commodity,
			Configure configure, Color color) {
		super();
		this.id = id;
		this.store = store;
		this.price = price;
		this.images = images;
		this.title = title;
		this.descs = descs;
		this.promotionId = promotionId;
		this.commodityId = commodityId;
		this.configureId = configureId;
		this.colorId = colorId;
		this.promotion = promotion;
		this.commodity = commodity;
		this.configure = configure;
		this.color = color;
	}
	@Override
	public String toString() {
		return "ColorandConfigure [id=" + id + ", store=" + store + ", price=" + price + ", images=" + images
				+ ", title=" + title + ", descs=" + descs + ", promotionId=" + promotionId + ", commodityId="
				+ commodityId + ", configureId=" + configureId + ", colorId=" + colorId + ", promotion=" + promotion
				+ ", commodity=" + commodity + ", configure=" + configure + ", color=" + color + ", promotionLi="
				+ promotionLi + "]";
	}
	
	
}

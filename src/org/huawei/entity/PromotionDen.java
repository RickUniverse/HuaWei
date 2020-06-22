package org.huawei.entity;

import java.io.Serializable;

/**
 * 促销内对应商品
 * @author Administrator
 *
 */
public class PromotionDen implements Serializable {
	/**
	 * 促销内对应商品id
	 */
	private int id;
	/**
	 * 促销id
	 */
	private int promotionId;
	/**
	 * 配置颜色id
	 */
	private int colorandConfigureId;
	/**
	 * 促销对象
	 */
	private Promotion promotion;
	/**
	 * 配置颜色对象
	 */
	private ColorandConfigure colorandConfigure;
	public int getId() {
		return id;
	}
	public int getPromotionId() {
		return promotionId;
	}
	public int getColorandConfigureId() {
		return colorandConfigureId;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public ColorandConfigure getColorandConfigure() {
		return colorandConfigure;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	public void setColorandConfigureId(int colorandConfigureId) {
		this.colorandConfigureId = colorandConfigureId;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public void setColorandConfigure(ColorandConfigure colorandConfigure) {
		this.colorandConfigure = colorandConfigure;
	}
	public PromotionDen() {
		super();
	}
	public PromotionDen(int id, int promotionId, int colorandConfigureId, Promotion promotion,
			ColorandConfigure colorandConfigure) {
		super();
		this.id = id;
		this.promotionId = promotionId;
		this.colorandConfigureId = colorandConfigureId;
		this.promotion = promotion;
		this.colorandConfigure = colorandConfigure;
	}
	@Override
	public String toString() {
		return "PromotionDen [id=" + id + ", promotionId=" + promotionId + ", colorandConfigureId="
				+ colorandConfigureId + ", promotion=" + promotion + ", colorandConfigure=" + colorandConfigure + "]";
	}
	
}

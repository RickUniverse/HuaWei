package org.huawei.entity;

import java.io.Serializable;

/**
 * �����ڶ�Ӧ��Ʒ
 * @author Administrator
 *
 */
public class PromotionDen implements Serializable {
	/**
	 * �����ڶ�Ӧ��Ʒid
	 */
	private int id;
	/**
	 * ����id
	 */
	private int promotionId;
	/**
	 * ������ɫid
	 */
	private int colorandConfigureId;
	/**
	 * ��������
	 */
	private Promotion promotion;
	/**
	 * ������ɫ����
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

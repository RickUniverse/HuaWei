package org.huawei.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ��Ʒ��
 * @author Administrator
 *
 */
public class Commodity implements Serializable {
	/**
	 * ��Ʒid
	 */
	private int id;
	/**
	 * ��Ʒ����
	 */
	private String cName;
	/**
	 * ��Ʒ����id
	 */
	private int categoryId;
	/**
	 * ϵ��id
	 */
	private int seriesId;
	/**
	 * �ϼ�ʱ��
	 */
	private Date putawayTime;
	/**
	 * ��ҳ��ʾ
	 */
	private String image;
	/**
	 * ��Ʒ�������
	 */
	private Category category;
	/**
	 * ϵ�ж���
	 */
	private Series series;
	//��������Ʒ��������
	/**
	 * �ײ�id
	 * ѡ�е��ײ�
	 */
	private int comboId;
	/**
	 * ��Ʒ����ɫ����
	 */
	private List<Color> colorLi;
	/**
	 * �ײͼ���
	 */
	private List<Combo> comboLi;
	/**
	 * ���ñ�
	 */
	private List<Configure> configureLi;
	/**
	 * ��ɫ���ö���
	 */
	private ColorandConfigure colorandConfigure;
	
	
	public Commodity(int id,String cName, int categoryId, int seriesId, String image) {
		super();
		this.id = id;
		this.cName = cName;
		this.categoryId = categoryId;
		this.seriesId = seriesId;
		this.image = image;
	}
	public Commodity(String cName, int categoryId, int seriesId, String image) {
		super();
		this.cName = cName;
		this.categoryId = categoryId;
		this.seriesId = seriesId;
		this.image = image;
	}
	public Commodity(int id, String cName, int categoryId, int seriesId, Date putawayTime, String image,
			Category category, Series series, int comboId, List<Color> colorLi, List<Combo> comboLi,
			List<Configure> configureLi, ColorandConfigure colorandConfigure) {
		super();
		this.id = id;
		this.cName = cName;
		this.categoryId = categoryId;
		this.seriesId = seriesId;
		this.putawayTime = putawayTime;
		this.image = image;
		this.category = category;
		this.series = series;
		this.comboId = comboId;
		this.colorLi = colorLi;
		this.comboLi = comboLi;
		this.configureLi = configureLi;
		this.colorandConfigure = colorandConfigure;
	}
	public int getComboId() {
		return comboId;
	}
	public void setComboId(int comboId) {
		this.comboId = comboId;
	}
	public Commodity(int id, String cName, int categoryId, int seriesId, Date putawayTime, String image,
			Category category, Series series, List<Color> colorLi, List<Combo> comboLi, List<Configure> configureLi,
			ColorandConfigure colorandConfigure) {
		super();
		this.id = id;
		this.cName = cName;
		this.categoryId = categoryId;
		this.seriesId = seriesId;
		this.putawayTime = putawayTime;
		this.image = image;
		this.category = category;
		this.series = series;
		this.colorLi = colorLi;
		this.comboLi = comboLi;
		this.configureLi = configureLi;
		this.colorandConfigure = colorandConfigure;
	}
	public List<Color> getColorLi() {
		return colorLi;
	}
	public List<Combo> getComboLi() {
		return comboLi;
	}
	public List<Configure> getConfigureLi() {
		return configureLi;
	}
	public ColorandConfigure getColorandConfigure() {
		return colorandConfigure;
	}
	public void setColorLi(List<Color> colorLi) {
		this.colorLi = colorLi;
	}
	public void setComboLi(List<Combo> comboLi) {
		this.comboLi = comboLi;
	}
	public void setConfigureLi(List<Configure> configureLi) {
		this.configureLi = configureLi;
	}
	public void setColorandConfigure(ColorandConfigure colorandConfigure) {
		this.colorandConfigure = colorandConfigure;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}
	public Date getPutawayTime() {
		return putawayTime;
	}
	public void setPutawayTime(Date putawayTime) {
		this.putawayTime = putawayTime;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}
	public Commodity() {
		super();
	}
	public Commodity(int id, String cName, int categoryId, int seriesId, Date putawayTime, String image,
			Category category, Series series) {
		super();
		this.id = id;
		this.cName = cName;
		this.categoryId = categoryId;
		this.seriesId = seriesId;
		this.putawayTime = putawayTime;
		this.image = image;
		this.category = category;
		this.series = series;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", cName=" + cName + ", categoryId=" + categoryId + ", seriesId=" + seriesId
				+ ", putawayTime=" + putawayTime + ", image=" + image + ", category=" + category + ", series=" + series
				+ ", comboId=" + comboId + ", colorLi=" + colorLi + ", comboLi=" + comboLi + ", configureLi="
				+ configureLi + ", colorandConfigure=" + colorandConfigure + "]";
	}
	
	
}

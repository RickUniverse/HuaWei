package org.huawei.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品表
 * @author Administrator
 *
 */
public class Commodity implements Serializable {
	/**
	 * 商品id
	 */
	private int id;
	/**
	 * 商品名称
	 */
	private String cName;
	/**
	 * 商品种类id
	 */
	private int categoryId;
	/**
	 * 系列id
	 */
	private int seriesId;
	/**
	 * 上架时间
	 */
	private Date putawayTime;
	/**
	 * 主页显示
	 */
	private String image;
	/**
	 * 商品种类对象
	 */
	private Category category;
	/**
	 * 系列对象
	 */
	private Series series;
	//以下是商品详情所需
	/**
	 * 套餐id
	 * 选中的套餐
	 */
	private int comboId;
	/**
	 * 商品类颜色集合
	 */
	private List<Color> colorLi;
	/**
	 * 套餐集合
	 */
	private List<Combo> comboLi;
	/**
	 * 配置表
	 */
	private List<Configure> configureLi;
	/**
	 * 颜色配置对象
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

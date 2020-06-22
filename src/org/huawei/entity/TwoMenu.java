package org.huawei.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 二级菜单
 * @author Administrator
 *
 */
public class TwoMenu implements Serializable  {
	/**
	 * 二级残弹id
	 */
	private int id;
	/**
	 * 一级菜单id
	 */
	private int oneMenuid;
	/**
	 * 一级菜单对象
	 */
	private OneMenu oneMenu;
	/**
	 * 细分id
	 */
	private int seriesid;
	/**
	 * 细分集合
	 */
	private List<Series> liSeries;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOneMenuid() {
		return oneMenuid;
	}
	public void setOneMenuid(int oneMenuid) {
		this.oneMenuid = oneMenuid;
	}
	public OneMenu getOneMenu() {
		return oneMenu;
	}
	public void setOneMenu(OneMenu oneMenu) {
		this.oneMenu = oneMenu;
	}
	public int getSeriesid() {
		return seriesid;
	}
	public void setSeriesid(int seriesid) {
		this.seriesid = seriesid;
	}
	public List<Series> getLiSeries() {
		return liSeries;
	}
	public void setLiSeries(List<Series> liSeries) {
		this.liSeries = liSeries;
	}
	public TwoMenu() {
		super();
	}
	public TwoMenu(int id, int oneMenuid, OneMenu oneMenu, int seriesid, List<Series> liSeries) {
		super();
		this.id = id;
		this.oneMenuid = oneMenuid;
		this.oneMenu = oneMenu;
		this.seriesid = seriesid;
		this.liSeries = liSeries;
	}
	@Override
	public String toString() {
		return "TwoMenu [id=" + id + ", oneMenuid=" + oneMenuid + ", oneMenu=" + oneMenu + ", seriesid=" + seriesid
				+ ", liSeries=" + liSeries + "]";
	}
	
	
}

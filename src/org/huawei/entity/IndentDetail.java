package org.huawei.entity;

import java.io.Serializable;

/**
 * ������ϸʵ����
 * @author Administrator
 *
 */
public class IndentDetail implements Serializable {
	/**
	 * ��ϸid
	 */
	private int id;
	/**
	 * ����id
	 */
	private int indentId;
	/**
	 * ��ɫ����id
	 */
	private int colorAndConfigureId;
	/**
	 * �Ƿ�����
	 */
	private boolean isAppraise;
	/**
	 * �ײ�id
	 */
	private int comboId;
	/**
	 * ��Ʒ����
	 */
	private int total;
	
	/**
	 * ��ɫ���ö���
	 */
	private ColorandConfigure colorAndConfigure;
	/**
	 * �ײͶ���
	 */
	private Combo combo;
	/**
	 * ��������
	 */
	private Indent indent;
	
	
	public IndentDetail(int indentId, int colorAndConfigureId, int comboId, int total) {
		super();
		this.indentId = indentId;
		this.colorAndConfigureId = colorAndConfigureId;
		this.comboId = comboId;
		this.total = total;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public int getIndentId() {
		return indentId;
	}
	public int getColorAndConfigureId() {
		return colorAndConfigureId;
	}
	public boolean isAppraise() {
		return isAppraise;
	}
	public int getComboId() {
		return comboId;
	}
	public ColorandConfigure getColorAndConfigure() {
		return colorAndConfigure;
	}
	public Combo getCombo() {
		return combo;
	}
	public Indent getIndent() {
		return indent;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIndentId(int indentId) {
		this.indentId = indentId;
	}
	public void setColorAndConfigureId(int colorAndConfigureId) {
		this.colorAndConfigureId = colorAndConfigureId;
	}
	public void setAppraise(boolean isAppraise) {
		this.isAppraise = isAppraise;
	}
	public void setComboId(int comboId) {
		this.comboId = comboId;
	}
	public void setColorAndConfigure(ColorandConfigure colorAndConfigure) {
		this.colorAndConfigure = colorAndConfigure;
	}
	public void setCombo(Combo combo) {
		this.combo = combo;
	}
	public void setIndent(Indent indent) {
		this.indent = indent;
	}
	public IndentDetail() {
		super();
	}
	public IndentDetail(int id, int indentId, int colorAndConfigureId, boolean isAppraise, int comboId,
			ColorandConfigure colorAndConfigure, Combo combo, Indent indent) {
		super();
		this.id = id;
		this.indentId = indentId;
		this.colorAndConfigureId = colorAndConfigureId;
		this.isAppraise = isAppraise;
		this.comboId = comboId;
		this.colorAndConfigure = colorAndConfigure;
		this.combo = combo;
		this.indent = indent;
	}
	@Override
	public String toString() {
		return "IndentDetail [id=" + id + ", indentId=" + indentId + ", colorAndConfigureId=" + colorAndConfigureId
				+ ", isAppraise=" + isAppraise + ", comboId=" + comboId + ", colorAndConfigure=" + colorAndConfigure
				+ ", combo=" + combo + ", indent=" + indent + "]";
	}
	
	
	
}

package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.ColorandConfigureDao;
import org.huawei.dao.ComboDao;
import org.huawei.dao.IndentDao;
import org.huawei.dao.IndentDetailDao;
import org.huawei.entity.IndentDetail;
import org.huawei.util.BaseDao;

/**
 * 实现订单向详细类
 * @author Administrator
 *
 */
public class IndentDetailImpl extends BaseDao implements IndentDetailDao {
	/**
	 * 实现根据订单获取订单详情
	 */
	@Override
	public List<IndentDetail> selectIndentDetailByIndentId(int indentId) {
		List<IndentDetail> iLi = new ArrayList<IndentDetail>();
		ComboDao coImp = new ComboImpl();
		IndentDao iImp = new IndentImpl();
		ColorandConfigureDao clImp = new ColorandConfigureImpl();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM indentDetail AS ide WHERE ide.`indentId` = "+indentId+";");
		try {
			while(rs.next()){
				IndentDetail i = new IndentDetail();
				i.setAppraise(rs.getBoolean("ide.isAppraise"));
				i.setColorAndConfigure(clImp.selectColorandConfigureByColorandConfigureId(rs.getInt("ide.colorAndConfigureId")));
				i.setColorAndConfigureId(rs.getInt("ide.colorAndConfigureId"));
				i.setCombo(coImp.selectOneComboByComboId(rs.getInt("ide.comboId")));
				i.setComboId(rs.getInt("ide.comboId"));
				i.setId(rs.getInt("ide.id"));
				i.setIndentId(rs.getInt("ide.indentId"));
				i.setTotal(rs.getInt("ide.total"));
				iLi.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				closeAll(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return iLi;
	}
	/**
	 * 添加详细订单
	 */
	@Override
	public boolean addIndentDetail(IndentDetail i) {
		return super.executeUpdate(new Object[]{i.getIndentId(),i.getColorAndConfigureId(),false,i.getComboId(),i.getTotal()}, "INSERT INTO indentDetail(indentId,colorAndConfigureId,isAppraise,comboId,total) VALUES(?,?,?,?,?)");
	}

}

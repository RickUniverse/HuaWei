package org.huawei.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.huawei.dao.IndentStatusDao;
import org.huawei.entity.IndentStatus;
import org.huawei.util.BaseDao;

public class IndentStatusImpl extends BaseDao implements IndentStatusDao {
	/**
	 * ���ݶ���id��ѯ���ö���
	 */
	@Override
	public IndentStatus selectIndentStatusByIndentStatusId(int IndentStatusId) {
		IndentStatus i = null;
		ResultSet rs = super.executeQuery(null, "SELECT * FROM indentstate AS ids WHERE ids.`id` = "+IndentStatusId+";");
		try {
			while(rs.next()){
				i = new IndentStatus(rs.getInt("ids.id"),rs.getString("ids.sName"));
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
		return i;
	}
	/**
	 * ��ѯ�����в���������idΪ   1 �����ж���
	 */
	@Override
	public List<IndentStatus> selectIndentStatusByAll(int hUserId) {
		List<IndentStatus> isli = new ArrayList<IndentStatus>();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM indentstate AS ids WHERE ids.`id` != 1;");
		try {
			while(rs.next()){
				isli.add(new IndentStatus(rs.getInt("ids.id"),rs.getString("ids.sName"),getCountByHUserIdAndStatusId(hUserId, rs.getInt("ids.id"))));
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
		return isli;
	}
	/**
	 * ����״̬id���û�id��ѯ���û�ӵ�и�״̬�Ķ���������
	 * @param hUserId
	 * @param IndentStatusId
	 * @return
	 */
	@Override
	public int getCountByHUserIdAndStatusId(int hUserId, int IndentStatusId) {
		int count = 0;
		ResultSet rs = super.executeQuery(null, "SELECT COUNT(0) AS counts,ids.* FROM indentstate AS ids LEFT JOIN indent AS i ON i.`Stateid` = ids.`id` WHERE ids.`id` != 1 AND i.`huserid` = "+hUserId+" AND i.`Stateid` = "+IndentStatusId+" GROUP BY ids.`id`");
		try {
			while(rs.next()){
				count = rs.getInt("counts");
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
		return count;
	}
	/**
	 * ����״̬
	 */
	@Override
	public List<IndentStatus> selectIndentStatus() {
		List<IndentStatus> isli = new ArrayList<IndentStatus>();
		ResultSet rs = super.executeQuery(null, "SELECT * FROM indentstate AS ids;");
		try {
			while(rs.next()){
				isli.add(new IndentStatus(rs.getInt("ids.id"),rs.getString("ids.sName"),0));
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
		return isli;
	}

}

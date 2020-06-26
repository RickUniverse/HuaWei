package org.huawei.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	public static final String Driver = "com.mysql.jdbc.Driver";
	/*public final String url = "jdbc:mysql://localhost:3306/huawei";
	public final String user = "root";
	public final String password = "root";*/
	public final String url = "jdbc:mysql://192.168.0.108:3306/huawei";
	public final String user = "lijichen";
	public final String password = "lijichen";
	
	static{
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void closeAll(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean executeUpdate(Object[] sz , String sql){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if(sz!=null&&sz.length>0){
				for(int i = 0;i<sz.length;i++){
					pstmt.setObject(i+1, sz[i]);
				}
			}
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return rows>0;
	}
	public ResultSet executeQuery(Object[] sz , String sql){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(sz!=null&&sz.length>0){
				for(int i = 0;i<sz.length;i++){
					pstmt.setObject(i+1, sz[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}

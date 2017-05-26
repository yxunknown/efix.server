package com.cqjtu.util;

import java.sql.*;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DBConnection {
	public static Connection getConnection() {
		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/efixmanagement";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username,
					password);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet executeQueryBySql(String sql) throws SQLException {
		// 1.定义变量
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = (Statement) con.createStatement();
		rs = (ResultSet) stmt.executeQuery(sql);
		return rs;

	}

	public static boolean executeUpdateBySql(String sql) throws SQLException {
		boolean flag = false;
		Connection con = DBConnection.getConnection();
		Statement stmt = null;
		stmt = (Statement) con.createStatement();
		int r = 0;
		r = stmt.executeUpdate(sql);
		if (r != 0) {
			flag = true;
		}
		return flag;

	}

	public static void close(Connection conn, PreparedStatement pstmt,
			java.sql.ResultSet result) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * public static void main(String[] args){
	 * System.out.println(DBConnection.getConnection()); }
	 */
}

package com.cqjtu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cqjtu.util.DBConnection;
import com.cqjtu.vo.Fixer;

public class FixerDao {
	public Fixer selectByPhone(String Phone) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from fixer where fixerPhone= ?";
		try {

			pre = con.prepareStatement(sql);
			pre.setString(1, Phone);
			res = pre.executeQuery();
			while (res.next()) {
				Fixer user = new Fixer();
				user.setFixerName(res.getString(1));
				user.setPassWord(res.getString(2));
				user.setFixerPhone(res.getString(3));
				user.setIdentification(res.getString(4));
				user.setFixerAddress(res.getString(5));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	public Fixer selectByNameAndPass(String Phone,String Pass) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from fixer where fixerPhone= ? and passWord= ?";
		try {

			pre = con.prepareStatement(sql);
			pre.setString(1, Phone);
			pre.setString(2, Pass);
			res = pre.executeQuery();
			while (res.next()) {
				Fixer user = new Fixer();
				user.setFixerName(res.getString(1));
				user.setPassWord(res.getString(2));
				user.setFixerPhone(res.getString(3));
				user.setIdentification(res.getString(4));
				user.setFixerAddress(res.getString(5));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	public int fixerRegister(Fixer user) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "insert into "
				+ "fixer(fixerName,passWord,fixerPhone,identification)"
				+ "values(?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getFixerName());
			pre.setString(2, user.getPassWord());
			pre.setString(3, user.getFixerPhone());
			pre.setString(4, user.getIdentification());
			int i = pre.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}

		return 0;

	}

	public int fixerUpdate(Fixer user) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "update fixer set fixerName=?,"
				+ "passWord=?,identification=?,fixerAddress=? where fixerPhone=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getFixerName());
			pre.setString(2, user.getPassWord());
			pre.setString(3, user.getIdentification());
			pre.setString(4, user.getFixerAddress());
			pre.setString(5, user.getFixerPhone());
			int i = pre.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}

		return 0;

	}

	public int fixerDelete(String Phone) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null; // 对数据库操作的变量
		String sql = "delete from fixer where fixerPhone=?";
		// 3，创建预编译对象,编译并且获得结果集
		try {
			// 把sql语句放入数据库中编译
			pre = con.prepareStatement(sql);
			pre.setString(1, Phone);
			int i = pre.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBConnection.close(con, pre);
		}
		return 0;
	}
}

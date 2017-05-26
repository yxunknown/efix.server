package com.cqjtu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cqjtu.util.DBConnection;
import com.cqjtu.vo.User;
public class UserDao {
	public User selectByPhone(String Phone) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from user where userPhone= ?";
		try {

			pre = con.prepareStatement(sql);
			pre.setString(1, Phone);
			res = pre.executeQuery();
			while (res.next()) {
				User user = new User();
				user.setUserName(res.getString(1));
				user.setPassWord(res.getString(2));
				user.setUserPhone(res.getString(3));
				user.setUserAddress(res.getString(4));
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

	public User selectByNameAndPass(String Phone,String Pass) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from user where userPhone= ? and where passWord= ?";
		try {

			pre = con.prepareStatement(sql);
			pre.setString(1, Phone);
			pre.setString(2, Pass);
			res = pre.executeQuery();
			while (res.next()) {
				User user = new User();
				user.setUserName(res.getString(1));
				user.setPassWord(res.getString(2));
				user.setUserPhone(res.getString(3));
				user.setUserAddress(res.getString(4));
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

	public int userRegister(User user) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "insert into " + "user(userName,passWord,userPhone)"
				+ "values(?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getPassWord());
			pre.setString(3, user.getUserPhone());
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

	public int userUpdate(User user) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "update user set userName=?,"
				+ "passWord=?,userAddress=? where userPhone=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getPassWord());
			pre.setString(3, user.getUserAddress());
			pre.setString(4, user.getUserPhone());
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

	public int userDelete(String Phone) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null; // 对数据库操作的变量
		String sql = "delete from user where userPhone=?";
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

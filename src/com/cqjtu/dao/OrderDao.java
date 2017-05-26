package com.cqjtu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cqjtu.util.DBConnection;
import com.cqjtu.vo.Order;

public class OrderDao {
	public Order selectById(int id) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from order where orderId= ?";
		try {

			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			res = pre.executeQuery();
			while (res.next()) {
				Order user = new Order();
				user.setOrderId(res.getInt(1));
				user.setUserPhone(res.getString(2));
				user.setFixerPhone(res.getString(3));
				user.setBill(res.getDouble(4));
				user.setComment(res.getString(5));
				user.setCreateTime(res.getString(5));
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

	public int orderRegister(Order user) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "insert into " + "order(orderId,userPhone,fixerPhone,bill,"
				+ "comment,createTime,orderInfo)" + "values(?,?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, user.getOrderId());
			pre.setString(2, user.getUserPhone());
			pre.setString(3, user.getFixerPhone());
			pre.setDouble(4, user.getBill());
			pre.setString(5, user.getComment());
			pre.setString(6, user.getCreateTime());
			pre.setString(7, user.getOrderInfo());
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

	public int orderUpdate(Order user) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "update fixer set userPhone=?,"
				+ "fixerPhone=?,bill=?,comment=?,createTime=?,orderInfo=? where orderId=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getUserPhone());
			pre.setString(2, user.getFixerPhone());
			pre.setDouble(3, user.getBill());
			pre.setString(4, user.getComment());
			pre.setString(5, user.getCreateTime());
			pre.setString(6, user.getOrderInfo());
			pre.setInt(7, user.getOrderId());
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

	public int orderDelete(int id) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null; // 对数据库操作的变量
		String sql = "delete from order where orderId=?";
		// 3，创建预编译对象,编译并且获得结果集
		try {
			// 把sql语句放入数据库中编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, id);
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

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Order;
import com.util.Pool;

public class OrderDaoImpl implements OrderDao{
    private Pool pool = new Pool();
    private Connection ct;
	@Override
	public Order getOrderById(int id) {
		ct = pool.getConnect();
		String sql = "select * from orders where BuyerId=?";
	
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				Order order = new Order();
				order.setBuyerId(rs.getInt("BuyerId"));
				order.setListId(rs.getString("ListId"));
				order.setBuyerName(rs.getString("BuyerName"));
				order.setDate(rs.getTimestamp("createTime"));
				return order;
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
    
}

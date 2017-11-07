package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.OrderMesg;
import com.util.Pool;

public class OrderMesgDaoImpl implements OrderMesgDao{
    private Pool pool = new Pool();
    private Connection ct;
	@Override
	public List getOrderMesgById(String id) {
		ct = pool.getConnect();
		String sql = "select * from ordermesg where orderid=?";
		List list = new ArrayList();
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				OrderMesg om = new OrderMesg();
				om.setOrderid(rs.getString("orderid"));
				om.setGoodsid(rs.getString("goodsid"));
				om.setGoodsName(rs.getString("goodsName"));
				om.setGoodsnum(rs.getInt("goodsnum"));
				om.setCount(rs.getDouble("count"));
				om.setTotal(rs.getDouble("total"));
				
				list.add(om);
			}
			rs.close();
			psmt.close();
			return list;
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

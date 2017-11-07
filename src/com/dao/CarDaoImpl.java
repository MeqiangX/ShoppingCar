package com.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;

import com.bean.Car;
import com.bean.CartItem;
import com.bean.User;
import com.util.OrderId;
import com.util.Pool;

//购物车只将最后的购物项记录在数据库，其他时间都放在服务器的Session中
public class CarDaoImpl implements CarDao{
    public  Connection ct;
    public OrderId oi = new OrderId();
	@Override
	public void SavaInDB(Car car,String orderid) {
		// TODO Auto-generated method stub
		ct = Pool.getConnect();
		String sql = "insert into ordermesg value(?,?,?,?,?,?)";
		//订单id,物品Id,物品名字,物品数量,单价，总价.
		
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			Map<String,CartItem> map = car.getList();
			for (String key:map.keySet()) {
				psmt.setString(1, orderid);
				psmt.setString(2, map.get(key).getBook().getId());
				psmt.setString(3, map.get(key).getBook().getName());
				psmt.setInt(4, map.get(key).getCount());
				psmt.setDouble(5, map.get(key).getBook().getPrice());
				psmt.setDouble(6, map.get(key).getTotal());
				
				psmt.execute();
			}
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
		
	}
     /**1.随机生成订单号（判断订单号是否重复）
      * 2.获得Userid
      * 3.产生订单时间
      * 4.对象插入数据库
      * 
      * 1.获得订单号
      * 2.获得Car的Map的物品的ID插入多条记录
      * 
      */
	public String ProduceOrder(Car car,User user) {
		ct = Pool.getConnect();
		String orderid= oi.Randomid();
		
		String sql = "select ListId from orders where ListId=?";
		String sql2 = "insert into orders value(?,?,?,?)";
		//BuyerId,Orderid,BuyerName,date
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setString(1, orderid);
			ResultSet rs = psmt.executeQuery();
			
			if (!rs.next()) {
				java.util.Date date=new java.util.Date();
				PreparedStatement psmt2 = ct.prepareStatement(sql2);
				psmt2.setInt(1, user.getId());
				psmt2.setString(2, orderid);
				psmt2.setString(3, user.getName());
				psmt2.setTimestamp(4, new Timestamp(date.getTime()));
				psmt2.execute();
				
				psmt2.close();
			
				return orderid;
			}
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

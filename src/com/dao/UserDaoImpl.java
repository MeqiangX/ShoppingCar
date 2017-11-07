package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.bean.User;
import com.util.Pool;

public class UserDaoImpl implements UserDao{
	private Pool pool = new Pool();
    private Connection ct;
	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		ct = pool.getConnect();
		String sql = "select * from book";
		List list = new ArrayList();
		try {
			Statement st = ct.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Book book = new Book(rs.getString("id"),rs.getString("name"),rs.getString("auther")
						,rs.getDouble("price"));
				list.add(book);
			}
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

	@Override
	public Book getById(String id) {
		// TODO Auto-generated method stub
		ct = pool.getConnect();
		String sql = "select * from book where id=?";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				return new Book(rs.getString("id"),rs.getString("name"),rs.getString("auther")
						,rs.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public User Login(String name,String password) {
		// TODO Auto-generated method stub
		ct = pool.getConnect();
		String sql = "select * from User where name=? and password=?";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				User user = new User(rs.getString("name"),rs.getString("password"));
				user.setId(rs.getInt("id"));
				return user;
			}
				
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

	@Override
	public void Signup(User user) {
		// TODO Auto-generated method stub
		ct = pool.getConnect();
		String sql = "insert into User(name,password) value(?,?)";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			psmt.executeUpdate();
			
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
    
}

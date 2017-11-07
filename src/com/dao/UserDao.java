package com.dao;

import java.util.List;

import com.bean.Book;
import com.bean.User;

public interface UserDao {
     public List getAll();
     
     public Book getById(String id);
     
     public User Login(String name,String password);
     
     public void Signup(User user);
}

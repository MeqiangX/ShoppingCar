package com.service;

import java.util.List;

import com.bean.Book;
import com.bean.Car;
import com.bean.CartItem;
import com.bean.User;
import com.dao.CarDaoImpl;
import com.dao.UserDaoImpl;

public class UserService {
     private  UserDaoImpl usd = new UserDaoImpl();
     private CarDaoImpl cdi = new CarDaoImpl();
     public List getAll() {
    	 return usd.getAll();
     }
     
     public Book getById(String id) {
    	 return usd.getById(id);
     }
     
     public User Login(String name,String password) {
    	 return usd.Login(name, password);
     }
     
     public void Signup(User user) {
    	 usd.Signup(user);
     }
     
     public void clear(Car car) {
    	 car.getList().clear(); //map的clear方法把map置空
     }
     
     public void update(int count,String id,Car car) {
    	 CartItem cart = car.getList().get(id);
    	 cart.setCount(count);
     }
     
     public void delete(String id,Car car) {
    	 car.getList().remove(id);
     }
     
     public void Buy(Car car,User user) {
    	 String orderid;
    	 while ((orderid = cdi.ProduceOrder(car, user)) == null) {
    		
    	 }
    	 cdi.SavaInDB(car, orderid);
     }
}

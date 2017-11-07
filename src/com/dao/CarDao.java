package com.dao;
import com.bean.Car;
import com.bean.User;

public interface CarDao {
      public void SavaInDB(Car car,String orderid);
      
      public String ProduceOrder(Car car,User user) ;
      
}

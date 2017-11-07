package com.service;

import java.util.List;
import com.bean.Order;
import com.dao.OrderDaoImpl;
import com.dao.OrderMesgDaoImpl;

public class OrderService {
	private OrderDaoImpl odi = new OrderDaoImpl();
	private OrderMesgDaoImpl omdi = new OrderMesgDaoImpl();
	
    public Order getOrder(int buyerid) {
    	return odi.getOrderById(buyerid);
    }
    
    public List getOrderMesg(String orderid) {
    	return omdi.getOrderMesgById(orderid);
    }
} 

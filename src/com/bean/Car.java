package com.bean;


import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
    private  Map<String,CartItem> map = new LinkedHashMap();
    private  double all_prices;
    
    
    public void add(Book book) {
    
    	CartItem cart = map.get(book.getId());
    	if (cart == null) {
    		//购物车里没有该项物品，加到Map中，数量为1
    		cart = new CartItem();
    		cart.setBook(book);
    		cart.setCount(1);
    		map.put(book.getId(), cart);
    	}
    	else { //不为空则购物车里还该项物品，则对其数量加一
    		cart.setCount(cart.getCount()+1);
    	}
    }
	public Map<String, CartItem> getList() {
		return map;
	}
	
	public  void setList(Map<String, CartItem> map) {
		this.map = map;
		
	} 
	
	public double getAll_prices() {
		double total = 0;
		//map的KeySet方法放回键的列表，通过键遍历值
		for (String key: map.keySet()) {
			total += map.get(key).getTotal();
		}
		this.all_prices = total;
		
		return all_prices;
	}
	
	public void setAll_prices(double all_prices) {
		this.all_prices = all_prices;
	}
    
    
}

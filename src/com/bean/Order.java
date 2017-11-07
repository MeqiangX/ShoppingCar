package com.bean;

import java.sql.Timestamp;

public class Order {
   private int BuyerId;
   private String ListId;
   private String BuyerName;
   private Timestamp date;
   
   public Order() {  
	   
	   
   }

public int getBuyerId() {
	return BuyerId;
}

public void setBuyerId(int buyerId) {
	BuyerId = buyerId;
}

public String getListId() {
	return ListId;
}

public void setListId(String listId) {
	ListId = listId;
}

public String getBuyerName() {
	return BuyerName;
}

public void setBuyerName(String buyerName) {
	BuyerName = buyerName;
}

public Timestamp getDate() {
	return date;
}

public void setDate(Timestamp date) {
	this.date = date;
}
   
   
   
   
}

package com.util;

import java.util.Random;

public class OrderId {
     public String orderid = "asdfghjzxcvbbmQWERTYUIAO1234567890"; 
     public Random r = new Random();//生成随机数函数；
     public static int idlen = 14;
     
     public String Randomid() { //多个随机char组合的orderid
    	 String id = "";
    	 for (int i = 0; i < idlen; i++) {
    		 id = id + randomchar(); 
    	 }
    	 
    	 return id;
    	 
     }
     
     public char randomchar() { //生成一个随机char
    	 int index = r.nextInt(orderid.length()); //生成0—orderid.length之间的随机数
    	 char c = orderid.charAt(index);
    	 return c;
     }
}

package com.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;




public class Pool {
    private static BasicDataSource datasource = new BasicDataSource();
    //1.创建连接池对象 BasicDataSource 重写了close方法,将用完的连接还给连接池，而不是关闭
    //静态代码块，类加载时执行配置连接池
    static {
    	Properties pr = new Properties();
    	try {
//    		FileInputStream fs = new FileInputStream("src/DBconfig.properties");
//    		
//    	    pr.load(fs);
			

    		pr.load(Pool.class.getClassLoader().getResourceAsStream("DBconfig.properties"));
   		
			datasource.setDriverClassName(pr.getProperty("driver"));
			datasource.setUrl(pr.getProperty("url"));
			datasource.setUsername(pr.getProperty("user"));
			datasource.setPassword(pr.getProperty("password"));
  		  		
    		
//    		datasource.setDriverClassName("com.mysql.jdbc.Driver");
//			datasource.setUrl("jdbc:mysql://localhost:3306/car");
//			datasource.setUsername("root");
//			datasource.setPassword("123456");
			//配置四大参数
			
			
			//配置池参数  最小空闲连接数 最大连接数 最长等待时间
			
			datasource.setMinIdle(3);
            datasource.setMaxTotal(20);
            datasource.setMaxWaitMillis(1000);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    public static Connection getConnect() {
    	Connection ct;
    	try {
			ct = datasource.getConnection();
			return ct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
}



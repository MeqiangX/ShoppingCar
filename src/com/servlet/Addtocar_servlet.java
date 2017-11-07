package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.bean.Car;
import com.service.UserService;

/**
 * Servlet implementation class Addtocar_servlet
 */
@WebServlet("/Addtocar_servlet")
public class Addtocar_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addtocar_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id= request.getParameter("bookid");//通过URL得到要购买的书的ID
		//通过ID找到BOOk加入到购物车
		
		UserService us = new UserService();
		Book book = us.getById(id);
		
		Car car = (Car)request.getSession().getAttribute("Car");
		if (car == null) { //car 为空 说明服务器的Session中没有保存car ，建立一个并存入Session中
			car = new Car();
			request.getSession().setAttribute("Car", car);
		}
		
		  //否则在服务器Session中就保存了购物车信息，这是只要拿到Session中保存的Car(前面已经拿了) ,将书加入购物车即可
			car.add(book);
		
		
		request.getRequestDispatcher("/Show_controlor").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

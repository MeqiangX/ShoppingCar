package com.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Car;
import com.bean.CartItem;
import com.service.UserService;

/**
 * Servlet implementation class Opreat_servlet
 */
@WebServlet("/Opreater_servlet")
public class Opreater_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Opreater_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int action = Integer.parseInt(request.getParameter("action"));
		String id = request.getParameter("id");
		
		UserService us = new UserService();
		Car car = (Car)request.getSession().getAttribute("Car");
		if (action == 1) {
			us.delete(id, car);

		}
		else if (action == 2) {
			us.clear(car);
		}
		else if (action == 3) {
			us.update((int)Integer.parseInt(request.getParameter("count")), id, car);
			
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/Account.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

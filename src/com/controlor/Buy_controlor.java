package com.controlor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Order;
import com.bean.User;
import com.service.OrderService;

/**
 * Servlet implementation class Buy_controlor
 */
@WebServlet("/Buy_controlor")
public class Buy_controlor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy_controlor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderService os = new OrderService();
		Order or = os.getOrder(((User)request.getSession().getAttribute("user")).getId());
		
		List list = os.getOrderMesg(or.getListId());
		
		request.setAttribute("order", or);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/jsp/order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

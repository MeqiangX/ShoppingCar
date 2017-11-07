package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;

/**
 * Servlet implementation class Sig_servlet
 */
@WebServlet("/Sig_servlet")
public class Sig_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sig_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    String passwd = request.getParameter("passwd");
	    String Mes = "";
	    
	    if (!passwd.equals(password)) {
	        Mes = "两次密码不一致";
	    	request.setAttribute("Mes",Mes);
	    	request.getRequestDispatcher("/WEB-INF/jsp/Signup.jsp").forward(request, response);
	    }
	    
	    else {
	    	User user = new User(name,password);
	    	UserService us = new UserService();
	    	us.Signup(user);
	    	request.getRequestDispatcher("/index.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.huawei.dao.AdminDao;
import org.huawei.dao.impl.AdminImpl;
import org.huawei.entity.Admin;
@WebServlet(urlPatterns="/AdminLoginServlet.shtml")
public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		AdminDao aImp = new AdminImpl();
		Admin admin = aImp.loginByANameAndPassword(request.getParameter("aName"), request.getParameter("aPassword"));
		if(admin!=null){
			request.getSession().setAttribute("admin", admin);
			response.getWriter().print(true);
		}else{
			response.getWriter().print(false);
		}
		/*request.getRequestDispatcher("AdminIndexServlet.shtml").forward(request, response);*/
		
		/*response.sendRedirect(request.getContextPath()+"/AdminIndexServlet.shtml");*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

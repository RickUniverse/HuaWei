package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.AdminDao;
import org.huawei.dao.HUserDao;
import org.huawei.dao.impl.AdminImpl;
import org.huawei.dao.impl.HUserImpl;

import com.alibaba.fastjson.JSON;
@WebServlet(urlPatterns="/AdminIndexServlet.shtml")
public class AdminIndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		
		AdminDao aImp = new AdminImpl();
		request.getSession().setAttribute("admin", aImp.loginByANameAndPassword("admin", "123123"));
		if(action!=null&&!action.equals("")){
			if(action.equals("tagWelcome")){
				request.getRequestDispatcher("backend/welcome.jsp").forward(request, response);
			}else if(action.equals("getAdmin")){
				response.getWriter().print(JSON.toJSONString(aImp.loginByANameAndPassword("admin", "123123")));
			}
		}else
			request.getRequestDispatcher("backend/index.jsp").forward(request, response);
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

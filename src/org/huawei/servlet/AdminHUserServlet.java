package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.HUserDao;
import org.huawei.dao.impl.HUserImpl;
import org.huawei.entity.PageBean;
@WebServlet(urlPatterns="/AdminHUserServlet.shtml")
public class AdminHUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//用户实现类
		HUserDao huImp = new HUserImpl();
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		//隐藏分页
		String hidPage = request.getParameter("hidPage");
		
		
		PageBean page = new PageBean();
		page.setTotalCount(huImp.totalCountHUser());
		page.setPageSize(5);
		page.setPageNo(hidPage!=null&&!hidPage.equals("") ? Integer.parseInt(hidPage) : 1);
		
		session.setAttribute("huLi", huImp.selectAllHUser(page.getPageNo(), page.getPageSize()));
		session.setAttribute("page", page);
		request.getRequestDispatcher("backend/member-list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

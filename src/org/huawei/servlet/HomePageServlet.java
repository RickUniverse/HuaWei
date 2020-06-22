package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.huawei.dao.FloorDao;
import org.huawei.dao.HUserDao;
import org.huawei.dao.OneMenuDao;
import org.huawei.dao.impl.CarouselImpl;
import org.huawei.dao.impl.FloorImpl;
import org.huawei.dao.impl.HUserImpl;
import org.huawei.dao.impl.OneMenuImpl;
@WebServlet(urlPatterns="/HomePageServlet.shtml")
public class HomePageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String path = request.getContextPath();
		String active = request.getParameter("active");
		
		OneMenuDao oimp = new OneMenuImpl();
		FloorDao fimp = new FloorImpl();
		HUserDao himp = new HUserImpl();
		//¬÷≤• µœ÷¿‡
		CarouselImpl cimp = new CarouselImpl();
		
		request.getSession().setAttribute("huser", himp.selectHUserById(1));
		if(active==null||active.equals("")){
			request.getSession().setAttribute("omli", oimp.selectOneMenuByAll());
			request.getSession().setAttribute("fLi", fimp.selectFloorByAll());
			request.getSession().setAttribute("carLi", cimp.selectAllCarousel());
			request.getRequestDispatcher("/reception/HomePage.jsp").forward(request, response);
		}else if(active.equals("removeHuser")){
			request.getSession().removeAttribute("huser");
			request.getRequestDispatcher("/reception/HomePage.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

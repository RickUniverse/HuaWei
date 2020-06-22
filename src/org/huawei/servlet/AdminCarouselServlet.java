package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.CarouselDao;
import org.huawei.dao.impl.CarouselImpl;
import org.huawei.entity.Carousel;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
@WebServlet(urlPatterns="/AdminCarouselServlet.shtml")
public class AdminCarouselServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		
		//轮播实现类
		CarouselDao cimp = new CarouselImpl();
		
		if(action!=null&&!action.equals("")){
			if(action.equals("addCarousel")){
				SmartUpload smart = new SmartUpload();
				smart.setCharset("utf-8");
				smart.initialize(this, request, response);
				try {
					smart.upload();
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
				Request req = smart.getRequest();
				String href = req.getParameter("href");
				String order = req.getParameter("order");
				String couId = req.getParameter("couId");
				String photo = "";
				Files files = smart.getFiles();
				File file = files.getFile(0);
				try {
					file.saveAs("/homeimage/carouselimg/"+file.getFileName());
					photo = "homeimage/carouselimg/"+file.getFileName();
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
				//保存到数据库
				Carousel c = new Carousel();
				c.setHref(href);
				c.setColorandconfigureId(Integer.parseInt(couId));
				c.setOrders(Integer.parseInt(order));
				c.setImage(photo);
				cimp.AddCarousel(c);
			}else if(action.equals("updateCarousel")){
				response.getWriter().print(cimp.updateCarousel(request.getParameter("href"), Integer.parseInt(request.getParameter("order")), Integer.parseInt(request.getParameter("carId"))));
				return;
			}else if(action.equals("deleteCarousel")){
				response.getWriter().print(cimp.deleteCarousel(Integer.parseInt(request.getParameter("carId"))));
				return;
			}
		}
		
		request.getSession().setAttribute("carouselLi", cimp.selectAllCarousel());
		request.getRequestDispatcher("backend/carousel.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

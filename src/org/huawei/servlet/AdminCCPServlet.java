package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.ColorDao;
import org.huawei.dao.ConfigureDao;
import org.huawei.dao.PromotionDao;
import org.huawei.dao.impl.ColorImpl;
import org.huawei.dao.impl.ConfigureImpl;
import org.huawei.dao.impl.PromotionImpl;
import org.huawei.entity.PageBean;
@WebServlet(urlPatterns="/AdminCCPServlet.shtml")
public class AdminCCPServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		
		ColorDao coImp = new ColorImpl();
		ConfigureDao cdImp = new ConfigureImpl();
		PromotionDao pImp = new PromotionImpl();
		
		if(action!=null&&!action.equals("")){
			if(action.equals("addColor")){
				coImp.addColor(request.getParameter("addColorName"));
			}else if(action.equals("removeColor")){
				response.getWriter().print(coImp.deleteColor(Integer.parseInt(request.getParameter("colorId"))));
			}else if(action.equals("addConf")){
				cdImp.addConfigure(request.getParameter("addconfName"));
			}else if(action.equals("removeConf")){
				response.getWriter().print(cdImp.deleteConfigureId(Integer.parseInt(request.getParameter("confId"))));
			}else if(action.equals("addpro")){
				pImp.addPromotion(request.getParameter("addtit"), request.getParameter("addcon"));
			}else if(action.equals("removepro")){
				response.getWriter().print(pImp.deletePromotion(Integer.parseInt(request.getParameter("proId"))));
			}
			
		}
		
		
		//—’…´
		String colorName = request.getParameter("colorName");
		PageBean pageColor = new PageBean();
		pageColor.setPageSize(15);
		pageColor.setTotalCount(coImp.getTotalCount(colorName));
		
		String getPageColor = request.getParameter("getPageColor");
		if(getPageColor!=null&&!getPageColor.equals("")){
			pageColor.setPageNo(Integer.parseInt(getPageColor));
		}
		session.setAttribute("colorName", colorName);
		session.setAttribute("pageColor", pageColor);
		session.setAttribute("colorLi", coImp.selectAllColorBycName(colorName, pageColor.getPageNo(), pageColor.getPageSize()));
		
		//≈‰÷√
		String confName = request.getParameter("confName");
		PageBean pageconf = new PageBean();
		pageconf.setPageSize(15);
		pageconf.setTotalCount(cdImp.getTotalCount(confName));

		String getPageConf = request.getParameter("getPageConf");
		if (getPageConf != null && !getPageConf.equals("")) {
			pageconf.setPageNo(Integer.parseInt(getPageConf));
		}
		session.setAttribute("confName", confName);
		session.setAttribute("pageconf", pageconf);
		session.setAttribute("confLi",
				cdImp.selectAllConfiguresBycName(confName, pageconf.getPageNo(), pageconf.getPageSize()));
		
		//¥Ÿœ˙
		String proName = request.getParameter("proName");
		PageBean pagepro = new PageBean();
		pagepro.setPageSize(6);
		pagepro.setTotalCount(pImp.getTotalCount(proName));

		String getPagePro = request.getParameter("getPagePro");
		if (getPagePro != null && !getPagePro.equals("")) {
			pagepro.setPageNo(Integer.parseInt(getPagePro));
		}
		session.setAttribute("proName", proName);
		session.setAttribute("pagepro", pagepro);
		session.setAttribute("proLi",
				pImp.selectAllPromotionByTitle(proName, pagepro.getPageNo(), pagepro.getPageSize()));
		
		request.getRequestDispatcher("backend/color-configure-promotion.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

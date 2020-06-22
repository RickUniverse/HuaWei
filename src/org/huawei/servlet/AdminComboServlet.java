package org.huawei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.ComboCommodityDao;
import org.huawei.dao.ComboDao;
import org.huawei.dao.impl.ComboCommodityImpl;
import org.huawei.dao.impl.ComboImpl;
import org.huawei.entity.Combo;
import org.huawei.entity.PageBean;
@WebServlet(urlPatterns="/AdminComboServlet.shtml")
public class AdminComboServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		
		ComboDao coImp = new ComboImpl();
		ComboCommodityDao commImp = new ComboCommodityImpl();
		
		if(action!=null&&!action.equals("")){
			if(action.equals("addCom")){//String cName, double price, int commodityId, double huiPrice
				coImp.addCombo(new Combo(request.getParameter("comboName"),Double.parseDouble(request.getParameter("price")),Integer.parseInt(request.getParameter("commodityId")),Double.parseDouble(request.getParameter("huiPrice"))));
				response.sendRedirect(path+"/AdminComboServlet.shtml");
				return;
			}else if(action.equals("addComm")){
				commImp.addComboCommodity(Integer.parseInt(request.getParameter("add-comboId")), Integer.parseInt(request.getParameter("add-comodityId")));
				response.sendRedirect(path+"/AdminComboServlet.shtml");
				return;
			}else if(action.equals("removeCom")){
				out.print(coImp.deleteCombo(Integer.parseInt(request.getParameter("comId"))));
				return;
			}else if(action.equals("removeComm")){
				out.print(commImp.removeComboCommodity(Integer.parseInt(request.getParameter("commId"))));
				return;
			}
			
			
		}

		//Ì×²Í
		String comboName = request.getParameter("comboNames");
		String commodityName = request.getParameter("commodityName");
		PageBean pageCom = new PageBean();
		pageCom.setPageSize(6);
		pageCom.setTotalCount(coImp.getTotalCount(comboName,commodityName));

		String getPageCom = request.getParameter("getPageCom");
		if (getPageCom != null && !getPageCom.equals("")) {
			pageCom.setPageNo(Integer.parseInt(getPageCom));
		}
		/*session.setAttribute("comboName", comboName);
		session.setAttribute("commodityName", commodityName);*/
		session.setAttribute("pageCom", pageCom);
		session.setAttribute("comboLi",
				coImp.selectAllComboByComboName(comboName, commodityName, pageCom.getPageNo(), pageCom.getPageSize()));

		//Ì×²ÍÄÚÉÌÆ·
		String comboNameTwo = request.getParameter("comboNameTwo");
		String commodityNameTwo = request.getParameter("commodityNameTwo");
		PageBean pageComm = new PageBean();
		pageComm.setPageSize(6);
		pageComm.setTotalCount(commImp.getTotalCount(comboNameTwo, commodityNameTwo));

		String getPageComm = request.getParameter("getPageComm");
		if (getPageComm != null && !getPageComm.equals("")) {
			pageComm.setPageNo(Integer.parseInt(getPageComm));
		}
		/*session.setAttribute("comboNameTwo", comboNameTwo);
		session.setAttribute("commodityNameTwo", commodityNameTwo);*/
		session.setAttribute("pageComm", pageComm);
		session.setAttribute("combocommLi",
				commImp.selectAllComboByComboId(comboNameTwo, commodityNameTwo, pageComm.getPageNo(), pageComm.getPageSize()));
		
		request.getRequestDispatcher("backend/combo.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

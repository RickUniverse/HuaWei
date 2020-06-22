package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.CommodityDao;
import org.huawei.dao.ShoppingCartDao;
import org.huawei.dao.impl.CommodityImpl;
import org.huawei.dao.impl.ShoppingCartImpl;
import org.huawei.entity.Commodity;
import org.huawei.entity.HUser;
@WebServlet(urlPatterns="/DetailServlet.shtml")
public class DetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取session作用域对象
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		//根目录
		String path = request.getContextPath();
		//穿过来的颜色配置id
		String colorandConfigureId = request.getParameter("colorandConfigureId");
		//表单提交过来的颜色id
		String hidcolor = request.getParameter("hidcolor");
		//表单提交过来的配置id
		String hidconfigureId = request.getParameter("hidconfigureId");
		//表单提交过来的当前商品id
		String hidcommodity = request.getParameter("hidcommodity");
		//表单提交过来的当前商品id
		String hidcombo = request.getParameter("hidcombo");
		
		
		//商品实现类
		CommodityDao comImp = new CommodityImpl();
		//购物车实现类
		ShoppingCartDao scimp = new ShoppingCartImpl();
		
		if(action==null||action.equals("")){
			Commodity commodity = comImp.selectCommodityByColorandConfigureId(colorandConfigureId!=null&!colorandConfigureId.equals("")?Integer.parseInt(colorandConfigureId):1);
			session.setAttribute("commodity", commodity);
			request.getRequestDispatcher("/reception/Details.jsp").forward(request, response);
		}else if(action.equals("hidCul")){
			session.setAttribute("commodity", comImp.selectCommodityByCommodityIdAndColorIdAndConfigureId(Integer.parseInt(hidcommodity) , Integer.parseInt(hidcolor), Integer.parseInt(hidconfigureId), Integer.parseInt(hidcombo)));
			request.getRequestDispatcher("/reception/Details.jsp").forward(request, response);
		}else if (action.equals("addCart")) {
			// 表单提交过来的当前商数量
			String hidtotal = request.getParameter("hidtotal");
			// 表单提交过来的当前商价格
			String hidprice = request.getParameter("hidprice");
			// 表单提交过来的当前商用户id
			String hidhuser = request.getParameter("hidhuser");
			// 表单提交过来的当前套餐价格
			String comboprice = request.getParameter("comboprice");
			response.getWriter().print(scimp.addShoppingCart(Integer.parseInt(colorandConfigureId), Integer.parseInt(hidtotal),
					Double.valueOf(hidtotal) * Double.valueOf(hidprice) + Double.valueOf(comboprice), Integer.parseInt(hidcombo),
					Integer.parseInt(hidhuser)));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

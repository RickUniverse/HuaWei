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
		
		//��ȡsession���������
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		//��Ŀ¼
		String path = request.getContextPath();
		//����������ɫ����id
		String colorandConfigureId = request.getParameter("colorandConfigureId");
		//���ύ��������ɫid
		String hidcolor = request.getParameter("hidcolor");
		//���ύ����������id
		String hidconfigureId = request.getParameter("hidconfigureId");
		//���ύ�����ĵ�ǰ��Ʒid
		String hidcommodity = request.getParameter("hidcommodity");
		//���ύ�����ĵ�ǰ��Ʒid
		String hidcombo = request.getParameter("hidcombo");
		
		
		//��Ʒʵ����
		CommodityDao comImp = new CommodityImpl();
		//���ﳵʵ����
		ShoppingCartDao scimp = new ShoppingCartImpl();
		
		if(action==null||action.equals("")){
			Commodity commodity = comImp.selectCommodityByColorandConfigureId(colorandConfigureId!=null&!colorandConfigureId.equals("")?Integer.parseInt(colorandConfigureId):1);
			session.setAttribute("commodity", commodity);
			request.getRequestDispatcher("/reception/Details.jsp").forward(request, response);
		}else if(action.equals("hidCul")){
			session.setAttribute("commodity", comImp.selectCommodityByCommodityIdAndColorIdAndConfigureId(Integer.parseInt(hidcommodity) , Integer.parseInt(hidcolor), Integer.parseInt(hidconfigureId), Integer.parseInt(hidcombo)));
			request.getRequestDispatcher("/reception/Details.jsp").forward(request, response);
		}else if (action.equals("addCart")) {
			// ���ύ�����ĵ�ǰ������
			String hidtotal = request.getParameter("hidtotal");
			// ���ύ�����ĵ�ǰ�̼۸�
			String hidprice = request.getParameter("hidprice");
			// ���ύ�����ĵ�ǰ���û�id
			String hidhuser = request.getParameter("hidhuser");
			// ���ύ�����ĵ�ǰ�ײͼ۸�
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

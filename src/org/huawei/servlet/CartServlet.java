package org.huawei.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.HUserDao;
import org.huawei.dao.ShoppingCartDao;
import org.huawei.dao.impl.HUserImpl;
import org.huawei.dao.impl.ShoppingCartImpl;
import org.huawei.entity.HUser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
@WebServlet(urlPatterns="/CartServlet.shtml")
public class CartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡsession���������
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		HUser hu = (HUser)session.getAttribute("huser");
		if(hu==null){
			response.sendRedirect(path+"/HomePageServlet.shtml");
			return;
		}
		//��ȡ�û�id
		String hUserId = request.getParameter("hidhuser");
		//��ȡ�Ƿ�Ϊѡ����Ʒ
		String checked = request.getParameter("checked");
		//�޸ĵ���Ʒ
		String ShoppingCartId = request.getParameter("ShoppingCartId");
		//true��+     false��-
		String isThat = request.getParameter("isThat");
		
		//���ﳵʵ����
		ShoppingCartDao scimp = new ShoppingCartImpl();
		//�û�ʵ����
		HUserDao huImp = new HUserImpl();
		if(action==null||action.equals("")){
			if(hUserId!=null&&!hUserId.equals("0")){
				session.setAttribute("scLi", scimp.selectAllShoppingCartByUserId(Integer.parseInt(hUserId)));
			}
			request.getRequestDispatcher("/reception/Cart.jsp").forward(request, response);
		}else if(action.equals("checkedOne")){
			if(ShoppingCartId==null||ShoppingCartId.equals("0")&&hUserId!=null){
				scimp.updateShoppingCartCheckedByHUserId(Integer.parseInt(hUserId),Boolean.parseBoolean(checked));
			}else{
				scimp.updateShoppingCartCheckedByShoppingCartId(Integer.parseInt(ShoppingCartId),Boolean.parseBoolean(checked));
			}
			HUser huser = huImp.selectHUserById(Integer.parseInt(hUserId));
			session.setAttribute("huser",huser);
			response.getWriter().print(JSON.toJSONString(huser));
		}else if(action.equals("delete")){
			if(ShoppingCartId!=null&&!ShoppingCartId.equals("0")){
				scimp.deleteShoppingCartByShoppingCartId(Integer.parseInt(ShoppingCartId));
			}else{
				JSONArray spId = JSON.parseArray(request.getParameter("array"));
				for(Object item : spId){
					scimp.deleteShoppingCartByShoppingCartId(Integer.parseInt(item.toString()));
				}
			}
			HUser huser = huImp.selectHUserById(Integer.parseInt(hUserId));
			session.setAttribute("huser",huser);
			response.getWriter().print(JSON.toJSONString(huser));
		}else if(action.equals("subtractAndAdd")){
			List list = new ArrayList();
			list.add(scimp.updateNumberByShoppingCartId(Boolean.parseBoolean(isThat), Integer.parseInt(ShoppingCartId)));
			HUser huser = huImp.selectHUserById(Integer.parseInt(hUserId));
			list.add(huser);
			session.setAttribute("huser",huser);
			response.getWriter().print(JSON.toJSONString(list));
		}else if(action.equals("goSettlement")){
			session.setAttribute("huser", null);
			//�����ǲ��򵽡����������Űɡ�����������������
			/*HUser hu = (HUser)session.getAttribute("huser");
			if(hu==null){
				response.sendRedirect(path+"/HomePageServlet.shtml");
				System.out.println(hu);
				return;
			}*/
			
			int checkedCount = scimp.getCheckedShoppingCartTotalByHUserId(Integer.parseInt(hUserId));
			response.getWriter().print(checkedCount>=1 ? true : false);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

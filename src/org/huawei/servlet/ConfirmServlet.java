package org.huawei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.AddressDao;
import org.huawei.dao.HUserDao;
import org.huawei.dao.IndentDao;
import org.huawei.dao.IndentDetailDao;
import org.huawei.dao.ShoppingCartDao;
import org.huawei.dao.impl.AddressImpl;
import org.huawei.dao.impl.HUserImpl;
import org.huawei.dao.impl.IndentDetailImpl;
import org.huawei.dao.impl.IndentImpl;
import org.huawei.dao.impl.ShoppingCartImpl;
import org.huawei.entity.Address;
import org.huawei.entity.Indent;
import org.huawei.entity.IndentDetail;
import org.huawei.entity.ShoppingCart;

import com.alibaba.fastjson.JSON;
@WebServlet(urlPatterns="/ConfirmServlet.shtml")
public class ConfirmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取session作用域对象
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		//用户实现类
		HUserDao huImp = new HUserImpl();
		//购物车实现类
		ShoppingCartDao scimp = new ShoppingCartImpl();
		
		//获取用户id
		String hUserId = request.getParameter("hidhuser");
		//地址实现类
		AddressDao adImpl = new AddressImpl();
		//订单实现类
		IndentDao iImpl = new IndentImpl();
		//订单详情实现类
		IndentDetailDao idImp = new IndentDetailImpl();
		
		
		if(action==null||action.equals("")){
			if(hUserId!=null&&!hUserId.equals("0")){
				session.setAttribute("huser", huImp.selectHUserById(Integer.parseInt(hUserId)));
				
				session.setAttribute("shoppcartLi", scimp.selectAllCheckedByHUserId(Integer.parseInt(hUserId)));
			}
			request.getRequestDispatcher("reception/Confirm.jsp").forward(request, response);
			/*response.sendRedirect(path + "/");*/
		}else if(action.equals("addAddress")){
			adImpl.addAddressByHUserId(new Address(Integer.parseInt(hUserId),request.getParameter("aName"),request.getParameter("phone"),request.getParameter("country"),request.getParameter("detail")));
			session.setAttribute("huser", huImp.selectHUserById(Integer.parseInt(hUserId)));
			response.getWriter().print(JSON.toJSONString(adImpl.selectAddressByHUserId(Integer.parseInt(hUserId))));
		}else if(action.equals("change")){
			response.getWriter().print(JSON.toJSONString(adImpl.selectAddressByAddressId(Integer.parseInt(request.getParameter("addressId")))));
		}else if(action.equals("defaultAddress")){
			huImp.updateDefaultAddressByhuserid(Integer.parseInt(request.getParameter("addressId")),Integer.parseInt(hUserId));
			session.setAttribute("huser", huImp.selectHUserById(Integer.parseInt(hUserId)));
		}else if(action.equals("addIndent")){//添加订单
			
			Indent i = new Indent();    
			i.setHuserid(Integer.parseInt(hUserId));
			i.setStateid(1);
			i.setAddressId(Integer.parseInt(request.getParameter("hidaddress")));
			i.setPayment(Double.valueOf(request.getParameter("hidTotalPrice")));
			i.setIntegral(Integer.parseInt(request.getParameter("hidintegral")));
			iImpl.addIndent(i);
			
			Indent indent = iImpl.selectIndentByhuserIdAndstatusId(Integer.parseInt(hUserId), 1);
			
			List<ShoppingCart> shoppingLi = scimp.selectAllCheckedByHUserId(Integer.parseInt(hUserId));
			for(ShoppingCart item : shoppingLi){
				idImp.addIndentDetail(new IndentDetail(indent.getId(),item.getColorAndConfigureId(),item.getComboId(),item.getTotal()));
			}
			iImpl.updateIndentStatusByIndentId(indent.getId(), 2);
			
			scimp.deleteAllChecked(Integer.parseInt(hUserId));
			session.setAttribute("indent", iImpl.selectIndentByIndentId(indent.getId()));
			response.sendRedirect(path + "/reception/Cashier.jsp");
		}else if(action.equals("cashier")){//收银台代码，一个订单结算
			session.setAttribute("indent", null);
			response.getWriter().print(iImpl.updateIndentStatusByIndentId(Integer.parseInt(request.getParameter("indentId")), 3));
		}else if(action.equals("allCashier")){//收银台代码，多个订单结算
			session.setAttribute("inLi", null);
			response.getWriter().print(iImpl.updateIndentStatusByIndentId(request.getParameter("indentId"), 3));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

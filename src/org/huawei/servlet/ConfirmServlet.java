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
		
		//��ȡsession���������
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		//�û�ʵ����
		HUserDao huImp = new HUserImpl();
		//���ﳵʵ����
		ShoppingCartDao scimp = new ShoppingCartImpl();
		
		//��ȡ�û�id
		String hUserId = request.getParameter("hidhuser");
		//��ַʵ����
		AddressDao adImpl = new AddressImpl();
		//����ʵ����
		IndentDao iImpl = new IndentImpl();
		//��������ʵ����
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
		}else if(action.equals("addIndent")){//��Ӷ���
			
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
		}else if(action.equals("cashier")){//����̨���룬һ����������
			session.setAttribute("indent", null);
			response.getWriter().print(iImpl.updateIndentStatusByIndentId(Integer.parseInt(request.getParameter("indentId")), 3));
		}else if(action.equals("allCashier")){//����̨���룬�����������
			session.setAttribute("inLi", null);
			response.getWriter().print(iImpl.updateIndentStatusByIndentId(request.getParameter("indentId"), 3));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

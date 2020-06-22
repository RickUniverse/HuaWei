package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.HUserDao;
import org.huawei.dao.IndentDao;
import org.huawei.dao.IndentStatusDao;
import org.huawei.dao.impl.HUserImpl;
import org.huawei.dao.impl.IndentImpl;
import org.huawei.dao.impl.IndentStatusImpl;
import org.huawei.entity.HUser;
import org.huawei.entity.PageBean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
@WebServlet(urlPatterns="/PersonallyServlet.shtml")
public class PersonallyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取session作用域对象
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		/*session.setAttribute("huser", null);*/
		HUser hu = (HUser)session.getAttribute("huser");
		if(hu==null){
			response.sendRedirect(path+"/HomePageServlet.shtml");
			return;
		}
		String hUserId = request.getParameter("hUserId");
		
		String hidPage = request.getParameter("hidPage");
		
		String indentId = request.getParameter("indentId");
		
		//订单实现类
		IndentDao iImpl = new IndentImpl();
		//订单状态实现类
		IndentStatusDao isImp = new IndentStatusImpl();
		HUserDao himp = new HUserImpl();
		
		
		PageBean page = new PageBean();
		page.setTotalCount(iImpl.getTotalCountByHUserIdAndStatusId(Integer.parseInt(hUserId), Integer.parseInt(request.getParameter("statusId"))));
		page.setPageSize(2);
		
		
		session.setAttribute("huser", himp.selectHUserById(Integer.parseInt(hUserId)));
		
		if(action==null||action.equals("")){
			//这个是为了避免点击订单状态的时候记录下来上一次点击时候的页码
			String stateChick = request.getParameter("stateChick");
			if(stateChick!=null&&!stateChick.equals("")){
				page.setPageNo(1);
			}else{
				page.setPageNo(hidPage!=null&&!hidPage.equals("") ? Integer.parseInt(hidPage) : page.getPageNo());
			}
			
		}else if(action.equals("checked")){
			if(indentId!=null&&!indentId.equals("0")){
				iImpl.updateCheckedByindentId(Integer.parseInt(indentId), Boolean.parseBoolean(request.getParameter("isChecked")));
			}else{
				JSONArray inli = JSON.parseArray(request.getParameter("array"));
				if(inli.size()>0){
					for(Object item : inli){
						iImpl.updateCheckedByindentId(Integer.parseInt(item.toString()), Boolean.parseBoolean(request.getParameter("isChecked")));
					}
				}
			}
			session.setAttribute("indentLi", iImpl.selectIndentByHUserId(Integer.parseInt(hUserId), Integer.parseInt(request.getParameter("statusId")), page.getPageNo(), page.getPageSize()));
		}else if(action.equals("toPaying")){//单个订单支付
			session.setAttribute("inLi", null);//清空合并订单的作用域
			session.setAttribute("indent", iImpl.selectIndentByIndentId(Integer.parseInt(indentId)));
			response.sendRedirect(path + "/reception/Cashier.jsp");
		}else if(action.equals("allPaying")){//合并订单支付
			JSONArray inli = JSON.parseArray(request.getParameter("array"));
			StringBuffer inid = new StringBuffer();
			for(Object item : inli){
				inid.append(item+",");
			}
			String togoIntends = inid.toString().substring(0, inid.toString().length() - 1);
			session.setAttribute("inLi", iImpl.selectIndentByTogoIndentId(togoIntends));
			session.setAttribute("togoIntends", togoIntends);
			response.sendRedirect(path + "/reception/Cashier.jsp");
		}else if(action.equals("doYesShou")){
			iImpl.updateIndentStatusByIndentId(indentId, 5);
		}else if(action.equals("noIndent")){
			iImpl.updateIndentStatusByIndentId(indentId, 7);
		}else if(action.equals("DoAppraise")){
			iImpl.updateIndentStatusByIndentId(indentId, 6);
		}
		if(action==null||action.equals("")||action.equals("doYesShou")||action.equals("noIndent")||action.equals("DoAppraise")){
			session.setAttribute("statusli", isImp.selectIndentStatusByAll(Integer.parseInt(hUserId)));
			session.setAttribute("statusid", request.getParameter("statusId"));
			session.setAttribute("indentLi", iImpl.selectIndentByHUserId(Integer.parseInt(hUserId), Integer.parseInt(request.getParameter("statusId")), page.getPageNo(), page.getPageSize()));
			session.setAttribute("page", page);
			request.getRequestDispatcher("reception/Personally.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

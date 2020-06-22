package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.IndentDao;
import org.huawei.dao.IndentStatusDao;
import org.huawei.dao.impl.IndentImpl;
import org.huawei.dao.impl.IndentStatusImpl;
import org.huawei.entity.Category;
import org.huawei.entity.PageBean;
import org.huawei.entity.Series;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
@WebServlet(urlPatterns="/AdminOrderServlet.shtml")
public class AdminOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		
		IndentDao iImp = new IndentImpl();
		IndentStatusDao isImp = new IndentStatusImpl();
		session.setAttribute("statsdLi", isImp.selectIndentStatus());
		
		if(action!=null&&!action.equals("")){
			if(action.equals("fahuo")){
				response.getWriter().print(iImp.updateIndentStatusByIndentId(Integer.parseInt(request.getParameter("ordId")), 4));
				return;
			}else if(action.equals("removeCategory")){
				
			}
		}
		
		//类别分页查询
		String ordId = request.getParameter("ordId");
		String statusId = request.getParameter("statusId");
		PageBean pageOrd = new PageBean();
		pageOrd.setPageSize(6);
		pageOrd.setTotalCount(iImp.getTotalCount(Integer.parseInt(ordId==null||ordId.equals("0")||ordId.equals("") ? "0" : ordId) , Integer.parseInt(statusId==null||statusId.equals("0") ? "0" : statusId)));

		String getPageOrd = request.getParameter("getPageOrd");
		if (getPageOrd != null && !getPageOrd.equals("")) {
			pageOrd.setPageNo(Integer.parseInt(getPageOrd));
		}
		/*session.setAttribute("ordId", ordId);
		session.setAttribute("statusId", statusId);*/
		session.setAttribute("pageOrd", pageOrd);
		session.setAttribute("orderLi",
				iImp.selectAllIndent(Integer.parseInt(ordId==null||ordId.equals("0")||ordId.equals("") ? "0" : ordId),Integer.parseInt(statusId==null||statusId.equals("0") ? "0" : statusId),pageOrd.getPageNo(),pageOrd.getPageSize()));
		
		request.getRequestDispatcher("backend/order-list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

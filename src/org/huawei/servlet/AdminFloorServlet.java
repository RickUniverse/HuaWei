package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.ColorandConfigureDao;
import org.huawei.dao.FloorDao;
import org.huawei.dao.impl.ColorandConfigureImpl;
import org.huawei.dao.impl.FloorImpl;
import org.huawei.entity.PageBean;
@WebServlet(urlPatterns="/AdminFloorServlet.shtml")
public class AdminFloorServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		
		//分类实现类
		FloorDao fImp = new FloorImpl();
		//细分实现类
		ColorandConfigureDao souImp = new ColorandConfigureImpl();
		
		session.setAttribute("flLi", fImp.selectFloorByAll());
		
		if(action!=null&&!action.equals("")){
			if(action.equals("addflor")){ 
				fImp.addFloorScom(Integer.parseInt(request.getParameter("fid")), Integer.parseInt(request.getParameter("couId")));
			}else if(action.equals("removeFl")){
				response.getWriter().print(fImp.removeFloorScom(Integer.parseInt(request.getParameter("scomId"))));
				return;
			}
		}
		
		//类别分页查询
		String floorId = request.getParameter("floorId");
		String couId = request.getParameter("couId");
		PageBean pageCou = new PageBean();
		pageCou.setPageSize(4);
		pageCou.setTotalCount(souImp.getTotalCount(Integer.parseInt(floorId==null||floorId.equals("0") ? "0" : floorId), Integer.parseInt(couId==null||couId.equals("0")||couId.equals("") ? "0" : couId)));
		
		String getPageCou = request.getParameter("getPageCou");
		if(getPageCou!=null&&!getPageCou.equals("")){
			pageCou.setPageNo(Integer.parseInt(getPageCou));
		}
		session.setAttribute("couId", couId);
		session.setAttribute("floorId", floorId);
		session.setAttribute("pageCou", pageCou);
		session.setAttribute("coucolurLi",  souImp.selectColorandConfigureByIdByFloor(Integer.parseInt(floorId==null||floorId.equals("0") ? "0" : floorId), Integer.parseInt(couId==null||couId.equals("0")||couId.equals("") ? "0" : couId),pageCou.getPageNo(),pageCou.getPageSize()));
		
		request.getRequestDispatcher("backend/floor.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

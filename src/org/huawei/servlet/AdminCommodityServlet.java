package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.CommodityDao;
import org.huawei.dao.SeriesDao;
import org.huawei.dao.impl.CommodityImpl;
import org.huawei.dao.impl.SeriesImpl;
import org.huawei.entity.Commodity;
import org.huawei.entity.PageBean;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
@WebServlet(urlPatterns="/AdminCommodityServlet.shtml")
public class AdminCommodityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		
		SeriesDao sImp = new SeriesImpl();
		CommodityDao cImp = new CommodityImpl();
		
		/*System.out.println(session.getAttribute("admin"));*/
		
		if(action!=null&&!action.equals("")){
			if(action.equals("addCom")){
				SmartUpload smart = new SmartUpload();
				smart.setCharset("utf-8");
				smart.initialize(this, request, response);
				try {
					smart.upload();
				} catch (SmartUploadException e1) {
					e1.printStackTrace();
				}
				Files files = smart.getFiles();
				File file = files.getFile(0);
				/*System.out.println(file);
				System.out.println(file.getFileName());
				System.out.println(file.getFileExt());
				System.out.println(file.getFileName());
				System.out.println(file.getFilePathName());*/
				String photo = "";
				try {
					file.saveAs("/homeimage/floor/"+file.getFileName());
					photo = "homeimage/floor/"+file.getFileName();
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
				Request re = smart.getRequest();
				String cName = re.getParameter("cName");
				String serid_cateid = re.getParameter("serid-cateid");//cName,categoryid,seriesId,image
				cImp.addCommodity(new Commodity(cName,Integer.parseInt(serid_cateid.split("-")[0]),Integer.parseInt(serid_cateid.split("-")[1]),photo));
				
				response.sendRedirect(path+"/AdminCommodityServlet.shtml");
				return;
			}else if(action.equals("removeCom")){
				response.getWriter().print(cImp.deleteCommodityByComId(Integer.parseInt(request.getParameter("comid"))));
				return;
			}else if(action.equals("update")){
				session.setAttribute("commodity", cImp.selectCommodityById(Integer.parseInt(request.getParameter("comid"))));
				/*request.getRequestDispatcher("backend/update-commodity.jsp").forward(request, response);*/
				response.sendRedirect(path+"/backend/update-commodity.jsp");
				return;
			}else if(action.equals("updateCom")){
				SmartUpload smart = new SmartUpload();
				smart.setCharset("utf-8");
				smart.initialize(this, request, response);
				try {
					smart.upload();
				} catch (SmartUploadException e1) {
					e1.printStackTrace();
				}
				Files files = smart.getFiles();
				File file = files.getFile(0);
				String photo = "";
				try {
					file.saveAs("/homeimage/floor/"+file.getFileName());
					photo = "homeimage/floor/"+file.getFileName();
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
				Request re = smart.getRequest();
				String comId = re.getParameter("comId");
				String cName = re.getParameter("cName");
				String serid_cateid = re.getParameter("serid-cateid");//cName,categoryid,seriesId,image
				cImp.updateCommodity(new Commodity(Integer.parseInt(comId),cName,Integer.parseInt(serid_cateid.split("-")[0]),Integer.parseInt(serid_cateid.split("-")[1]),photo));
				
				response.sendRedirect(path+"/AdminCommodityServlet.shtml");
				/*request.getRequestDispatcher("backend/commodity.jsp").forward(request, response);*/
				return;
			}
			
		}
		
		/*System.out.println(this.getServletContext().getSessionCookieConfig());*/
		//ÑÕÉ«
		String comName = request.getParameter("comName");
		String seriesId = request.getParameter("seriesId");
		PageBean pageCom = new PageBean();
		pageCom.setPageSize(6);
		pageCom.setTotalCount(cImp.getTotalCount(comName , Integer.parseInt(seriesId==null||seriesId.equals("0") ? "0" : seriesId)));

		String getPageCom = request.getParameter("getPageCom");
		if (getPageCom != null && !getPageCom.equals("")) {
			pageCom.setPageNo(Integer.parseInt(getPageCom));
		}
		/*session.setAttribute("comName", comName);
		session.setAttribute("seriesId", seriesId);*/
		session.setAttribute("pageCom", pageCom);
		session.setAttribute("commoditycLi",
				cImp.selectAllCommodityBycNameAndSeriesId(comName, Integer.parseInt(seriesId==null||seriesId.equals("0") ? "0" : seriesId), pageCom.getPageNo(), pageCom.getPageSize()));
		session.setAttribute("seriessLicom", sImp.selectAllSeries());
		request.getRequestDispatcher("backend/commodity.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.CategoryDao;
import org.huawei.dao.SeriesDao;
import org.huawei.dao.impl.CategoryImpl;
import org.huawei.dao.impl.SeriesImpl;
import org.huawei.entity.Category;
import org.huawei.entity.PageBean;
import org.huawei.entity.Series;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
@WebServlet(urlPatterns="/AdminCateServlet.shtml")
public class AdminCateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		
		//����ʵ����
		CategoryDao caImp = new CategoryImpl();
		//ϸ��ʵ����
		SeriesDao seImp = new SeriesImpl();
		
		if(action!=null&&!action.equals("")){
			if(action.equals("addCategory")){
				String cate = request.getParameter("category");
				caImp.addCategory(new Category(0,cate));
			}else if(action.equals("removeCategory")){
				String cId = request.getParameter("categoryId");
				response.getWriter().print(caImp.deleteCategoryByCategoryId(Integer.parseInt(cId)));
				return;
			}else if(action.equals("addSeries")){
				//ʵ����
				SmartUpload smart = new SmartUpload();
				//���ñ����ʽ
				smart.setCharset("utf-8");
				//��ʼ�����
				smart.initialize(this, request, response);
				//�ϴ��ļ�
				try {
					smart.upload();
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
				//ʹ��smart��request����
				Request req = smart.getRequest();
				String seriesName = req.getParameter("series_name");
				String cateId = req.getParameter("cate-add-series");
				//���ݿ�ͼƬ·��
				String photo = "";
				//smart��ȡһ���ļ�
				Files files = smart.getFiles();
				//��ȡ�ļ�
				File file = files.getFile(0);
				//���ļ����浽������
				try {
					file.saveAs("/homeimage/category/"+file.getFileName());
					photo = "homeimage/category/"+file.getFileName();
				} catch (SmartUploadException e) {
					e.printStackTrace();
				}
				//���浽���ݿ�
				seImp.addSeries(new Series(seriesName,photo,Integer.parseInt(cateId)));
			}else if(action.equals("updateSeries")){
				String categoryId = request.getParameter("categoryId");
				String sName = request.getParameter("sName");
				String seriesId = request.getParameter("seriesId");
				response.getWriter().print(seImp.updateSeries(Integer.parseInt(seriesId), sName, Integer.parseInt(categoryId)));
				return;
			}else if(action.equals("deleteSeries")){
				String seriesId = request.getParameter("seriesId");
				response.getWriter().print(seImp.deleteSeriesBySeriesId(Integer.parseInt(seriesId)));
				return;
			}
		}
		
		//����ҳ��ѯ
		String cateName = request.getParameter("cateName");
		PageBean pageCate = new PageBean();
		pageCate.setPageSize(4);
		pageCate.setTotalCount(caImp.getTotalCount(cateName));
		
		String getPageCate = request.getParameter("getPageCate");
		if(getPageCate!=null&&!getPageCate.equals("")){
			pageCate.setPageNo(Integer.parseInt(getPageCate));
		}
		session.setAttribute("cateName", cateName);
		session.setAttribute("pageCate", pageCate);
		session.setAttribute("cateSeach",  caImp.selectAllCategory(cateName!=null&&!cateName.equals("") ? cateName : null,pageCate.getPageNo(),pageCate.getPageSize()));
		
		//ϸ�ַ�ҳ��ѯ
		String categoruId = request.getParameter("cate-search-series");
		String seriesName = request.getParameter("seriesName");
		PageBean pageSer = new PageBean();
		pageSer.setPageSize(5);
		pageSer.setTotalCount(seImp.totalCount(seriesName, Integer.parseInt(categoruId==null||categoruId.equals("0") ? "0" : categoruId)));
		
		String getPageSeries = request.getParameter("getPageSeries");
		if(getPageSeries!=null&&!getPageSeries.equals("")){
			pageSer.setPageNo(Integer.parseInt(getPageSeries));
		}
		session.setAttribute("pageSer", pageSer);
		session.setAttribute("categoruId", categoruId==null||categoruId.equals("0") ? "0" : categoruId);
		session.setAttribute("seriesName", seriesName);
		session.setAttribute("seriesLi", seImp.selectAllSeries(seriesName!=null&&!seriesName.equals("") ? seriesName : null, Integer.parseInt(categoruId==null||categoruId.equals("0") ? "0" : categoruId),pageSer.getPageNo(),pageSer.getPageSize()));
		
		
		session.setAttribute("categoryLi",caImp.selectAllCategory());
		request.getRequestDispatcher("backend/cate.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

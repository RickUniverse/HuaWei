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

import org.huawei.dao.CategoryDao;
import org.huawei.dao.ColorandConfigureDao;
import org.huawei.dao.ConfigureDao;
import org.huawei.dao.SeriesDao;
import org.huawei.dao.impl.CategoryImpl;
import org.huawei.dao.impl.ColorandConfigureImpl;
import org.huawei.dao.impl.ConfigureImpl;
import org.huawei.dao.impl.SeriesImpl;
import org.huawei.entity.ColorandConfigure;
import org.huawei.entity.Configure;
import org.huawei.entity.PageBean;

import com.alibaba.fastjson.JSON;
@WebServlet(urlPatterns="/ListSearchServlet.html")
public class ListSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		List list = new ArrayList();//��װһ��ArrayList��������������Ʒ���ϸ�ҳ��
		
		//����ʵ����
		CategoryDao catImp = new CategoryImpl();
		SeriesDao serImp = new SeriesImpl();
		ConfigureDao configImp = new ConfigureImpl();
		ColorandConfigureDao cconImp = new ColorandConfigureImpl();
		
		//��ȡ��Ʒ����ϸ��id
		String hidCate = request.getParameter("hidCategory");//��ȡ����categoryid
		String hidSeries = request.getParameter("hidSeries");//��ȡ����seriesid
		String cName = request.getParameter("commodityName").trim();//��ȡ��Ʒ��    ����ȥ���ո�
		int categoryId = 0;//����id��������ѯ
		int seriseId = 0;//ϸ��id��������ѯ
		if(hidCate!=null&&!hidCate.equals("")){
			session.setAttribute("category", catImp.selectCategoryById(Integer.parseInt(hidCate)));//list.jspҳ�涥���������
			session.setAttribute("that", "category");//�����������Ǹ�
			categoryId = Integer.parseInt(hidCate);//������id��ֵ
		}
		if(hidSeries!=null&&!hidSeries.equals("")&&!hidSeries.equals("0")){
			session.setAttribute("series", serImp.selectOneSeriesById(Integer.parseInt(hidSeries)));//list.jspҳ�涥��ϸ�ֶ���
			session.setAttribute("that", "series");
			categoryId = catImp.selectCategoryBySeriesId(Integer.parseInt(hidSeries)).getId();//����ϸ�ֻ�ȡ����id������ֻ��ϸ��id
			seriseId = Integer.parseInt(hidSeries);
		}
		if(cName!=null&&!cName.equals("")){
			session.setAttribute("cName", cName);
			session.setAttribute("that", "cNames");
		}
		
		//��ȡ��Ʒ�ļ۸����������
		String action = request.getParameter("action");
		String strminPrice = request.getParameter("min");//��ȡ��С�۸�
		String strmaxPrice = request.getParameter("max");//��ȡ���۸�
		String strconfigureId = request.getParameter("configureId");//��ȡ����id
		int minPrice = 0;
		int maxPrice = 0;
		int configureId = 0;
		minPrice = strminPrice!=null&&!strminPrice.equals("0") ? Integer.parseInt(strminPrice) : 0;//�Ƿ�Ϊ�պ�Ϊ��
		maxPrice = strmaxPrice!=null&&!strmaxPrice.equals("0") ? Integer.parseInt(strmaxPrice) : 0;//�Ƿ�Ϊ�պ�Ϊ��
		configureId = strconfigureId!=null&&!strconfigureId.equals("0") ? Integer.parseInt(strconfigureId) : 0;//�Ƿ�Ϊ�պ�Ϊ��
		
		//ҳ��
		PageBean page = new PageBean();
		page.setTotalCount(cconImp.getTotalCount(minPrice, maxPrice, categoryId, seriseId, configureId , cName!=null&&!cName.equals("") ? cName : null));
		String hidPage = request.getParameter("hidPage");
		if(hidPage!=null&&!hidPage.equals("0")){
			page.setPageNo(Integer.parseInt(hidPage));
		}
		
		
		//��session��������
		List<ColorandConfigure> conLi = cconImp.selectColorandConfigureByPriceAndCategoryAndSeriseAndConfigureAndLimit(minPrice, maxPrice, categoryId, seriseId, configureId , cName!=null&&!cName.equals("") ? cName : null , page.getPageNo(), page.getPageSize());
		if(action==null||action.equals("")){
			session.setAttribute("cconfiLi",conLi);
			session.setAttribute("conLi", configImp.selectConfiguresByCagegoryId(categoryId,seriseId,cName));//��ѯ�������ü���
			session.setAttribute("pageBean", page);//ҳ�����
			request.getRequestDispatcher("/reception/List.jsp").forward(request, response);
		}else if(action.equals("price")||action.equals("configore")||action.equals("getPage")){
			list.add(conLi);//�����Ʒ����
			list.add(page);//���ҳ�����
			response.getWriter().print(JSON.toJSONString(list));
		}/*else if(hidCate.equals("all")){
			session.setAttribute("cconfiLi",cconImp.selectColorandConfigureByPriceAndCategoryAndSeriseAndConfigureAndLimit(0, 0, 0, 0, 0, null, page.getPageNo(), page.getPageSize()));
		}*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

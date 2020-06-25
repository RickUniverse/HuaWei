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
		
		List list = new ArrayList();//封装一个ArrayList传递搜索到的商品集合跟页码
		
		//导入实现类
		CategoryDao catImp = new CategoryImpl();
		SeriesDao serImp = new SeriesImpl();
		ConfigureDao configImp = new ConfigureImpl();
		ColorandConfigureDao cconImp = new ColorandConfigureImpl();
		
		//获取商品类别跟细分id
		String hidCate = request.getParameter("hidCategory");//获取隐藏categoryid
		String hidSeries = request.getParameter("hidSeries");//获取隐藏seriesid
		String cName = request.getParameter("commodityName").trim();//获取商品名    并且去除空格
		int categoryId = 0;//种类id，用来查询
		int seriseId = 0;//细分id，用来查询
		if(hidCate!=null&&!hidCate.equals("")){
			session.setAttribute("category", catImp.selectCategoryById(Integer.parseInt(hidCate)));//list.jsp页面顶部种类对象
			session.setAttribute("that", "category");//区分输入了那个
			categoryId = Integer.parseInt(hidCate);//给种类id赋值
		}
		if(hidSeries!=null&&!hidSeries.equals("")&&!hidSeries.equals("0")){
			session.setAttribute("series", serImp.selectOneSeriesById(Integer.parseInt(hidSeries)));//list.jsp页面顶部细分对象
			session.setAttribute("that", "series");
			categoryId = catImp.selectCategoryBySeriesId(Integer.parseInt(hidSeries)).getId();//根据细分获取种类id，避免只有细分id
			seriseId = Integer.parseInt(hidSeries);
		}
		if(cName!=null&&!cName.equals("")){
			session.setAttribute("cName", cName);
			session.setAttribute("that", "cNames");
		}
		
		//获取商品的价格区间跟配置
		String action = request.getParameter("action");
		String strminPrice = request.getParameter("min");//获取最小价格
		String strmaxPrice = request.getParameter("max");//获取最大价格
		String strconfigureId = request.getParameter("configureId");//获取配置id
		int minPrice = 0;
		int maxPrice = 0;
		int configureId = 0;
		minPrice = strminPrice!=null&&!strminPrice.equals("0") ? Integer.parseInt(strminPrice) : 0;//是否为空和为零
		maxPrice = strmaxPrice!=null&&!strmaxPrice.equals("0") ? Integer.parseInt(strmaxPrice) : 0;//是否为空和为零
		configureId = strconfigureId!=null&&!strconfigureId.equals("0") ? Integer.parseInt(strconfigureId) : 0;//是否为空和为零
		
		//页码
		PageBean page = new PageBean();
		page.setTotalCount(cconImp.getTotalCount(minPrice, maxPrice, categoryId, seriseId, configureId , cName!=null&&!cName.equals("") ? cName : null));
		String hidPage = request.getParameter("hidPage");
		if(hidPage!=null&&!hidPage.equals("0")){
			page.setPageNo(Integer.parseInt(hidPage));
		}
		
		
		//向session输入数据
		List<ColorandConfigure> conLi = cconImp.selectColorandConfigureByPriceAndCategoryAndSeriseAndConfigureAndLimit(minPrice, maxPrice, categoryId, seriseId, configureId , cName!=null&&!cName.equals("") ? cName : null , page.getPageNo(), page.getPageSize());
		if(action==null||action.equals("")){
			session.setAttribute("cconfiLi",conLi);
			session.setAttribute("conLi", configImp.selectConfiguresByCagegoryId(categoryId,seriseId,cName));//查询出的配置集合
			session.setAttribute("pageBean", page);//页码对象
			request.getRequestDispatcher("/reception/List.jsp").forward(request, response);
		}else if(action.equals("price")||action.equals("configore")||action.equals("getPage")){
			list.add(conLi);//添加商品集合
			list.add(page);//添加页码对象
			response.getWriter().print(JSON.toJSONString(list));
		}/*else if(hidCate.equals("all")){
			session.setAttribute("cconfiLi",cconImp.selectColorandConfigureByPriceAndCategoryAndSeriseAndConfigureAndLimit(0, 0, 0, 0, 0, null, page.getPageNo(), page.getPageSize()));
		}*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

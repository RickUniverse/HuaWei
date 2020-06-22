package org.huawei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.huawei.dao.ColorDao;
import org.huawei.dao.ColorandConfigureDao;
import org.huawei.dao.CommodityDao;
import org.huawei.dao.ConfigureDao;
import org.huawei.dao.PromotionDao;
import org.huawei.dao.impl.ColorImpl;
import org.huawei.dao.impl.ColorandConfigureImpl;
import org.huawei.dao.impl.CommodityImpl;
import org.huawei.dao.impl.ConfigureImpl;
import org.huawei.dao.impl.PromotionImpl;
import org.huawei.entity.ColorandConfigure;
import org.huawei.entity.PageBean;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
@WebServlet(urlPatterns="/AdminColorAndConfigureServlet.shtml")
public class AdminColorAndConfigureServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String path = request.getContextPath();
		String action = request.getParameter("action");
		
		ColorDao coImp = new ColorImpl();
		ConfigureDao cdImp = new ConfigureImpl();
		PromotionDao pImp = new PromotionImpl();
		CommodityDao comImp = new CommodityImpl();
		
		ColorandConfigureDao couImp = new ColorandConfigureImpl();
		
		session.setAttribute("colorsLi", coImp.selectAllColorBycName());
		session.setAttribute("configureLis", cdImp.selectAllConfiguresBycName());
		session.setAttribute("proLis", pImp.selectAllPromotionByTitle());
		session.setAttribute("comLi", comImp.selectAllCommodity());
		
		if(action!=null&&!action.equals("")){
			if(action.equals("addColAndCou")){
				SmartUpload smart = new SmartUpload();
				smart.setCharset("utf-8");
				smart.initialize(this, request, response);
				try {
					smart.upload();
				} catch (SmartUploadException e1) {
					e1.printStackTrace();
				}
				Files files = smart.getFiles();
				StringBuffer photo = new StringBuffer();
				for(int i = 0; i < files.getCount(); i++){
					File file = files.getFile(i);
					try {
						file.saveAs("/homeimage/commodity/"+file.getFileName());
						photo.append(file.getFileName()+";");
					} catch (SmartUploadException e) {
						e.printStackTrace();
					}
				}
				
				Request re = smart.getRequest();
				String commodityId = re.getParameter("commodityId");
				String colorId = re.getParameter("colorId");
				String configureId = re.getParameter("configureId");
				String promotionId = re.getParameter("promotionId");
				String store = re.getParameter("store");
				String price = re.getParameter("price");
				String title = re.getParameter("title");
				String descs = re.getParameter("descs");
				//configureId,colorId,store,price,images,title,descs,promotionId,commodityId
				ColorandConfigure c = new ColorandConfigure();
				c.setConfigureId(Integer.parseInt(configureId));
				c.setColorId(Integer.parseInt(colorId));
				c.setStore(Integer.parseInt(store));
				c.setPrice(Double.parseDouble(price));
				c.setImages(photo.deleteCharAt(photo.length() - 1).toString());
				c.setTitle(title);
				c.setDescs(descs);
				c.setPromotionId(Integer.parseInt(promotionId));
				c.setCommodityId(Integer.parseInt(commodityId));
				
				couImp.addColorAndConfigure(c);
				
				response.sendRedirect(path+"/backend/colorAndConfigure.jsp");
				return;
				
			}else if(action.equals("doupdateCou")){
				session.setAttribute("colAndCou", couImp.selectColorandConfigureByColorandConfigureId(Integer.parseInt(request.getParameter("couId"))));
				request.getRequestDispatcher("backend/update-colorAndConfigure.jsp").forward(request, response);
				return;
			}else if(action.equals("updateCou")){
				SmartUpload smart = new SmartUpload();
				smart.setCharset("utf-8");
				smart.initialize(this, request, response);
				try {
					smart.upload();
				} catch (SmartUploadException e1) {
					e1.printStackTrace();
				}
				Files files = smart.getFiles();
				StringBuffer photo = new StringBuffer();
				for(int i = 0; i < files.getCount(); i++){
					File file = files.getFile(i);
					try {
						file.saveAs("/homeimage/commodity/"+file.getFileName());
						photo.append(file.getFileName()+";");
					} catch (SmartUploadException e) {
						e.printStackTrace();
					}
				}
				
				Request re = smart.getRequest();
				String commodityId = re.getParameter("commodityId");
				String colorId = re.getParameter("colorId");
				String configureId = re.getParameter("configureId");
				String promotionId = re.getParameter("promotionId");
				String store = re.getParameter("store");
				String price = re.getParameter("price");
				String title = re.getParameter("title");
				String descs = re.getParameter("descs");
				//configureId,colorId,store,price,images,title,descs,promotionId,commodityId
				ColorandConfigure c = new ColorandConfigure();
				c.setConfigureId(Integer.parseInt(configureId));
				c.setColorId(Integer.parseInt(colorId));
				c.setStore(Integer.parseInt(store));
				c.setPrice(Double.parseDouble(price));
				c.setImages(photo.deleteCharAt(photo.length() - 1).toString());
				c.setTitle(title);
				c.setDescs(descs);
				c.setPromotionId(Integer.parseInt(promotionId));
				c.setCommodityId(Integer.parseInt(commodityId));
				c.setId(Integer.parseInt(re.getParameter("coucId")));
				couImp.updateColorAndConfigure(c);
				/*request.getRequestDispatcher("backend/colorAndConfigure.jsp").forward(request, response);*/
				/*return;*/
			} else if(action.equals("removeCou")){
				response.getWriter().print(couImp.deleteColorAndConfigure(Integer.parseInt(request.getParameter("coucId"))));
				return;
			}
			
		}
		
		//ÑÕÉ«ÅäÖÃ
		String colorId = request.getParameter("colorId");
		String configureId = request.getParameter("configureId");
		String comName = request.getParameter("comName");
		PageBean pageCou = new PageBean();
		pageCou.setPageSize(15);
		pageCou.setTotalCount(couImp.getTotalCount(comName, Integer.parseInt(colorId==null||colorId.equals("0") ? "0" : colorId), Integer.parseInt(configureId==null||configureId.equals("0") ? "0" : configureId)));

		String getPageCou = request.getParameter("getPageCou");
		if (getPageCou != null && !getPageCou.equals("")) {
			pageCou.setPageNo(Integer.parseInt(getPageCou));
		}
		session.setAttribute("comName", comName);
		session.setAttribute("colorId", colorId);
		session.setAttribute("configureId", configureId);
		session.setAttribute("pageCou", pageCou);
		session.setAttribute("couLi",
				couImp.selectColorandConfigureById(comName, Integer.parseInt(colorId==null||colorId.equals("0") ? "0" : colorId), Integer.parseInt(configureId==null||configureId.equals("0") ? "0" : configureId), pageCou.getPageNo(), pageCou.getPageSize()));
		
		request.getRequestDispatcher("backend/colorAndConfigure.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

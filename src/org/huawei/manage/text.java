package org.huawei.manage;

import org.huawei.dao.AdminDao;
import org.huawei.dao.impl.AdminImpl;
import org.huawei.dao.impl.CommodityImpl;

public class text {
	public static void main(String[] args) {
		//这个是首页用到的
		/*OneMenuDao oimp = new OneMenuImpl();
		FloorDao fimp = new FloorImpl();
		for(Floor f : fimp.selectFloorByAll()){
			System.out.println(f.getCategory().getsName());
			for(Series s :f.getLiSeries()){
				System.out.println(s);
			} 
			for(ColorandConfigure s :f.getLiColorandConfigure()){
				System.out.println(s);
			}
		}*/
		//这个是查询商品页面的方法
		/*ColorandConfigureDao cImp = new ColorandConfigureImpl();
		System.out.println(cImp.selectColorandConfigureByPriceAndCategoryAndSeriseAndConfigureAndLimit(0, 0, 0, 0, 0,null, 1, 15));
		for(ColorandConfigure item : cImp.selectColorandConfigureByPriceAndCategoryAndSeriseAndConfigureAndLimit(0, 0, 0, 0, 0,null, 1, 15)){
			System.out.println(item);
		}*/
		
		CommodityImpl comimp = new CommodityImpl();
		/*Commodity clcf = comimp.selectCommodityByColorandConfigureId(6);
		System.out.println(clcf.getColorandConfigure().getColorId());
		for(Color cl : clcf.getColorLi()){
			System.out.println(cl);
		}
		for(Configure cf : clcf.getConfigureLi()){
			System.out.println(cf.isExisit());
		}
		for(Combo cb : clcf.getComboLi()){
			System.out.println(cb.getPrice());
		}
		for(Promotion pr : clcf.getColorandConfigure().getPromotionLi()){
			System.out.println(pr);
		}*/
		
		
		//测试版本配置之间被包含关系
		/*Commodity clcf = comimp.selectCommodityByCommodityIdAndColorIdAndConfigureId(1, 2, 0, 1);
		
		for(Color cl : clcf.getColorLi()){
			System.out.println(cl);
		}
		for(Configure cf : clcf.getConfigureLi()){
			System.out.println(cf.isExisit());
		}
		for(Combo cb : clcf.getComboLi()){
			System.out.println(cb.getPrice());
		}
		for(Promotion pr : clcf.getColorandConfigure().getPromotionLi()){
			System.out.println(pr);
		}*/
		
		
		
		//测试购物车
		/*ShoppingCartDao scimp = new ShoppingCartImpl();
		List<ShoppingCart> scLi = scimp.selectAllCheckedByHUserId(1);
		for(ShoppingCart item : scLi){
			System.out.println(item.getCombo().getCommodity());
		}*/
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(new Date()));*/
		
		
		/*IndentDao iImpl = new IndentImpl();
		Indent inli = iImpl.selectIndentByIndentId(10);
		for(IndentDetail item : inli.getIndentDetailLi()){
			System.out.println(item);
		}*/
		
		/*IndentDao iImpl = new IndentImpl();
		List<Indent> inli = iImpl.selectIndentByHUserId(1, 0, 1, 11);
		for(Indent item : inli){
			List<IndentDetail> deli = item.getIndentDetailLi();
			for(IndentDetail de : deli){
				System.out.println(de.getTotal());
				List<Commodity> com = de.getCombo().getCommodityLi();
				for(Commodity co : com){
					System.out.println(co.getColorandConfigure().getTitle());
				}
			}
		}*/
		
		/*CarouselImpl cimp = new CarouselImpl();
		System.out.println(cimp.selectAllCarousel());*/
		
		/*HUserDao himp = new HUserImpl();
		System.out.println(himp.selectAllHUser(1, 5));*/
		
		AdminDao aImp = new AdminImpl();
		System.out.println(aImp.loginByANameAndPassword("admin", "123123"));
		
		
	}
}

package org.huawei.dao;

import java.util.List;

import org.huawei.entity.ColorandConfigure;

/**
 * ��ɫ�����ýӿ�
 * @author Administrator
 *
 */
public interface ColorandConfigureDao {
	/**
	 * ����¥��id��ѯ��Ӧ����ɫ����
	 * @param id
	 * @return
	 */
	List<ColorandConfigure> selectColorandConfigureById(int floorid);
	/**
	 * ��ѯ��Ʒ������������
	 * @param minPrice��С�۸�
	 * @param maxPrice���۸�
	 * @param categoryId���id
	 * @param seriseIdϸ��id
	 * @param configureId����id
	 * @param pageNo��ǰҳ
	 * @param PageSizeÿҳ����
	 * @return
	 */
	List<ColorandConfigure> selectColorandConfigureByPriceAndCategoryAndSeriseAndConfigureAndLimit(double minPrice , double maxPrice , int categoryId , int seriseId , int configureId  , String cName , int pageNo , int PageSize);
	/**
	 * ��ѯ������
	 * @param minPrice
	 * @param maxPrice
	 * @param categoryId
	 * @param seriseId
	 * @param configureId
	 * @return
	 */
	int getTotalCount(double minPrice , double maxPrice , int categoryId , int seriseId , int configureId , String cName);
	/**
	 * ���ز�ѯ���ĵ�һ�������ݰ���commodity
	 * ������Ʒid��ѯ��ƥ�䵽�ĵ�һ�����ݲ�����Ϊ����
	 * @param commodityId
	 * @return
	 */
	ColorandConfigure selectColorandConfigureByCommodityId(int commodityId);
	/**
	 * ������ɫ����id��ѯ����Ӧ�Ķ���
	 * ��Ӧ������Ʒ�ڵķ���
	 * @param ColorandConfigureid
	 * @return
	 */
	ColorandConfigure selectColorandConfigureByColorandConfigureId(int colorandConfigureId);
	/**
	 * ������ɫid������id��ѯ����һ����ɫ���ö���
	 * @param commodityId//ָ�����ĸ���Ʒ
	 * @param colorId
	 * @param configureId
	 * @return
	 */
	ColorandConfigure selectColorandConfigureByColorIdAndConfigureId(int commodityId , int colorId, int configureId);
	/**
	 * ��̨��ҳ��ѯ
	 * @param comName
	 * @param colorId
	 * @param configureId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<ColorandConfigure> selectColorandConfigureById(String comName , int colorId , int configureId , int pageNo , int pageSize);
	/**
	 * ��ȡ����
	 */
	int getTotalCount(String comName , int colorId , int configureId);
	/**
	 * ���
	 * @param c
	 * @return
	 */
	boolean addColorAndConfigure(ColorandConfigure c);
	/**
	 * �޸���ɫ������
	 * @param c
	 * @return
	 */
	boolean updateColorAndConfigure(ColorandConfigure c);
	/**
	 * ɾ��
	 * @param couId
	 * @return
	 */
	boolean deleteColorAndConfigure(int couId);
	/**
	 * ¥���ҳ��ѯ
	 * @param floorId
	 * @param couId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<ColorandConfigure> selectColorandConfigureByIdByFloor(int floorId , int couId , int pageNo , int pageSize);
	/**
	 * ��ȡ����
	 */
	int getTotalCount(int floorId , int couId);
}

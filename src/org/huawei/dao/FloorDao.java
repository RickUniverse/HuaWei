package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Floor;

/**
 * ¥��ӿ�
 * @author Administrator
 *
 */
public interface FloorDao {
	/**
	 * ��ȡ����¥��
	 * ��ҳ
	 */
	List<Floor> selectFloorByAll();
	/**
	 * ���¥��
	 * @param flId
	 * @param couId
	 * @return
	 */
	boolean addFloorScom(int flId , int couId);
	/**
	 * ɾ��
	 * 
	 * @param ScomId
	 * @return
	 */
	boolean removeFloorScom(int ScomId);
}

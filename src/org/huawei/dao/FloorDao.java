package org.huawei.dao;

import java.util.List;

import org.huawei.entity.Floor;

/**
 * 楼层接口
 * @author Administrator
 *
 */
public interface FloorDao {
	/**
	 * 获取所有楼层
	 * 首页
	 */
	List<Floor> selectFloorByAll();
	/**
	 * 添加楼层
	 * @param flId
	 * @param couId
	 * @return
	 */
	boolean addFloorScom(int flId , int couId);
	/**
	 * 删除
	 * 
	 * @param ScomId
	 * @return
	 */
	boolean removeFloorScom(int ScomId);
}

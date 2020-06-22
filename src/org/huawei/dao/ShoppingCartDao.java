package org.huawei.dao;

import java.util.List;

import org.huawei.entity.ShoppingCart;

/**
 * ���ﳵ�ӿ�
 * @author Administrator
 *
 */
public interface ShoppingCartDao {
	/**
	 * �����Ʒ�����ﳵ
	 * @param colorAndConfigureId ��ɫ������id
	 * @param total ����
	 * @param totalPrice �۸�
	 * @param comboId �ײ�id
	 * @param huserid �û�id
	 * @return
	 */
	boolean addShoppingCart(int colorAndConfigureId , int total , double totalPrice , int comboId , int huserid);
	/**
	 * �����û�id��ѯ�����й��ﳵ����Ʒ
	 * @param hUserId
	 * @return
	 */
	List<ShoppingCart> selectAllShoppingCartByUserId(int hUserId);
	/**
	 * �����û�id��ѯ�����û�ѡ����Ʒ���ܼ۸�
	 * @param HUserId
	 * @return
	 */
	double selectTotalPrice(int HUserId);
	/**
	 * �����û�id��ѯ�����û�����ѡ�е���Ʒ
	 * @param HUserId
	 * @return
	 */
	int selectTotalCheck(int HUserId);
	/**
	 * �����û�id��ѯ�����û�ѡ����Ʒ�Żݵ��ܼ۸�
	 * @param HUserId
	 * @return
	 */
	double selectYouPrice(int HUserId);
	/**
	 * ���չ��ﳵid���޸�ѡ��״̬
	 * @param shoppingCartId
	 * @param isChecked//falseΪδѡ�У�trueΪѡ��
	 * @return
	 */
	boolean updateShoppingCartCheckedByShoppingCartId(int shoppingCartId , boolean isChecked);
	/**
	 * �����û�id�޸��û���Ӧ����Ʒ������checked
	 * @param hUserId
	 * @param isChecked
	 * @return
	 */
	boolean updateShoppingCartCheckedByHUserId(int hUserId , boolean isChecked);
	/**
	 * ���ݹ��ﳵidɾ����Ӧ��Ʒ
	 * @param shoppingCartId
	 * @return
	 */
	boolean deleteShoppingCartByShoppingCartId(int shoppingCartId);
	/**
	 * ������Ʒid�Ӽ�
	 * �����޸ĺ�Ķ���
	 * @param shoppingCartId
	 * @param issubstartAndAdd ture : ++       false : --
	 * @return
	 */
	ShoppingCart updateNumberByShoppingCartId(boolean issubstartAndAdd , int shoppingCartId);
	/**
	 * ���ݹ��ﳵid��ѯ
	 * @param shoppingCartId
	 * @return
	 */
	ShoppingCart selectOneShoppingCartByShoppingCartId(int shoppingCartId);
	/**
	 * �����û�id��ѯѡ����Ʒ������
	 * @param huserId
	 * @return
	 */
	int getCheckedShoppingCartTotalByHUserId(int huserId);
	/**
	 * �����û�id��ѯ������ѡ�е���Ʒ
	 * @param huserId
	 * @return
	 */
	List<ShoppingCart> selectAllCheckedByHUserId(int huserId);
	/**
	 * ɾ���������ݵĹ��ﳵ
	 * @param hUserId
	 * @return
	 */
	boolean deleteAllChecked(int hUserId);
}

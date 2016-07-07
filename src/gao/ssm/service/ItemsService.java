package gao.ssm.service;

import java.util.List;

import gao.ssm.po.ItemsCustom;
import gao.ssm.po.ItemsQueryVo;

/**
 * ��Ʒ�����service
 * @author DELL
 *
 */
public interface ItemsService {
	// ��Ʒ��ѯ�б�
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	// ����id��ѯ��Ʒ��Ϣ
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	// �����û���Ϣ
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
}

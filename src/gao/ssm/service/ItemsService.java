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
}

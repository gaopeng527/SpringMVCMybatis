package gao.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gao.ssm.mapper.ItemsMapperCustom;
import gao.ssm.po.ItemsCustom;
import gao.ssm.po.ItemsQueryVo;
import gao.ssm.service.ItemsService;
/**
 * ������Ʒʵ��
 * @author DELL
 *
 */
public class ItemsServiceImpl implements ItemsService {
	// �Զ�ע���ѯ��Ʒ��Ϣ��mapper�ӿ�
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// ͨ��itemsMapperCustom��ѯ���ݿ�
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

}

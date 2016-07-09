package gao.ssm.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import gao.ssm.mapper.ItemsMapperCustom;
import gao.ssm.po.Items;
import gao.ssm.po.ItemsCustom;
import gao.ssm.po.ItemsExample;
import gao.ssm.po.ItemsQueryVo;
import gao.ssm.service.ItemsService;
import gao.ssm.mapper.ItemsMapper;
/**
 * ������Ʒʵ��
 * @author DELL
 *
 */
public class ItemsServiceImpl implements ItemsService {
	// �Զ�ע���ѯ��Ʒ��Ϣ��mapper�ӿ�
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// ͨ��itemsMapperCustom��ѯ���ݿ�
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		// �м����Ʒ��Щҵ����
		// ...
		// ���ش�����ItemsCustom��Ϣ
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// ���ҵ��У�飬ͨ����service�ӿڶԹؼ���������У��
		// У��id�Ƿ�Ϊ�գ����Ϊ���׳��쳣
		
		// updateByPrimaryKeyWithBLOBs()���Ը���id����items�е��������ݣ��������ı�����
		// Ҫ����봫��id��Ϣ
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

	@Override
	public void deleteItems(Integer[] items_id) throws Exception {
		ItemsExample itemsExample = new ItemsExample();
		//ͨ��criteria����ɾ������
		ItemsExample.Criteria criteria = itemsExample.createCriteria();
		criteria.andIdIn(Arrays.asList(items_id));
		itemsMapper.deleteByExample(itemsExample);
	}

}

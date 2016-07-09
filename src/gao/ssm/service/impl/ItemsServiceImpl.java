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
 * 管理商品实现
 * @author DELL
 *
 */
public class ItemsServiceImpl implements ItemsService {
	// 自动注入查询商品信息地mapper接口
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// 通过itemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		// 中间对商品做些业务处理
		// ...
		// 返回处理后的ItemsCustom信息
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// 添加业务校验，通常在service接口对关键参数进行校验
		// 校验id是否为空，如果为空抛出异常
		
		// updateByPrimaryKeyWithBLOBs()可以根据id更新items中的所有数据，包括大文本数据
		// 要求必须传入id信息
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

	@Override
	public void deleteItems(Integer[] items_id) throws Exception {
		ItemsExample itemsExample = new ItemsExample();
		//通过criteria构造删除条件
		ItemsExample.Criteria criteria = itemsExample.createCriteria();
		criteria.andIdIn(Arrays.asList(items_id));
		itemsMapper.deleteByExample(itemsExample);
	}

}

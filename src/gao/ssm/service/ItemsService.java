package gao.ssm.service;

import java.util.List;

import gao.ssm.po.ItemsCustom;
import gao.ssm.po.ItemsQueryVo;

/**
 * 商品管理的service
 * @author DELL
 *
 */
public interface ItemsService {
	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	// 根据id查询商品信息
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	// 更新用户信息
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
	
	// 根据id批量删除商品信息
	public void deleteItems(Integer[] items_id) throws Exception;
}

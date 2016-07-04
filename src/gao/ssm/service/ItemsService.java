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
}

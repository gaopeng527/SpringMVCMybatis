package gao.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gao.ssm.mapper.ItemsMapperCustom;
import gao.ssm.po.ItemsCustom;
import gao.ssm.po.ItemsQueryVo;
import gao.ssm.service.ItemsService;
/**
 * 管理商品实现
 * @author DELL
 *
 */
public class ItemsServiceImpl implements ItemsService {
	// 自动注入查询商品信息地mapper接口
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// 通过itemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

}

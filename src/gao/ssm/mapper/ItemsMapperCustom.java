package gao.ssm.mapper;

import java.util.List;

import gao.ssm.po.ItemsCustom;
import gao.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
    // 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
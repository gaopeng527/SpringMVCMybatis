package gao.ssm.mapper;

import java.util.List;

import gao.ssm.po.ItemsCustom;
import gao.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
    // ��Ʒ��ѯ�б�
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
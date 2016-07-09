package gao.ssm.po;

import java.util.List;

/**
 * 商品信息的组合扩展类
 * @author DELL
 *
 */
public class ItemsQueryVo {
	// 商品信息
	private Items items;
	
	// 为了程序的可扩展性，对逆向工程原始生成的po进行扩展
	private ItemsCustom itemsCustom;
	
	// 批量商品信息
	private List<ItemsCustom> itemsList;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
}

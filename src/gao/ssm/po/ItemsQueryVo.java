package gao.ssm.po;

import java.util.List;

/**
 * ��Ʒ��Ϣ�������չ��
 * @author DELL
 *
 */
public class ItemsQueryVo {
	// ��Ʒ��Ϣ
	private Items items;
	
	// Ϊ�˳���Ŀ���չ�ԣ������򹤳�ԭʼ���ɵ�po������չ
	private ItemsCustom itemsCustom;
	
	// ������Ʒ��Ϣ
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

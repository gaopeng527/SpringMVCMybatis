package gao.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gao.ssm.po.ItemsCustom;

/**
 * json��������
 * @author DELL
 *
 */
@Controller
public class JsonTest {
	// ����json����Ʒ��Ϣ���������Ӧjson����Ʒ��Ϣ��
	// @RequestBody���������Ʒ��Ϣjson��ת��ΪItemsCustom����
	// @ResponseBody���ص�ItemsCustom����ת��Ϊ��Ʒ��Ϣ��json��
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception {
		return itemsCustom;
	}
	
	// ������key/value�������json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) throws Exception {
		return itemsCustom;
	}
}

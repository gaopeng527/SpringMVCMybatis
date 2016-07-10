package gao.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gao.ssm.po.ItemsCustom;

/**
 * json交互测试
 * @author DELL
 *
 */
@Controller
public class JsonTest {
	// 请求json（商品信息），输出响应json（商品信息）
	// @RequestBody将请求的商品信息json串转换为ItemsCustom对象
	// @ResponseBody返回的ItemsCustom对象转换为商品信息的json串
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception {
		return itemsCustom;
	}
	
	// 请求是key/value，输出是json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) throws Exception {
		return itemsCustom;
	}
}

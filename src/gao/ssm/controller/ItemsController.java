package gao.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gao.ssm.po.ItemsCustom;
import gao.ssm.service.ItemsService;

/**
 * ��Ʒ��Controller
 * @author DELL
 *
 */
@Controller
public class ItemsController {
	// �Զ�ע��ҵ������Ʒ����Service
	@Autowired
	private ItemsService itemsService;
	
	// ��ѯ��Ʒ�б�
	// һ�㽨�齫��������urlд��һ��������ά��������ǰ�˿�����������Ϊ*.action����������д��д.action��������������ж�Ҫд��.action
	// @RequestMapping("/queryItems")ʵ�ַ�����url��ӳ�䣬һ��������Ӧһ��url
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception {
		// ����service�������ݿ⣬��ѯ��Ʒ�б�
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// �൱��request��setAttribute()��������jspҳ����ͨ��itemsList��ȡ����
		modelAndView.addObject("itemsList", itemsList);
		// ָ����ͼ
		// �±ߵ�·���������ͼ��������������jsp·����ǰ׺��jsp·���ĺ�׺�������޸�Ϊ
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// �ϱ�·���е�ǰ׺�ͺ�׺������ȥ��
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

	// ���Զ�����������
	// ��Ʒ���
	// ��Ʒ�޸�
	
}

package gao.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gao.ssm.po.ItemsCustom;
import gao.ssm.po.ItemsQueryVo;
import gao.ssm.service.ItemsService;

/**
 * ��Ʒ��Controller
 * @author DELL
 *
 */
@Controller
// Ϊ�˶�url���з���������������ﶨ���·�������շ���·���Ǹ�·��+��·��
// �����ѯ��Ʒ�б�url��Ϊ"/items/queryItems.action"
@RequestMapping("/items")
public class ItemsController {
	// �Զ�ע��ҵ������Ʒ����Service
	@Autowired
	private ItemsService itemsService;
	
	// ��ѯ��Ʒ�б�
	// һ�㽨�齫��������urlд��һ��������ά��������ǰ�˿�����������Ϊ*.action����������д��д.action��������������ж�Ҫд��.action
	// @RequestMapping("/queryItems")ʵ�ַ�����url��ӳ�䣬һ��������Ӧһ��url
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		// ����ҳ��ת����forward��request�ɹ���
		System.out.println(request.getParameter("id"));
		
		// ����service�������ݿ⣬��ѯ��Ʒ�б�
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
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

	// ��Ʒ��Ϣ�޸�ҳ����ʾ
	//@RequestMapping("/editItems")
	// ����http���󷽷�������post��get
//	@RequestMapping(value="/editItems",method={RequestMethod.POST, RequestMethod.GET})
//	public ModelAndView editItems() throws Exception{
//		// ����service����id��ѯ��Ʒ��Ϣ
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		// ����Ҫ���ص�ModelAndView
//		ModelAndView modelAndView = new ModelAndView();
//		// ����Ʒ��Ϣ��ӵ�ModeAndView
//		modelAndView.addObject("itemsCustom", itemsCustom);
//		// ������Ʒ�޸�ҳ��
//		modelAndView.setViewName("items/editItems");
//		// ������Ϣ
//		return modelAndView;
//	}
	
	/*
	ͨ��@RequestParam�Լ����͵Ĳ������а󶨡�
	�����ʹ��@RequestParam��Ҫ��request����������ƺ�controller�������β�����һ�£����ɰ󶨳ɹ���
	���ʹ��@RequestParam����������request����������ƺ�controller�������β�����һ�¡�
	ͨ��required����ָ�������Ƿ����Ҫ���룬�������Ϊtrue��û�д������������
	ͨ��defaultValue����Ĭ��ֵ�����id����û�д��룬��Ĭ��ֵ���βν��а�
	 */
	@RequestMapping(value="/editItems",method={RequestMethod.POST, RequestMethod.GET})
	public String editItems(Model model, @RequestParam(value="id",required=true) Integer items_id) throws Exception{
		// ����service����id��ѯ��Ʒ��Ϣ
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		// ͨ���β��е�model��Model���ݴ���ҳ��
		model.addAttribute("itemsCustom", itemsCustom);
		// ������Ϣ����ͼҳ��
		return "items/editItems";
	}
	
	// ��Ʒ��Ϣ�޸��ύ
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request, Integer id, ItemsCustom itemsCustom) throws Exception {
		// ����service������Ʒ��Ϣ��ҳ����Ҫ����Ϣ������λ�ã�ͨ�������󶨣�
		itemsService.updateItems(id, itemsCustom);
		
		// �ض�����Ʒ��ѯҳ��
//		return "redirect:queryItems.action";
		
		// ҳ��ת���������url���䣬request�ɹ���
//		return "forward:queryItems.action";
		
//		��controller�����β��Ͽ��Զ���request��response��ʹ��request��responseָ����Ӧ�����
//		1��ʹ��requestת��ҳ�棬���£�
//		request.getRequestDispatcher("ҳ��·��").forward(request, response);
//
//		2��Ҳ����ͨ��responseҳ���ض���
//		response.sendRedirect("url")
//
//		3��Ҳ����ͨ��responseָ����Ӧ�����������Ӧjson�������£�
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		response.getWriter().write("json��");
		
		return "success";
	}
	
	// ����ɾ����Ʒ��Ϣ
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		// ����serviceɾ����Ʒ
		itemsService.deleteItems(items_id);
		return "success";
	}
	
}

package gao.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import gao.ssm.controller.validation.ValidateGroup1;
import gao.ssm.controller.validation.ValidateGroup2;
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
	
	// ��Ʒ����
	// itemtypes��ʾ���ս������ķ���ֵ����request���е�key
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes() {

		Map<String, String> itemTypes = new HashMap<String, String>();
		itemTypes.put("101", "����");
		itemTypes.put("102", "ĸӤ");

		return itemTypes;
	}

	// ��ѯ��Ʒ��Ϣ������json������RESTful��url��ʽ
	// /itemsView/{id}�е�{id}��ʾ�����λ�õĲ�������@PathVariableָ�������Ƶ���
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception {
		// ����Service��ѯ��Ʒ��Ϣ
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
	}
	
	
	// ��ѯ��Ʒ�б�
	// һ�㽨�齫��������urlд��һ��������ά��������ǰ�˿�����������Ϊ*.action����������д��д.action��������������ж�Ҫд��.action
	// @RequestMapping("/queryItems")ʵ�ַ�����url��ӳ�䣬һ��������Ӧһ��url
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		// ����ҳ��ת����forward��request�ɹ���
//		System.out.println(request.getParameter("id"));
		
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
		// �жϲ�ѯ����Ƿ�Ϊ�գ��������idû�в�ѯ����Ʒ���׳��쳣����ʾ�û���Ʒ��Ϣ������
//		if(itemsCustom == null){
//			throw new CustomException("�޸ĵ���Ʒ��Ϣ�����ڣ�");
//		}
		// ͨ���β��е�model��Model���ݴ���ҳ��
//		model.addAttribute("itemsCustom", itemsCustom);
		model.addAttribute("items", itemsCustom); // ���Ի���
		// ������Ϣ����ͼҳ��
		return "items/editItems";
	}
	
	// ��Ʒ��Ϣ�޸��ύ
	// ����ҪУ���pojoǰ�����@Validated������ҪУ���pojo�����Ҫ���BindingResult bindingResult����У�������Ϣ
	// ע�⣺@Validated��BindingResult bindingResult����Գ��ֵģ��������β��е�˳���ǹ̶��ģ�һǰһ�󣩡�
	// value={ValidateGroup1.class}ָ��ʹ��ValidateGroup1��У�����
	// springmvcĬ�϶�pojo���ݽ��л��ԡ�pojo���ݴ���controller������springmvc�Զ���pojo���ݷŵ�request��key����pojo���ͣ�����ĸСд��
	// @ModelAttribute("items")����ָ��pojo���Ե�ҳ����request���е�key
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model, HttpServletRequest request, Integer id,
//			@ModelAttribute("items") @Validated(value={ValidateGroup1.class,ValidateGroup2.class}) ItemsCustom itemsCustom, BindingResult bindingResult) throws Exception {
			@Validated(value={ValidateGroup1.class,ValidateGroup2.class}) ItemsCustom itemsCustom, BindingResult bindingResult, 
			MultipartFile items_pic // ������ƷͼƬ
			) throws Exception {
		// ��ȡУ�������Ϣ
		if(bindingResult.hasErrors()){
			// ���������Ϣ
			List<ObjectError> allErrors =bindingResult.getAllErrors();
			for(ObjectError objectError:allErrors){
				System.out.println(objectError.getDefaultMessage());
			}
			// ��������Ϣ����ҳ��
			model.addAttribute("allErrors", allErrors);
			// ����ֱ��ʹ��model��pojo���Ե�ҳ�棨��򵥣����򵥵��������ͻ���ֻ�ܲ���model��
			model.addAttribute("items", itemsCustom);
			// �������µ���Ʒ���޸�ҳ��
			return "items/editItems";
		}
		
		// �ϴ�ͼƬ
		if(items_pic != null){
			// �洢ͼƬ������·��
			String pic_path = "E:\\apache-tomcat-8.0.36\\upload\\temp\\";
			// �ϴ�ͼƬ��ԭʼ����
			String originalFilename = items_pic.getOriginalFilename();
			if(originalFilename != null && originalFilename.length()>0){
				// �µ�ͼƬ����
				String newFilename = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				// ��ͼƬ
				File newFile = new File(pic_path+newFilename);
				// ���ڴ��е�����д�����
				items_pic.transferTo(newFile);
				// ���µ��ļ�����д��itemsCustom��
				itemsCustom.setPic(newFilename);
			}
		}
		// ��ֹ����û���ѡͼƬ�����ύ��ͼƬ��Ϊnull
		if(itemsCustom.getPic() == null){
			ItemsCustom itemsCustomOld = itemsService.findItemsById(id);
			itemsCustom.setPic(itemsCustomOld.getPic());
		}
		
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
	
	// �����޸���Ʒҳ��
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		
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
		modelAndView.setViewName("items/editItemsQuery");

		return modelAndView;
	}
	
	// �����޸���Ʒ�ύ��ʹ��List����ҳ���ύ���������ݣ�ͨ����װpojo���գ��ڰ�װpojo�ж���list<pojo>����
	// ͨ��itemsQueryVo���������ύ����Ʒ��Ϣ������Ʒ��Ϣ�洢��itemsQueryVo�е�itemsList������
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
		
		return "success";
	}
	
	// ʹ��Map����ҳ���ύ��������Ϣ��Ҳͨ���ڰ�װpojo�ж���map��������
//	��װ���ж���Map�������£�
//	Public class QueryVo {
//	private Map<String, Object> itemInfo = new HashMap<String, Object>();
//	  //get/set����..
//	}
//
//	ҳ�涨�����£�
//
//	<tr>
//	<td>ѧ����Ϣ��</td>
//	<td>
//	������<inputtype="text"name="itemInfo['name']"/>
//	���䣺<inputtype="text"name="itemInfo['price']"/>
//	.. .. ..
//	</td>
//	</tr>
//
//	Contrller�����������£�
//
//	public String useraddsubmit(Model model,QueryVo queryVo)throws Exception{
//	System.out.println(queryVo.getStudentinfo());
//	}

}

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
 * 商品的Controller
 * @author DELL
 *
 */
@Controller
// 为了对url进行分类管理，可以在这里定义根路径，最终访问路径是根路径+子路径
// 比如查询商品列表url变为"/items/queryItems.action"
@RequestMapping("/items")
public class ItemsController {
	// 自动注入业务层的商品管理Service
	@Autowired
	private ItemsService itemsService;
	
	// 商品分类
	// itemtypes表示最终将方法的返回值放在request域中的key
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes() {

		Map<String, String> itemTypes = new HashMap<String, String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");

		return itemTypes;
	}

	// 查询商品信息，返回json，采用RESTful的url格式
	// /itemsView/{id}中的{id}表示将这个位置的参数传到@PathVariable指定的名称当中
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception {
		// 调用Service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
	}
	
	
	// 查询商品列表
	// 一般建议将方法名和url写成一样，方便维护（由于前端控制器中配置为*.action，这里无论写不写.action，最终在浏览器中都要写上.action
	// @RequestMapping("/queryItems")实现方法和url的映射，一个方法对应一个url
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		// 测试页面转发（forward）request可共享
//		System.out.println(request.getParameter("id"));
		
		// 调用service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request的setAttribute()方法，在jsp页面中通过itemsList来取数据
		modelAndView.addObject("itemsList", itemsList);
		// 指定视图
		// 下边的路径如果在视图解析器中配置了jsp路径的前缀和jsp路径的后缀，可以修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边路径中的前缀和后缀都可以去掉
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

	// 商品信息修改页面显示
	//@RequestMapping("/editItems")
	// 限制http请求方法，可以post和get
//	@RequestMapping(value="/editItems",method={RequestMethod.POST, RequestMethod.GET})
//	public ModelAndView editItems() throws Exception{
//		// 调用service根据id查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		// 创建要返回的ModelAndView
//		ModelAndView modelAndView = new ModelAndView();
//		// 将商品信息添加到ModeAndView
//		modelAndView.addObject("itemsCustom", itemsCustom);
//		// 设置商品修改页面
//		modelAndView.setViewName("items/editItems");
//		// 返回信息
//		return modelAndView;
//	}
	
	/*
	通过@RequestParam对简单类型的参数进行绑定。
	如果不使用@RequestParam，要求request传入参数名称和controller方法的形参名称一致，方可绑定成功。
	如果使用@RequestParam，不用限制request传入参数名称和controller方法的形参名称一致。
	通过required属性指定参数是否必须要传入，如果设置为true，没有传入参数，报错
	通过defaultValue设置默认值，如果id参数没有传入，将默认值和形参进行绑定
	 */
	@RequestMapping(value="/editItems",method={RequestMethod.POST, RequestMethod.GET})
	public String editItems(Model model, @RequestParam(value="id",required=true) Integer items_id) throws Exception{
		// 调用service根据id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		// 判断查询结果是否为空，如果根据id没有查询到商品，抛出异常，提示用户商品信息不存在
//		if(itemsCustom == null){
//			throw new CustomException("修改的商品信息不存在！");
//		}
		// 通过形参中的model将Model数据传到页面
//		model.addAttribute("itemsCustom", itemsCustom);
		model.addAttribute("items", itemsCustom); // 测试回显
		// 返回信息，视图页面
		return "items/editItems";
	}
	
	// 商品信息修改提交
	// 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边需要添加BindingResult bindingResult接收校验出错信息
	// 注意：@Validated和BindingResult bindingResult是配对出现的，并且在形参中的顺序是固定的（一前一后）。
	// value={ValidateGroup1.class}指定使用ValidateGroup1的校验规则
	// springmvc默认对pojo数据进行回显。pojo数据传入controller方法后，springmvc自动将pojo数据放到request域，key等于pojo类型（首字母小写）
	// @ModelAttribute("items")可以指定pojo回显到页面在request域中的key
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model, HttpServletRequest request, Integer id,
//			@ModelAttribute("items") @Validated(value={ValidateGroup1.class,ValidateGroup2.class}) ItemsCustom itemsCustom, BindingResult bindingResult) throws Exception {
			@Validated(value={ValidateGroup1.class,ValidateGroup2.class}) ItemsCustom itemsCustom, BindingResult bindingResult, 
			MultipartFile items_pic // 接收商品图片
			) throws Exception {
		// 获取校验错误信息
		if(bindingResult.hasErrors()){
			// 输出错误信息
			List<ObjectError> allErrors =bindingResult.getAllErrors();
			for(ObjectError objectError:allErrors){
				System.out.println(objectError.getDefaultMessage());
			}
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			// 可以直接使用model将pojo回显到页面（最简单）（简单的数据类型回显只能采用model）
			model.addAttribute("items", itemsCustom);
			// 出错重新到商品的修改页面
			return "items/editItems";
		}
		
		// 上传图片
		if(items_pic != null){
			// 存储图片的物理路径
			String pic_path = "E:\\apache-tomcat-8.0.36\\upload\\temp\\";
			// 上传图片的原始名称
			String originalFilename = items_pic.getOriginalFilename();
			if(originalFilename != null && originalFilename.length()>0){
				// 新的图片名称
				String newFilename = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				// 新图片
				File newFile = new File(pic_path+newFilename);
				// 将内存中的数据写入磁盘
				items_pic.transferTo(newFile);
				// 将新的文件名称写到itemsCustom中
				itemsCustom.setPic(newFilename);
			}
		}
		// 防止如果用户不选图片进行提交，图片变为null
		if(itemsCustom.getPic() == null){
			ItemsCustom itemsCustomOld = itemsService.findItemsById(id);
			itemsCustom.setPic(itemsCustomOld.getPic());
		}
		
		// 调用service更新商品信息，页面需要将信息传到此位置（通过参数绑定）
		itemsService.updateItems(id, itemsCustom);
		
		// 重定向到商品查询页面
//		return "redirect:queryItems.action";
		
		// 页面转发，浏览器url不变，request可共享
//		return "forward:queryItems.action";
		
//		在controller方法形参上可以定义request和response，使用request或response指定响应结果：
//		1、使用request转向页面，如下：
//		request.getRequestDispatcher("页面路径").forward(request, response);
//
//		2、也可以通过response页面重定向：
//		response.sendRedirect("url")
//
//		3、也可以通过response指定响应结果，例如响应json数据如下：
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		response.getWriter().write("json串");
		
		return "success";
	}
	
	// 批量删除商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		// 调用service删除商品
		itemsService.deleteItems(items_id);
		return "success";
	}
	
	// 批量修改商品页面
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		
		// 调用service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request的setAttribute()方法，在jsp页面中通过itemsList来取数据
		modelAndView.addObject("itemsList", itemsList);
		// 指定视图
		// 下边的路径如果在视图解析器中配置了jsp路径的前缀和jsp路径的后缀，可以修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边路径中的前缀和后缀都可以去掉
		modelAndView.setViewName("items/editItemsQuery");

		return modelAndView;
	}
	
	// 批量修改商品提交，使用List接收页面提交的批量数据，通过包装pojo接收，在包装pojo中定义list<pojo>属性
	// 通过itemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中的itemsList属性中
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
		
		return "success";
	}
	
	// 使用Map接收页面提交的数据信息，也通过在包装pojo中定义map类型属性
//	包装类中定义Map对象如下：
//	Public class QueryVo {
//	private Map<String, Object> itemInfo = new HashMap<String, Object>();
//	  //get/set方法..
//	}
//
//	页面定义如下：
//
//	<tr>
//	<td>学生信息：</td>
//	<td>
//	姓名：<inputtype="text"name="itemInfo['name']"/>
//	年龄：<inputtype="text"name="itemInfo['price']"/>
//	.. .. ..
//	</td>
//	</tr>
//
//	Contrller方法定义如下：
//
//	public String useraddsubmit(Model model,QueryVo queryVo)throws Exception{
//	System.out.println(queryVo.getStudentinfo());
//	}

}

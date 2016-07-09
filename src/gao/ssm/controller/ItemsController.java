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
	
	// 查询商品列表
	// 一般建议将方法名和url写成一样，方便维护（由于前端控制器中配置为*.action，这里无论写不写.action，最终在浏览器中都要写上.action
	// @RequestMapping("/queryItems")实现方法和url的映射，一个方法对应一个url
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		// 测试页面转发（forward）request可共享
		System.out.println(request.getParameter("id"));
		
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
		// 通过形参中的model将Model数据传到页面
		model.addAttribute("itemsCustom", itemsCustom);
		// 返回信息，视图页面
		return "items/editItems";
	}
	
	// 商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request, Integer id, ItemsCustom itemsCustom) throws Exception {
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
	
}

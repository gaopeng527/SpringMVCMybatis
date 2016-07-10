package gao.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录页面的Controller
 * @author DELL
 *
 */
@Controller
public class LoginController {
	// 登录
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password) throws Exception {
		// 调用Service对用户身份信息进行校验
		// ...
		// 校验通过在session中保存用户身份信息
		session.setAttribute("username", username);
		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}
	
	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// 清除session中的用户身份信息
		session.invalidate();
		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}
}

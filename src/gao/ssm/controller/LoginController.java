package gao.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ��¼ҳ���Controller
 * @author DELL
 *
 */
@Controller
public class LoginController {
	// ��¼
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password) throws Exception {
		// ����Service���û������Ϣ����У��
		// ...
		// У��ͨ����session�б����û������Ϣ
		session.setAttribute("username", username);
		// �ض�����Ʒ�б�ҳ��
		return "redirect:/items/queryItems.action";
	}
	
	// �˳�
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// ���session�е��û������Ϣ
		session.invalidate();
		// �ض�����Ʒ�б�ҳ��
		return "redirect:/items/queryItems.action";
	}
}

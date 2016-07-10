package gao.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����������1
 * @author DELL
 *
 */
public class HandlerInterceptor2 implements HandlerInterceptor {

	// ִ��handler��ֹ���֮��ִ�д˷���
	// Ӧ�ó�����ͳһ�쳣����ͳһ��־����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2...afterCompletion");
	}

	// ����handler����֮���ڷ���modelAndView֮ǰִ��
	// Ӧ�ó�����ModelAndView�����������õ�ģ�����ݣ�����˵�������������ͼ��Ҳ����������ͳһָ����ͼ
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2...postHandle");
	}

	// ��ִ��handler����֮ǰִ��
	// ���������֤�������Ȩ
	// ���������֤�������֤δͨ����������ǰ�û�δ��¼����Ҫ�˷����������ز�������ִ�У�return false��ʾ����
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2...preHandle");
		return true;
	}

}

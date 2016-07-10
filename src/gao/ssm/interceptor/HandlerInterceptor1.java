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
public class HandlerInterceptor1 implements HandlerInterceptor {

	// ִ��handler��ֹ���֮��ִ�д˷���
	// Ӧ�ó�����ͳһ�쳣����ͳһ��־����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1...afterCompletion");
		
	}

	// ����handler����֮���ڷ���modelAndView֮ǰִ��
	// Ӧ�ó�����ModelAndView�����������õ�ģ�����ݣ�����˵�������������ͼ��Ҳ����������ͳһָ����ͼ
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1...postHandle");
	}

	// ��ִ��handler����֮ǰִ��
	// ���������֤�������Ȩ
	// ���������֤�������֤δͨ����������ǰ�û�δ��¼����Ҫ�˷����������ز�������ִ�У�return false��ʾ����
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1...preHandle");
		return true;
	}
	
//	����������������
//
//	HandlerInterceptor1...preHandle
//	HandlerInterceptor2...preHandle
//
//	HandlerInterceptor2...postHandle
//	HandlerInterceptor1...postHandle
//
//	HandlerInterceptor2...afterCompletion
//	HandlerInterceptor1...afterCompletion
//
//	�ܽ᣺
//	preHandle������˳��ִ�У�
//	postHandle��afterCompletion�����������õ�����˳��ִ�С�
//
//	������1���У�������2������
//	HandlerInterceptor1...preHandle
//	HandlerInterceptor2...preHandle
//	HandlerInterceptor1...afterCompletion
//
//	�ܽ᣺
//	������1���У�������2 preHandle�Ż�ִ�С�
//	������2 preHandle�����У�������2 postHandle��afterCompletion����ִ�С�
//	ֻҪ��һ�������������У�postHandle����ִ�С�
//
//	������1�����У�������2������
//	HandlerInterceptor1...preHandle
//
//	������1 preHandle�����У�postHandle��afterCompletion����ִ�С�
//	������1 preHandle�����У�������2��ִ�С�
//
//
//	С��
//
//	���ݲ��Խ������������Ӧ�á�
//
//	���磺ͳһ��־��������������Ҫ�� ������preHandleһ��Ҫ���У��ҽ������������������е�һ��λ�á�
//
//	���磺��½��֤�����������������������е�һ��λ�á�Ȩ��У�������������ڵ�½��֤������֮�󡣣���Ϊ��½ͨ�����У��Ȩ�ޣ�


}

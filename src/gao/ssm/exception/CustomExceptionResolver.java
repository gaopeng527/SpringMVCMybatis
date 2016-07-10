package gao.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * �Զ���ȫ���쳣������
 * @author DELL
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
	/**
	 * handler���Ǵ�����������Ҫִ�е�handler���󣨶�����ֻ��һ��method������
	 * ex ��ϵͳ�׳����쳣
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		// �������쳣���ͣ�������쳣������ϵͳ�Զ�����쳣��ֱ��ȡ���쳣��Ϣ���ڴ���ҳ��չʾ
//		String message = null;
//		if(ex instanceof CustomException){
//			message = ((CustomException)ex).getMessage();			
//		} else {
//			// ������쳣���Ͳ���ϵͳ�Զ�����쳣������һ���Զ�����쳣���ͣ���ϢΪ��δ֪���󡱣�
//			message = "δ֪����";
//		}
		
		// �ϱߴ���ɱ�Ϊ
		CustomException customException = null;
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
		} else {
			customException = new CustomException("δ֪����");
		}
		// ������Ϣ
		String message = customException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		// ��������Ϣ����ҳ��
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
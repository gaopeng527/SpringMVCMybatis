package gao.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试拦截器1
 * @author DELL
 *
 */
public class HandlerInterceptor2 implements HandlerInterceptor {

	// 执行handler防止完成之后执行此方法
	// 应用场景：统一异常处理、统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2...afterCompletion");
	}

	// 进入handler方法之后，在返回modelAndView之前执行
	// 应用场景从ModelAndView出发：将公用的模型数据（比如菜单导航）传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2...postHandle");
	}

	// 在执行handler方法之前执行
	// 用于身份认证、身份授权
	// 比如身份认证，如果认证未通过，表明当前用户未登录，需要此方法进行拦截不再往下执行，return false表示拦截
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2...preHandle");
		return true;
	}

}

package gao.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录认证拦截器
 * @author DELL
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	// 执行handler防止完成之后执行此方法
	// 应用场景：统一异常处理、统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	// 进入handler方法之后，在返回modelAndView之前执行
	// 应用场景从ModelAndView出发：将公用的模型数据（比如菜单导航）传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
	}

	// 在执行handler方法之前执行
	// 用于身份认证、身份授权
	// 比如身份认证，如果认证未通过，表明当前用户未登录，需要此方法进行拦截不再往下执行，return false表示拦截
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 获取请求url
		String url = request.getRequestURI();
		// 判断url是否为公开地址（实际使用时将公开地址配置在配置文件中），这里的公开地址就是登录提交的地址
		if (url.indexOf("login.action") >= 0) {
			// 如果进行登录提交，放行
			return true;
		}
		// 判断session
		HttpSession session = request.getSession();
		// 从session中取出用户的身份信息
		String username = (String) session.getAttribute("username");
		if(username != null){
			// 身份信息存在，放行
			return true;
		}
		// 执行到这里表明用户身份需要认证，跳转到登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}
	
//	两个拦截器都放行
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
//	总结：
//	preHandle方法按顺序执行，
//	postHandle和afterCompletion按拦截器配置的逆向顺序执行。
//
//	拦截器1放行，拦截器2不放行
//	HandlerInterceptor1...preHandle
//	HandlerInterceptor2...preHandle
//	HandlerInterceptor1...afterCompletion
//
//	总结：
//	拦截器1放行，拦截器2 preHandle才会执行。
//	拦截器2 preHandle不放行，拦截器2 postHandle和afterCompletion不会执行。
//	只要有一个拦截器不放行，postHandle不会执行。
//
//	拦截器1不放行，拦截器2不放行
//	HandlerInterceptor1...preHandle
//
//	拦截器1 preHandle不放行，postHandle和afterCompletion不会执行。
//	拦截器1 preHandle不放行，拦截器2不执行。
//
//
//	小结
//
//	根据测试结果，对拦截器应用。
//
//	比如：统一日志处理拦截器，需要该 拦截器preHandle一定要放行，且将它放在拦截器链接中第一个位置。
//
//	比如：登陆认证拦截器，放在拦截器链接中第一个位置。权限校验拦截器，放在登陆认证拦截器之后。（因为登陆通过后才校验权限）


}

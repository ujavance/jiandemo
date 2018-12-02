package com.uj.jian.intercepter;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uj.jian.utils.SingletonLogger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * 登陆拦截器
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}
 
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2) throws Exception {

	       String requestURI = request.getRequestURI();
	       if (requestURI.indexOf("user")>0){
			   SingletonLogger.logger.info("intercepter -- enter url 'user' direct ", requestURI );
	       		return true;
		   }else{
			   HttpSession session = request.getSession();
			   String userId = (String) session.getAttribute("userId");
			   SingletonLogger.logger.info("intercepter -- have userId in session, userId is ", userId==null?"not exsit":userId );
			   if(userId!=null){
				   //登陆成功的用户
				   return true;
			   }else{
				   //没有登陆，转向登陆界面
				   request.getRequestDispatcher("/index.jsp").forward(request,arg1);
				   return false;
			   }
		   }
	}
}

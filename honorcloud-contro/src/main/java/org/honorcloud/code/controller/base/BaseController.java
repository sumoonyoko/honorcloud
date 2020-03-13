package org.honorcloud.code.controller.base;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {
	
	public static final String port = "8080"; 
    private static final String PATTERN_IP = "(\\d*\\.){3}\\d*";
    private static final Pattern ipPattern = Pattern.compile(PATTERN_IP);
	
    /**
     * 获取当前客户端session对象
     * @return
     */
    public HttpSession getSession() {
    	return getRequest().getSession();
    }
    
    /**
     * 获取当前客户端Request对象
     * @return
     */
    public HttpServletRequest getRequest() {
    	return getRequestAttributes().getRequest();
    }
    
    /**
     * 获取当前客户端Response对象
     * @return
     */
    public HttpServletResponse getResponse() {
    	return  getRequestAttributes().getResponse();
    }
    
    /**
     * 获取项目根目录
     * @param request
     * @return
     */
    protected String getBasePath(HttpServletRequest request) {
    	String basePath = (ipPattern.matcher(request.getServerName()).find() ? request.getScheme() :"https")
    			//上面的代码返回当前链接使用的协议；一般应用返回http;SSL返回https;
    			+ "://" + request.getServerName() + port + request.getContextPath();
		return basePath;
	}
    
	/**
	 * 设置SessionAttribute
	 * @param name
	 * @param value
	 */
	public void setSessionAttribute(String name, Object value) {
		getSession().setAttribute(name, value);
	}
	
	/**
	 * 获取SessionAttribute
	 * @param name
	 * @return
	 */
	public Object getSessionAttribute(String name) {
		return getSession().getAttribute(name);
	}

	
    /**
     * 从thread local获取网络上下文
     */
    public ServletRequestAttributes getRequestAttributes() {
    	return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }
    
    /**
     * 从thread local获取网络上下文
     */
//    public HttpServletRequest getServletRequest() {
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes servletRequestAttributes;
//        if (requestAttributes instanceof ServletRequestAttributes) {
//            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
//            return servletRequestAttributes.getRequest();
//        }
//        return null;
//    }
    
//  * 获取客户端的cookie，按照名称封装到map结构中
   protected Map<String, Cookie> getCookieMap(HttpServletRequest request) {
       Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
       Cookie[] cookies = request.getCookies();
       if (null != cookies) {
           for (Cookie cookie : cookies) {
               cookieMap.put(cookie.getName(), cookie);
           }
       }
       return cookieMap;
   }
   
   /**
    * 设置 cookie
    * 
    * @param cookieName
    * @param value
    * @param age
    */
   protected void setCookie(String cookieName, String value, int age) {
       Cookie cookie = new Cookie(cookieName, value);
       cookie.setMaxAge(age);
       // cookie.setHttpOnly(true);
       getResponse().addCookie(cookie);
   }
   
}

package com.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.util.Message;

/**捕捉常见异常，增加系统的容错性
 * @author chuankun
 *@2016年5月9日 上午9:45:36
 * email:yichuankun@qq.com
 */
public class ExceptionHandlerFilter implements  Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			// TODO: handle exceptionrr
			Throwable root = e;
			while(root.getCause()!=null){  //递归直至找到所有的问题
				root = root.getCause();
			}
			if (NumberFormatException.class.isInstance(root)){   //处理数据转化异常的问题
				response.getWriter().write(Message.getMessage(0, "parm from not right!", "").toString());
			}
		}
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

package com.test.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String site = filterConfig.getInitParameter("test-param");
		System.out.println("网站名称: " + site);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// 输出站点名称
        System.out.println("认证过滤器！");

        // 把请求传回过滤链
        chain.doFilter(request,response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

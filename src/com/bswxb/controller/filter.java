/*package com.bswxb.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bswxb.po.User;


@SuppressWarnings("serial")
public class filter  extends HttpServlet implements Filter {

	@Override
	public void destroy() {
	
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
	
		
		//第一步一般都是将请求和响应对象进行强转
		HttpServletRequest req = (HttpServletRequest)servletRequest;  
        HttpServletResponse resp = (HttpServletResponse)servletResponse;  
	    User user= new User();
	    user=  (User) req.getSession().getAttribute("user");
	    
		if(user.getUname().equals("fg885436dfg")) {
			
			
			
			chain.doFilter(req, resp);
		} else {
			
			req.getRequestDispatcher("views/table.jsp").forward(req, resp);
			System.out.println("禁止！");
		}
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		System.out.println("dasdkjgashkdjhgasjhkdgjashgdjhasgjgasjhkgdjkhasgdjhkasgjhk");
		
	}
	
	
	


	
	
	

}
*/
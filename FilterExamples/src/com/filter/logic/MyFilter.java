package com.filter.logic;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class MyFilter implements Filter{

	public void init(FilterConfig arg0) throws ServletException {}
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Filter Condition Run First");
		
		
		PrintWriter out=resp.getWriter();
		
		String password=req.getParameter("password");
		if(password.equals("admin")){
		chain.doFilter(req, resp);//sends request to next resource
		System.out.println("Filter Condition is true");
		}
		else{
		out.print("Password Invalid!!!");
		// Filter is always running first
		// Filter Logic first check then next
		// Filter Logic true then enter servlet
		System.out.println("Filter Condition is false!!! so redirect to index");
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.include(req, resp);
		}
		
	}
	public void destroy() {}
   
	}

package com.web.application.conf.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
// 暂不启用
public class SessionFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8"); // 跨域设置
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
		response.addHeader("Allow", "POST,GET,OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Autority");
		response.setHeader("Access-Control-Allow-Credentials", "true"); // 是否支持cookie跨域
		
//		String address=request.getLocalAddr();
		filterChain.doFilter(request, response);
	}

}

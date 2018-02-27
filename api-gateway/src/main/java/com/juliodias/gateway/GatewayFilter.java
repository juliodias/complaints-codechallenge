package com.juliodias.gateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class GatewayFilter extends ZuulFilter {

	private static final Logger LOG = LoggerFactory.getLogger(GatewayFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext(); 
		HttpServletRequest request = requestContext.getRequest();
		LOG.info("{} request to {}", request.getMethod(), request.getRequestURL().toString());
		return null;
	}
}

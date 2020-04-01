package com.evenugo.web.filter;


import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Filtro de ejemplo.
 */
// @WebFilter("/*")
public class HelloWorldFilter implements Filter {
	private static Logger logger = LogManager.getLogger(HelloWorldFilter.class.getName());

    public HelloWorldFilter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("Entrando en doFilter... ");
		HttpServletRequest httpRequest = (HttpServletRequest) request; 
		
		Map<String, String[]> parametros = httpRequest.getParameterMap();
		
		String parameterName;
		String[] parameterValues;
		
		logger.info("Recibida petici�n para {} con {} parametros", httpRequest.getRequestURL(), parametros.size());
		for (Iterator<String> it = parametros.keySet().iterator(); it.hasNext(); ) {
			parameterName = it.next();
			parameterValues = parametros.get(parameterName);
			
			logger.info(parameterName+" = "+Arrays.toString(parameterValues));
		}
		
		
		chain.doFilter(request, response);
		
		logger.info("... saliendo de doFilter");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
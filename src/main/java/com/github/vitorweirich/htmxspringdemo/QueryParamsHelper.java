package com.github.vitorweirich.htmxspringdemo;

import java.util.Map;
import java.util.Objects;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class QueryParamsHelper {
	
	public Integer getCurrentPage(Map<String, Object> params) {
		Object pageParam = params.get("page");
		
		if(Objects.isNull(pageParam)) {
			return 0;
		}
		
		return Integer.parseInt((String) pageParam);
	}
	
	public String toPage(Integer pageToGo) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.replaceQueryParam("page", pageToGo)
				.build().toString();
	}
}

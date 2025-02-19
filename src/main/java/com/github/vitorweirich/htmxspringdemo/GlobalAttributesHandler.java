package com.github.vitorweirich.htmxspringdemo;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = Controller.class)
public class GlobalAttributesHandler {

	@ModelAttribute
	public void addQueryParams(Model model, HttpServletRequest request) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, String> queryParams = parameterMap.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> String.join(",", entry.getValue())
				));

		model.addAttribute("basePath", request.getRequestURI());
		model.addAttribute("queryParamsMap", queryParams);
		model.addAttribute("queryParamsString", queryParams.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&")));
	}
}

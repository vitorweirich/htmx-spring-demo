package com.github.vitorweirich.htmxspringdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonHelper {
	
	private ObjectMapper mapper;
	
	public JsonHelper() {
		this.mapper = new ObjectMapper();
		this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	public String convertToJson(Object object) throws JsonProcessingException {
	    return this.mapper.writeValueAsString(object);
	}
	
}

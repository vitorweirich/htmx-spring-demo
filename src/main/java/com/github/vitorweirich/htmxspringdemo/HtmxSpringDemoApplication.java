package com.github.vitorweirich.htmxspringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@SpringBootApplication
public class HtmxSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmxSpringDemoApplication.class, args);
	}
	
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver( @Autowired SpringTemplateEngine templateEngine ) {
	    ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
	    thymeleafViewResolver.setTemplateEngine( templateEngine );
	    thymeleafViewResolver.setCharacterEncoding( "UTF-8" );
	    thymeleafViewResolver.addStaticVariable( "queryHelper", new QueryParamsHelper() );
	    thymeleafViewResolver.addStaticVariable( "jsonHelper", new JsonHelper() );
	    return thymeleafViewResolver;
	}

}

package com.vostrik.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * Объявляем конфигурационный класс (с помощью аннотации @Configuration).
 * С помощью аннотации @ComponentScan указываем фреймворку Spring, что компоненты надо искать внутри перечисленных пакетов
 * Импортируем класс с настройками безопасности, собственно сам конфигуратор Spring Security
 * (с помощью аннотации @Import({ AppSecurityConfig.class })).
 * Эта строчка специально закомментирована в коде. Хотелось показать,
 * что класс с настройками безопасности(AppSecurityConfig.java) отмеченный
 * (как вы увидите ниже) аннотацией @Configuration будет автоматически найден
 * и подключен базовым контекстом апликации Spring фреймворка, потому что путь к пакету содерфащему
 * класс AppSecurityConfig указан в аннотации @ComponentScan.
 * Благодаря этому Spring найдет и подключит конфигурационный класс автоматически.
 */
@EnableWebMvc
@Configuration // Объявляем конфигурационный класс
@ComponentScan({ "com.vostrik.config.security", "com.vostrik.config.db", "com.vostrik.web", "com.vostrik.dao",
		"com.vostrik.exception", "com.vostrik.validator"})
//@Import({ AppSecurityConfig.class })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	/**
	 * Указываем что вьюшки будут лежать в директории /WEB-INF/views/
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasenames(new String[] { "messages/messages", "messages/validation" });
		return rb;
	}

}
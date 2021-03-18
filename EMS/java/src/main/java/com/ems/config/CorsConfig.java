package com.ems.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
		.allowedMethods("GET","POST","PUT","DELETE")
		.allowedHeaders("*")
		.allowedOrigins("http://localhost:4200");
			
		}
		@Bean
		public CorsFilter corsFilter() {
		    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		    // Allow anyone and anything access. Probably ok for Swagger spec
		    CorsConfiguration config = new CorsConfiguration();
		    config.setAllowCredentials(true);
		    config.addAllowedOrigin("*");
		    config.addAllowedHeader("*");
		    config.addAllowedMethod("*");

		    source.registerCorsConfiguration("/v2/api-docs", config);
		    return new CorsFilter(source);
		}

		@Override
		public void configurePathMatch(PathMatchConfigurer configurer) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addFormatters(FormatterRegistry registry) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Validator getValidator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageCodesResolver getMessageCodesResolver() {
			// TODO Auto-generated method stub
			return null;
		}
	};
}
}
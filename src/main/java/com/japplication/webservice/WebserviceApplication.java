package com.japplication.webservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class WebserviceApplication {

	@Value("${spring.application.name}")
	public String applicationName;

	@Value("${welcome.message}")
	public String welcomeText;

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String defaultResponse(){
		return applicationName + welcomeText;
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/product/").allowedOrigins("http://localhost:4200").allowedMethods("*");
//
//			}
//		};
//	}

}

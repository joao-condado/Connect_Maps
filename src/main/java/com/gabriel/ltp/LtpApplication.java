package com.gabriel.ltp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtpApplication.class, args);

		System.out.println("ssss");

	}

	@Configuration
	public class WebConfig implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry){

			registry.addMapping("/**").allowedOrigins("http://localhost:3306");

			registry.addMapping("/**").allowedOrigins("http://localhost:5173");

		}
	}
}

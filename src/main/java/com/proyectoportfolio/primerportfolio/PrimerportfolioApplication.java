package com.proyectoportfolio.primerportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PrimerportfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerportfolioApplication.class, args);
	}
        
        @Bean
        public WebMvcConfigurer corsConfigurer() {
	       return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://portafolio-web-70535.web.app/");
			}
		};
	}

}


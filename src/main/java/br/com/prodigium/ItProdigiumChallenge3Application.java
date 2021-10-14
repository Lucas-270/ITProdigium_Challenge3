package br.com.prodigium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ItProdigiumChallenge3Application {

	public static void main(String[] args) {
		SpringApplication.run(ItProdigiumChallenge3Application.class, args);
	}
	
	@Override
    	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(ItProdigiumChallenge3Application.class);
    	}

}

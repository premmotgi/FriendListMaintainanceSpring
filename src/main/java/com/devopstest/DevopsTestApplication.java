package com.devopstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
//dont use component scan for spring boot, let boot itself scan packages
public class DevopsTestApplication extends SpringBootServletInitializer{


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DevopsTestApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DevopsTestApplication.class, args);

	}

}

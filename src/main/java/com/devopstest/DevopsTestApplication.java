package com.devopstest;

import com.devopstest.controller.FriendController;
import com.devopstest.controller.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//https://github.com/premmotgi/hello-world.git

@SpringBootApplication
//dont use component scan for spring boot, let boot itself scan packages
public class DevopsTestApplication  {


	public static void main(String[] args) {
		SpringApplication.run(DevopsTestApplication.class, args);

	}

}

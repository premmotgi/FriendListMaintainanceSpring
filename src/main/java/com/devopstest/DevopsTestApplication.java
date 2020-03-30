package com.devopstest;

import com.devopstest.controller.FriendController;
import com.devopstest.controller.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
//dont use component scan for spring boot, let boot itself scan packages
public class DevopsTestApplication extends SpringBootServletInitializer{


	public static void main(String[] args) {
		SpringApplication.run(DevopsTestApplication.class, args);

	}

}

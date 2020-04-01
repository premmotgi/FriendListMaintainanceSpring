package com.devopstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://github.com/premmotgi/hello-world.git

@SpringBootApplication
//dont use component scan for spring boot, let boot itself scan packages
public class DevopsTestApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DevopsTestApplication.class, args);

	}

}

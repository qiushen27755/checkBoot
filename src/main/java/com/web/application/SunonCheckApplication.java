package com.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
/**
 * 
 * @author Q_qsl 2020-01-10 
 */


@SpringBootApplication
@EnableCaching
@ServletComponentScan("com.web.application.conf.filter")

public class SunonCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunonCheckApplication.class, args);
	}

}

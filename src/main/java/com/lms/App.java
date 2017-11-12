package com.lms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("com.lms")
@PropertySource("classpath:/application.properties")
public class App {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new SpringApplicationBuilder(App.class).headless(false).run(args);
		context.getBean(CallingService.class).call();
		//SpringApplication.run(Test.class, args);
	}
}

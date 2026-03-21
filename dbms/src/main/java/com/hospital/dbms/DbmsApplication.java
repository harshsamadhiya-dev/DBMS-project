package com.hospital.dbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hospital.dbms.ui.MainUI;

@SpringBootApplication
public class DbmsApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DbmsApplication.class);
        app.setHeadless(false);

        ApplicationContext context = app.run(args);

        MainUI.launch(context);
	}
}

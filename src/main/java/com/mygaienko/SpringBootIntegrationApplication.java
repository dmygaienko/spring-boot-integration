package com.mygaienko;

import com.mygaienko.config.GeneralConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Import(GeneralConfig.class)
public class SpringBootIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIntegrationApplication.class, args);
	}
}

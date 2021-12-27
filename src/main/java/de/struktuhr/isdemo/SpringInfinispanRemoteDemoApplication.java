package de.struktuhr.isdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringInfinispanRemoteDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInfinispanRemoteDemoApplication.class, args);
	}

}

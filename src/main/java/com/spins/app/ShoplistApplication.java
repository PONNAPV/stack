package com.spins.app;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class ShoplistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoplistApplication.class, args);
	}

}

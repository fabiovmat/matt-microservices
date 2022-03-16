package br.com.matt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MattConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MattConfigServerApplication.class, args);
	}

}

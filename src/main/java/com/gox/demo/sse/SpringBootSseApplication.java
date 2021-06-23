package com.gox.demo.sse;

import com.gox.demo.sse.entity.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@SpringBootApplication
public class SpringBootSseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSseApplication.class, args);
	}

}

package com.jos.dem.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WebClientApplication {

  @Bean
  public WebClient webClient() {
    return WebClient.create("https://api.github.com/");
  }

	public static void main(String[] args) {
		SpringApplication.run(WebClientApplication.class, args);
	}

}

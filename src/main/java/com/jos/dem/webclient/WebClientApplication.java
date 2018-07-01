package com.jos.dem.webclient;

import static java.nio.charset.StandardCharsets.UTF_8;

import org.springframework.util.Base64Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class WebClientApplication {

  @Value("${gitHubUrl}")
  private String gitHubUrl;
  @Value("${username}")
  private String username;
  @Value("${token}")
  private String token;

  @Bean
  public WebClient webClient() {
    return WebClient
      .builder()
        .baseUrl(gitHubUrl)
        .defaultHeader("Authorization", "Basic " + Base64Utils
          .encodeToString((username + ":" + token).getBytes(UTF_8)))
      .build();
  }

	public static void main(String[] args) {
		SpringApplication.run(WebClientApplication.class, args);
	}

}

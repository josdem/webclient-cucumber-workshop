package com.jos.dem.webclient;

import static java.nio.charset.StandardCharsets.UTF_8;

import org.springframework.util.Base64Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WebClientApplication {

  private final static String GITHUB_API_URL = "https://api.github.com/";
  private final static String USERNAME = "josdem";
  private final static String TOKEN = "0601263c733ef575eaaa43d254e79aae6ae9ac42";

  @Bean
  public WebClient webClient() {
    return WebClient
      .builder()
        .baseUrl(GITHUB_API_URL)
        .defaultHeader("Authorization", "Basic " + Base64Utils
          .encodeToString((USERNAME + ":" + TOKEN).getBytes(UTF_8)))
      .build();
  }

	public static void main(String[] args) {
		SpringApplication.run(WebClientApplication.class, args);
	}

}

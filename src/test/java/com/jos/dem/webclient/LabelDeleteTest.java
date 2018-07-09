package com.jos.dem.webclient;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.web.reactive.function.client.ClientResponse;
import java.util.List;

import cucumber.api.java.en.Then;

public class LabelDeleteTest extends LabelIntegrationTest {

  @Then("^User deletes label$")
  public void shouldDeleteLabel() throws Exception {
    ClientResponse response = delete("spock")
      .block();

    assertEquals(NO_CONTENT, response.statusCode(), "Should delete label");
  }

}

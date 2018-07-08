package com.jos.dem.webclient;

import static org.springframework.http.HttpStatus.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.web.reactive.function.client.ClientResponse;
import com.jos.dem.webclient.model.LabelResponse;

import java.util.List;

import cucumber.api.java.en.Then;

public class LabelUpdateTest extends LabelIntegrationTest {

  private LabelResponse response;

  @Then("^User updates label$")
  public void shouldCreateLabel() throws Exception {
    ClientResponse response = update("cucumber")
      .block();

    assertEquals(OK, response.statusCode(), "Should update to spock information");
  }

}

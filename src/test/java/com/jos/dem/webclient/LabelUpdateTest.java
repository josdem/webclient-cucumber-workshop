package com.jos.dem.webclient;

import static org.springframework.http.HttpStatus.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.web.reactive.function.client.ClientResponse;
import java.util.List;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelUpdateTest extends LabelIntegrationTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @Then("^User updates label$")
  public void shouldCreateLabel() throws Exception {
    log.info("Running: User updates label");

    ClientResponse response = update("cucumber")
      .block();

    assertEquals(OK, response.statusCode(), "Should update to spock information");
  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}

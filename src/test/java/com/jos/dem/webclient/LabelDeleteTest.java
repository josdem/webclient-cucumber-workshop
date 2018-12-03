package com.jos.dem.webclient;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.springframework.web.reactive.function.client.ClientResponse;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelDeleteTest extends LabelIntegrationTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @Then("^User deletes label$")
  public void shouldDeleteLabel() throws Exception {
    log.info("Running: User deletes label");
    ClientResponse response = delete("spock")
      .block();

    assertEquals(NO_CONTENT, response.statusCode(), "Should delete label");
  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}

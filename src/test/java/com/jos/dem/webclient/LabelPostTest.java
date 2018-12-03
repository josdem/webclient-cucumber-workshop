package com.jos.dem.webclient;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.webclient.model.LabelResponse;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelPostTest extends LabelIntegrationTest {

  private LabelResponse response;
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @Then("^User creates a new label$")
  public void shouldCreateLabel() throws Exception {
    log.info("Running: User creates a new label");
    LabelResponse response = create()
      .block();

    assertAll("response",
      () -> assertEquals("cucumber", response.getName()),
      () -> assertEquals("ed14c5", response.getColor())
    );
  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}

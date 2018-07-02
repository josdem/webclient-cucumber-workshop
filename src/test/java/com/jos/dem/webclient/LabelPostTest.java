package com.jos.dem.webclient;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.webclient.model.LabelResponse;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Flux;

public class LabelPostTest extends LabelIntegrationTest {

  private LabelResponse response;

  @Then("^User creates a new label$")
  public void shouldCreateLabel() throws Exception {
    LabelResponse response = create()
      .block();

    assertAll("response",
      () -> assertEquals("cucumber", response.getName()),
      () -> assertEquals("ed14c5", response.getColor())
    );
  }

}

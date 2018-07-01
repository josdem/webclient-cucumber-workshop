package com.jos.dem.webclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.webclient.model.LabelResponse;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Flux;

public class LabelPostTest extends LabelIntegrationTest {

  private LabelResponse response;

  @Then("^User createsa new label$")
  public void shouldCreateLabel() throws Exception {
    LabelResponse response = create()
      .block();

    assertEquals("Cucumber is a very powerful testing framework written in the Ruby programming language", response.getDescription());
  }

}

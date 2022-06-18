package com.jos.dem.webclient;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.webclient.model.SSHKey;
import com.jos.dem.webclient.model.PublicEmail;

import java.util.List;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Flux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserGetTest extends UserIntegrationTest {

  private List<SSHKey> keys;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @Then("^User gets his SSH keys$")
  public void shouldGetKeys() throws Exception {
    log.info("Running: User gets his SSH keys");
    List<SSHKey> keys = getKeys()
      .collectList()
      .block();
    assertEquals(9, keys.size(),  () -> "Should be 4 keys");
  }

  @Then("^User gets his public emails$")
  public void shouldGetEmails() throws Exception {
    log.info("Running: User gets his public emails");
    List<PublicEmail> emails = getEmails()
      .collectList()
      .block();
    PublicEmail email = emails.get(0);

    assertTrue(emails.size() == 1,  () -> "Should be 1 email");
    assertAll("email",
        () -> assertEquals("joseluis.delacruz@gmail.com", email.getEmail(), "Should contains josdem's email"),
        () -> assertTrue(email.getVerified(), "Should be verified"),
        () -> assertTrue(email.getPrimary(), "Should be primary"),
        () -> assertEquals("public", email.getVisibility(), "Should be public")
    );
  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}

package com.jos.dem.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jos.dem.webclient.model.SSHKey;
import com.jos.dem.webclient.model.PublicEmail;
import com.jos.dem.webclient.service.UserService;

import reactor.core.publisher.Flux;

@ContextConfiguration(classes = WebClientApplication.class)
@WebAppConfiguration
public class UserIntegrationTest {

  @Autowired
  private UserService userService;

  Flux<SSHKey> getKeys() throws Exception {
    return userService.getKeys();
  }

  Flux<PublicEmail> getEmails() throws Exception {
    return userService.getEmails();
  }

}

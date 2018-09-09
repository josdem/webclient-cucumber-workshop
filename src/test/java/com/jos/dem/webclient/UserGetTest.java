package com.jos.dem.webclient;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.webclient.model.SSHKey;
import com.jos.dem.webclient.model.PublicEmail;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reactor.core.publisher.Flux;

public class UserGetTest extends UserIntegrationTest {

  private List<SSHKey> keys;

  @Then("^User gets his SSH keys$")
  public void shouldGetKeys() throws Exception {
    List<SSHKey> keys = getKeys()
      .collectList()
      .block();

    assertEquals(3, keys.size(),  () -> "Should be 3 keys");
    assertTrue(keys.contains(new SSHKey(20999315L, "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQC2r0APh0XJgSHK0X8tOBAWkY8eMzkHR4XG1f4xKdQS0c6dFCVZGOw7J+Eq1cqGYCXw+AalppGFXAwp6YSKBMdct15IjmZZ8i3QltBxJTfH5DLP9/QjQ9gUVfceUWwIl0Bu/G6Mxta6OL3RjSdJGFwrkIDGTdTjrn3psWv97xbrK3puoSOWmmvBIk5X5kqFnf6OT52yjmn533QHnnudvnzRZWFkz01rcDkkXRW6QgORnTvL8zFVLfQwqsiWjA2lEAjqF7iAHQ22zd49ZY5sIdQABUXyQkk3r7xxG0vAjoaTD9WilGz26BfjFOBHa5C8nKsvrTjrP4C84XZMFz/7+13C+qBfd2ZefOJGB7rPxlIFFKzMhEhBjsCjBVAPJiCtH55gXJtlctV1n4UYuAo7pLNgzhflAHSQ9iaNwbBuA3cjcinmfP9MxvE/Hn3gMtbwzoHMnH7Se6CS3TWD4nKg6/Ntg+uc7UBPzAw3X+sUSrEOSSRh0FBlXF5tutvRa+sJrdyV4MY4b5cjDnEsJI62VxskfmQDCg+10MNRTtL0TR5/S20me8pWCkGVZZAhNhPSYzL00BMW14puugvgEqRodlXaylNQs9mlEQHiqIUGStuzhqazDFQ79hMnaOoOdtikhaNbklyCWVb+kCBWhWs/DoCg3PbVK2TzAw88vtcU6nM+0w==")), () -> "Should contains josdem-asus key");
    assertTrue(keys.contains(new SSHKey(29304451L, "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDxdtqmxlLuT4F7hOYoSR3Q/kLVUkJ3lh9rcareUbNUbDWvmlxkFg/UJwHpQWWAF0prXdj4G6vz7J6paHhoO9PZXlZcgx7DwW3nUo1eVcCW0UEoxoZ1ix35sMSv1Zh3StBJ5CHbo8Z1MAZtCRCHKCZFcvDJHpI+Hgh0ik1R/LFLteegRlAOaAfLPm0PU+ALqD1Sxjp5GMG+6LRk0o8eWQGx97Zc6fXH0b4cCVn2vsAv4EEY7hPsg+x3pae4/Ua5YQYqcV16o4Ji/ZhgcyJcq372cbP/vzh9xVKGQaVpPnAMg4ECWN3FyV4Zkr6yz5DsG9+Fp8842uAKj+kYJ8KITi0R1+/NcYbwQ6Gbb7LYBgA3jsQkUpygjaRgklvb/JShnLxLpo0m+jD3WonvVrMAN9P2/WTrr/Xksl/6LMd+31WuvhKIWRYCXgUfnQ+3D9uxSSC1tpSvLJlE9XU7XLql9hIVoNMOhjR0TQ4KEJdyos4zVJZijY0UHKORg73BqsBEicIDlE7uAvidoS0BcOdFrnJ3yNr6oz9Ty3xCZPG3bvakES8ftIBjI6t+5JO5ek8bLMXJITsdTxcfDvJIW9RFYhHGoIu8C/8eQw0lKW56U9UcakgoD68QJJ6iUJSCypRcpy4rAcZbfIDM3hVzavn41junvTsTLMEnZH32Yf44Qcv23Q==")), () -> "Should contains josdem-windows key");
    assertTrue(keys.contains(new SSHKey(29337988L, "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQC3QRF8s8wH1z40z+fPZtfHAuULYp+DK+wcR/HdZYOOv4oNtGnED4su9D8agsAQaMZrva6NKXCazBmN+IxJC6f17g5kRxuKX9T5Hsu00B/KFo6a5V+7MFos3/607XvT0PJRvu3621HIw2y3FPlaDK6/BdiQ7ByQhUT5obUo+2wb2cR53lDILoMxfP2adz7n+B9h0xcasntBYlPLv7BScxIgpATX7mkaIigSQMiQePv+9ONqH5XxQWo6xVuN7NtxwwDRnpwF8PyUB8knlclNGyM/PHRka1LRZY/oSH3ZR344dSKbnAGLQrzt996/lel/+6KnwaHoZi4DBt7AIxkAKxMR3uXH/83yMjkNgPZvVOmD2Vx+gX1O7LZdUfWhXtGMaFwG6l/V7f7CaYHiZT9y0n3GFcUr/MllbJ347+9pbGo13DDGMXfIpY/7FkTDqaTqdAkmwg+Mg/Yf0xBbhXmiLfuX36c6vyKQoI+cmOPmvbU6sJRR11NsOq1AOXujZf/Upce86lVvMNgwNSKTooFvHwVNKbgqvbItTPcm8Q/sNTcQ0s4LDe3imIk/8mjSAoNpxvSPDJOXz1U4J3mi8P8v4QhjVe2+7cjy89+mcN7VxOaVnDmzAb0p4l3jkhshAuS+8oPyVu3Q0pqR66BijoMYG/f10EYcYlNl+qOSaIs9ywJGsQ==")), () -> "Should contains josdem-mac key");
  }

  @Then("^User gets his public emails$")
  public void shouldGetEmails() throws Exception {
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

}

package com.jos.dem.webclient.service;

import reactor.core.publisher.Flux;

public interface GitHubService {

  Flux<SSHKey> getKeys();

}

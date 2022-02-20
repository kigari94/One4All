package com.haw.one4all;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void requestShouldReturnHome() throws Exception {
		// Verify server can be started and gives the homepage as response, containing related Strings
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("One4All", "Home", "Filter");
	}
}

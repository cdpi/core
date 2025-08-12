package io.github.cdpi.api;

import java.io.IOException;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.github.cdpi.json.JSON;

public class ClientTest extends Assertions
	{
	@Test
	public void testHeaders() throws IOException
		{
		final var client = new Client();

		final var lang = "fr-CH";
		final var ua = "Personal Java Client/0.13.0 (+https://github.com/cdpi/core)";

		client.acceptLanguage(lang);
		client.userAgent(ua);

		//User-Agent: Mozilla/5.0 (<system-information>) <platform> (<platform-details>) <extensions>

		// (Why are you looking at HTTP headers? Go outside, find love, do some good in the world)
		// Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko)
		// Chrome/51.0.2704.103 Safari/537.36

		final var json = client.getAsString("https://httpbin.org/headers");

		final var response = JSON.GSON().fromJson(json, HTTPBinResponse.class);

		assertNotNull(response);

		assertEquals(lang, response.headers.get(HttpHeaders.ACCEPT_LANGUAGE));
		assertEquals(ua, response.headers.get(HttpHeaders.USER_AGENT));
		}
	}

package io.github.cdpi.api;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpHeaders;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.image.Image;

/**
 * <h1>Client</h1>
 * 
 * @version 0.13.0
 * @since 0.12.1
 */
public class Client
	{
	protected final Map<String, String> headers = new HashMap<String, String>();

	/**
	 * @since 0.13.0
	 */
	public Client()
		{
		super();
		}

	/**
	 * @since 0.13.0
	 */
	protected final void setLogLevel(final Level level)
		{
		Logger.getLogger("org.apache.http").setLevel((level == null) ? Level.OFF : level);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final Content get(final String url) throws IOException
		{
		return get(URI.create(Argument.notNull(url)));
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final Content get(final URI uri) throws IOException
		{
		final var request = Request.Get(Argument.notNull(uri));

		headers(request);

		return request.execute().returnContent();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final byte[] getAsBytes(final String url) throws IOException
		{
		return get(url).asBytes();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final byte[] getAsBytes(final URI uri) throws IOException
		{
		return get(uri).asBytes();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final Document getAsDocument(final String url) throws IOException
		{
		return Jsoup.parse(getAsString(url));
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final Document getAsDocument(final URI uri) throws IOException
		{
		return Jsoup.parse(getAsString(uri));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final BufferedImage getAsImage(final String url) throws IOException
		{
		return Image.read(getAsBytes(url));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final BufferedImage getAsImage(final URI uri) throws IOException
		{
		return Image.read(getAsBytes(uri));
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final String getAsString(final String url) throws IOException
		{
		return get(url).asString();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.13.0
	 */
	protected final String getAsString(final URI uri) throws IOException
		{
		return get(uri).asString();
		}

	/**
	 * @since 0.13.0
	 */
	protected final Client acceptLanguage(final String acceptLanguage)
		{
		headers.put(HttpHeaders.ACCEPT_LANGUAGE, acceptLanguage);

		return this;
		}

	/**
	 * @since 0.13.0
	 */
	protected final Client allow(final String allow)
		{
		headers.put(HttpHeaders.ALLOW, allow);

		return this;
		}

	/**
	 * @since 0.13.0
	 */
	protected final Client authorization(final String authorization)
		{
		headers.put(HttpHeaders.AUTHORIZATION, authorization);

		return this;
		}

	/**
	 * @since 0.13.0
	 */
	protected final Client contentLength(final String contentLength)
		{
		headers.put(HttpHeaders.CONTENT_LENGTH, contentLength);

		return this;
		}

	/**
	 * @since 0.13.0
	 */
	protected final Client userAgent(final String userAgent)
		{
		headers.put(HttpHeaders.USER_AGENT, userAgent);

		return this;
		}

	/**
	 * @since 0.13.0
	 */
	protected final void headers(final Request request)
		{
		Argument.notNull(request);

		headers.entrySet().forEach(header ->
			{
			request.addHeader(header.getKey(), header.getValue());
			});
		}
	}

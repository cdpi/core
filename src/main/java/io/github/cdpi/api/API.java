package io.github.cdpi.api;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.image.Image;

/**
 * <h1>API</h1>
 * 
 * @version 0.12.1
 * @since 0.1.0
 */
public class API
	{
	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.7.0
	 */
	public API(final Level log)
		{
		super();

		Logger.getLogger("org.apache.http").setLevel(Argument.notNull(log));
		}

	/**
	 * @since 0.7.0
	 */
	public API()
		{
		this(Level.OFF);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final byte[] getAsBytes(final String url) throws IOException
		{
		return get(url).asBytes();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final byte[] getAsBytes(final URI uri) throws IOException
		{
		return get(uri).asBytes();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	public final Document getAsDocument(final String url) throws IOException
		{
		return Jsoup.parse(getAsString(url));
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	public final Document getAsDocument(final URI uri) throws IOException
		{
		return Jsoup.parse(getAsString(uri));
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	public final Document getAsDocument(final String url, final List<Header> headers) throws IOException
		{
		return Jsoup.parse(get(url, headers).asString());
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.3.0
	 */
	public final BufferedImage getAsImage(final String url) throws IOException
		{
		return Image.read(getAsBytes(url));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.3.0
	 */
	public final BufferedImage getAsImage(final URI uri) throws IOException
		{
		return Image.read(getAsBytes(uri));
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final String getAsString(final String url) throws IOException
		{
		return get(url).asString();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final String getAsString(final URI uri) throws IOException
		{
		return get(uri).asString();
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.12.1
	 */
	public final Header getAcceptLanguage(final String language)
		{
		return new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, Argument.notNull(language));
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	protected final Content get(final String url) throws IOException
		{
		return Request.Get(Argument.notNull(url)).execute().returnContent();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	protected final Content get(final URI uri) throws IOException
		{
		return Request.Get(Argument.notNull(uri)).execute().returnContent();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	protected final Content get(final String url, final List<Header> headers) throws IOException
		{
		var request = Request.Get(Argument.notNull(url));

		if (headers != null)
			{
			headers.forEach(header ->
				{
				if (header != null)
					{
					request.addHeader(header);
					}
				});
			}

		return request.execute().returnContent();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	protected final Content get(final URI uri, final List<Header> headers) throws IOException
		{
		var request = Request.Get(Argument.notNull(uri));

		if (headers != null)
			{
			headers.forEach(header ->
				{
				if (header != null)
					{
					request.addHeader(header);
					}
				});
			}

		return request.execute().returnContent();
		}
	}

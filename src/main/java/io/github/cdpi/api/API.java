package io.github.cdpi.api;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import org.apache.http.client.fluent.Request;
import io.github.cdpi.image.Image;

/**
 * <h1>API</h1>
 * 
 * @version 0.3.0
 * @since 0.1.0
 */
public class API
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public static final byte[] getAsBytes(final String url) throws IOException
		{
		return Request.Get(url).execute().returnContent().asBytes();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public static final byte[] getAsBytes(final URI uri) throws IOException
		{
		return Request.Get(uri).execute().returnContent().asBytes();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.3.0
	 */
	public static final BufferedImage getAsImage(final String url) throws IOException
		{
		return Image.from(getAsBytes(url));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.3.0
	 */
	public static final BufferedImage getAsImage(final URI uri) throws IOException
		{
		return Image.from(getAsBytes(uri));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public static final String getAsString(final String url) throws IOException
		{
		return Request.Get(url).execute().returnContent().asString();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public static final String getAsString(final URI uri) throws IOException
		{
		return Request.Get(uri).execute().returnContent().asString();
		}
	}

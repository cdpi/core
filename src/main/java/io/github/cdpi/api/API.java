package io.github.cdpi.api;

import java.io.IOException;
import java.net.URI;
import org.apache.http.client.fluent.Request;

/**
 * <h1>API</h1>
 * 
 * @version 0.1.0
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

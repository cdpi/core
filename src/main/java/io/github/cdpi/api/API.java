package io.github.cdpi.api;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.fluent.Request;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.image.Image;

/**
 * <h1>API</h1>
 * 
 * @version 0.7.0
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

		// Désactive les logs d'Apache HttpClient
		// Logger.getLogger("org.apache.http").setLevel(Level.OFF);

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
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final byte[] getAsBytes(final String url) throws IOException
		{
		return Request.Get(url).execute().returnContent().asBytes();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final byte[] getAsBytes(final URI uri) throws IOException
		{
		return Request.Get(uri).execute().returnContent().asBytes();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.3.0
	 */
	public final BufferedImage getAsImage(final String url) throws IOException
		{
		return Image.from(getAsBytes(url));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.3.0
	 */
	public final BufferedImage getAsImage(final URI uri) throws IOException
		{
		return Image.from(getAsBytes(uri));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final String getAsString(final String url) throws IOException
		{
		return Request.Get(url).execute().returnContent().asString();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final String getAsString(final URI uri) throws IOException
		{
		return Request.Get(uri).execute().returnContent().asString();
		}
	}

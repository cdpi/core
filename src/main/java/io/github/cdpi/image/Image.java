package io.github.cdpi.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;

/**
 * <h1>Image</h1>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class Image
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public static final BufferedImage from(final byte[] bytes) throws IOException
		{
		try (final var input = new ByteArrayInputStream(bytes))
			{
			return ImageIO.read(input);
			}
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public static final BufferedImage from(final ByteBuffer buffer) throws IOException
		{
		/*
		if (buffer.hasArray())
			{
			return from(buffer.array());
			}
		*/

		return from(buffer.array());
		}
	}

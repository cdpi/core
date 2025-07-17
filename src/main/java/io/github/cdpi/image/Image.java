package io.github.cdpi.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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

	/*
	public static final BufferedImage from(final ByteBuffer buffer) throws IOException
		{
		buffer.hasArray();
		buffer.array();
		from(buffer.array());
		}
	*/
	}

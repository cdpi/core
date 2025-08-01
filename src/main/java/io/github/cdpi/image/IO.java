package io.github.cdpi.image;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import image.exceptions.UnsupportedImageException;

/**
 * <h1>IO</h1>
 * 
 * Wrapper pour ImageIO car read() peut retourner null et write() peut retourner false...
 * 
 * @version 0.10.0
 * @since 0.10.0
 */
public class IO
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public static final BufferedImage read(final File file) throws IOException
		{
		return imageNotNull(ImageIO.read(file), UnsupportedImageException.forInvalidFile(file.toString()));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public static final BufferedImage read(final InputStream input) throws IOException
		{
		return imageNotNull(ImageIO.read(input), new UnsupportedImageException());
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public static final BufferedImage read(final ByteBuffer buffer) throws IOException
		{
		try (final var input = new ByteArrayInputStream(buffer.array()))
			{
			return read(input);
			}
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public static final BufferedImage read(final byte[] bytes) throws IOException
		{
		try (final var input = new ByteArrayInputStream(bytes))
			{
			return read(input);
			}
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public static final void write(final RenderedImage image, final String format, final Path path) throws IOException
		{
		try (final var output = new FileImageOutputStream(path.toFile()))
			{
			write(image, format, output);
			}
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public static final void write(final RenderedImage image, final String format, final ImageOutputStream output) throws IOException
		{
		if (!ImageIO.write(image, format, output))
			{
			throw new UnsupportedImageException();
			}
		}

	/**
	 * @since 0.10.0
	 */
	protected static final BufferedImage imageNotNull(final BufferedImage image, final UnsupportedImageException exception)
		{
		if (image == null)
			{
			throw exception;
			}

		return image;
		}
	}

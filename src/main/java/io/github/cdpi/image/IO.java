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
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.image.exceptions.UnsupportedImageException;

/**
 * <h1>IO</h1>
 * 
 * Wrapper pour ImageIO car read() peut retourner null et write() peut retourner false...
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public class IO
	{
	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * @throws UnsupportedImageException
	 * 
	 * @since 0.11.0
	 */
	public static final BufferedImage read(final File file) throws IOException
		{
		Argument.notNull(file);

		return imageNotNull(ImageIO.read(file), UnsupportedImageException.forInvalidFile(file.toString()));
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * @throws UnsupportedImageException
	 * 
	 * @since 0.11.0
	 */
	public static final BufferedImage read(final InputStream input) throws IOException
		{
		Argument.notNull(input);

		return imageNotNull(ImageIO.read(input), new UnsupportedImageException());
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * @throws UnsupportedImageException
	 * 
	 * @since 0.11.0
	 */
	public static final BufferedImage read(final byte[] bytes) throws IOException
		{
		Argument.notNull(bytes);

		try (final var input = new ByteArrayInputStream(bytes))
			{
			return read(input);
			}
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * @throws UnsupportedImageException
	 * 
	 * @since 0.11.0
	 */
	public static final BufferedImage read(final ByteBuffer buffer) throws IOException
		{
		return read(Argument.notNull(buffer).array());
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * @throws UnsupportedImageException
	 * 
	 * @since 0.11.0
	 */
	public static final void write(final RenderedImage image, final Format format, final Path path) throws IOException
		{
		Argument.notNull(path);

		try (final var output = new FileImageOutputStream(path.toFile()))
			{
			write(image, format, output);
			}
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * @throws UnsupportedImageException
	 * 
	 * @since 0.11.0
	 */
	public static final void write(final RenderedImage image, final Format format, final ImageOutputStream output) throws IOException
		{
		Argument.notNull(image);
		Argument.notNull(format);
		Argument.notNull(output);

		if (!ImageIO.write(image, format.name(), output))
			{
			throw new UnsupportedImageException();
			}
		}

	/**
	 * @since 0.11.0
	 */
	private static final BufferedImage imageNotNull(final BufferedImage image, final UnsupportedImageException exception)
		{
		if (image == null)
			{
			throw exception;
			}

		return image;
		}
	}

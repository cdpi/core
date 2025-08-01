package io.github.cdpi.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.NotImplementedException;
import io.github.cdpi.Argument;
import io.github.cdpi.annotations.WorkInProgress;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.image.filter.AbstractFilter;

/**
 * <h1>Image</h1>
 * 
 * @version 0.11.0
 * @since 0.1.0
 */
public class Image extends AbstractImage<Image>
	{
	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.11.0
	 */
	public Image(final BufferedImage image)
		{
		super(image);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException 
	 * @throws UnsupportedOperationException
	 * 
	 * @since 0.1.0
	 */
	public Image(final File file) throws IOException
		{
		this(read(file));
		}

	/**
	 * @throws IOException 
	 * @throws UnsupportedOperationException
	 * 
	 * @since 0.1.0
	 */
	public Image(final Path path) throws IOException
		{
		// TODO: NotNull
		this(path.toFile());
		}

	/**
	 * @throws IOException 
	 * @throws UnsupportedOperationException
	 * 
	 * @since 0.1.0
	 */
	public Image(final String path) throws IOException
		{
		this(new File(path));
		}

	/**
	 * @since 0.11.0
	 */
	@WorkInProgress
	public Color getAverageColor()
		{
		//new AverageColor().apply(this);
		//walk(image, new AverageColor.AverageColorConsumer());

		throw new NotImplementedException("Image.getAverageColor()");
		}

	/**
	 * @since 0.11.0
	 */
	@Override
	public final <U extends AbstractFilter<R>, R> R filter(final U filter)
		{
		return Argument.notNull(filter).apply(getThis());
		}

	/*
	public static final Color getDominantColor(final BufferedImage image)
		{
		return getDominantColor(Pixel.count(image));
		}

	private static final Color getDominantColor(final Map<Integer, Integer> colors)
		{
		final var color = colors.entrySet().stream()
			.max((left, right) -> left.getValue() > right.getValue() ? 1 : -1)
			.get()
			.getKey();

		return new Color(color);
		}
	*/

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

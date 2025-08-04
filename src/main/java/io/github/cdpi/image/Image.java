package io.github.cdpi.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.image.filter.AbstractFilter;
import io.github.cdpi.image.filter.AverageColor;

/**
 * <h1>Image</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
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

	/*
	public Image(final File file) throws IOException
		{
		this(read(file));
		}
	*/

	/*
	public Image(final Path path) throws IOException
		{
		// TODO: NotNull
		this(path.toFile());
		}
	*/

	/*
	public Image(final String path) throws IOException
		{
		this(new File(path));
		}
	*/

	/**
	 * @since 0.11.0
	 */
	public Color getAverageColor()
		{
		// Les 2 OK
		//new AverageColor().apply(this);
		//AverageColor.getAverageColor(this.image);

		return AverageColor.getAverageColor(image);
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

	@Deprecated
	public static final BufferedImage from(final byte[] bytes) throws IOException
		{
		throw new UnsupportedOperationException();
		}

	@Deprecated
	public static final BufferedImage from(final ByteBuffer buffer) throws IOException
		{
		throw new UnsupportedOperationException();
		}
	}

package io.github.cdpi.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.apache.commons.lang3.NotImplementedException;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>AbstractImage</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public abstract class AbstractImage<T extends AbstractImage<T>> extends IO implements ImageInterface<T>
	{
	protected final BufferedImage image;

	@SuppressWarnings("unused")
	private AbstractImage()
		{
		throw new UnsupportedOperationException();
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.11.0
	 */
	protected AbstractImage(final BufferedImage image)
		{
		super();

		this.image = Argument.notNull(image);
		}

	/**
	 * @since 0.11.0
	 */
	@Override
	public final BufferedImage getBufferedImage()
		{
		return image;
		}

	/**
	 * @since 0.11.0
	 */
	@Override
	public T crop(int x, int y, int width, int height)
		{
		//return new Image(crop(image, x, y, width, height));
		throw new NotImplementedException("AbstractImage.crop(int, int, int, int)");
		}

	/**
	 * @since 0.11.0
	 */
	@Override
	public final void fill(final Color color)
		{
		fill(image, color);
		}

	/**
	 * @since 0.11.0
	 */
	/*
	@Override
	public final <R> R filter(final FilterInterface<R> filter)
		{
		return filter.apply(this);
		}
	*/

	/*
	@Override
	public final void write(final Path path, final String format) throws IOException
		{
		write(image, format, path);
		}
	*/

	/**
	 * @since 0.11.0
	 */
	public static final BufferedImage crop(final BufferedImage image, int x, int y, int width, int height)
		{
		if (x < 0) x = 0;
		if (y < 0) y = 0;
		if (x > image.getWidth()) x = image.getWidth();
		if (y > image.getHeight()) y = image.getHeight();
		if (x + width > image.getWidth()) width = image.getWidth() - x;
		if (y + height > image.getHeight()) height = image.getHeight() - y;

		return image.getSubimage(x, y, width, height);
		}

	/**
	 * @since 0.11.0
	 */
	public static final void draw(final BufferedImage source, final BufferedImage destination)
		{
		final var graphics = destination.getGraphics();

		try
			{
			graphics.drawImage(source, 0, 0, null);
			}
		finally
			{
			graphics.dispose();
			}
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.11.0
	 */
	public static final void fill(final BufferedImage image, final Color color)
		{
		Argument.notNull(image);
		Argument.notNull(color);

		final var width = image.getWidth();
		final var height = image.getHeight();
		final var rgb = color.getRGB();

		// TODO: BiIntConsumer (x,y)
		/*
		walk(image, (IntConsumer) pixel ->
			{
			});
		*/

		for (var x = 0; x < width; x++)
			{
			for (var y = 0; y < height; y++)
				{
				image.setRGB(x, y, rgb);
				}
			}
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.11.0
	 */
	public static final void walk(final BufferedImage image, final IntConsumer consumer)
		{
		Argument.notNull(image);
		Argument.notNull(consumer);

		final var width = image.getWidth();
		final var height = image.getHeight();

		for (var x = 0; x < width; x++)
			{
			for (var y = 0; y < height; y++)
				{
				consumer.accept(image.getRGB(x, y));
				}
			}
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.11.0
	 */
	public static final void walk(final BufferedImage image, final Consumer<Color> consumer)
		{
		Argument.notNull(consumer);

		walk(image, (IntConsumer) pixel ->
			{
			consumer.accept(new Color(pixel));
			});
		}
	}

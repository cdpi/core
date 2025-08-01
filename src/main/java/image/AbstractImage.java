package image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.apache.commons.lang3.NotImplementedException;
//import image.filter.FilterInterface;
import io.github.cdpi.image.IO;
import io.github.cdpi.image.ImageInterface;

/**
 * <h2>AbstractImage</h2>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class AbstractImage<T extends AbstractImage<T>> extends IO implements ImageInterface<T>
	{
	protected final BufferedImage image;

	/**
	 * @since 0.1.0
	 */
	protected AbstractImage(final BufferedImage image)
		{
		super();

		this.image = image;
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public final BufferedImage getBufferedImage()
		{
		return image;
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public T crop(int x, int y, int width, int height)
		{
		//return new Image(crop(image, x, y, width, height));
		throw new NotImplementedException("AbstractImage.crop(int, int, int, int)");
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public final void fill(final Color color)
		{
		fill(image, color);
		}

	/**
	 * @since 0.1.0
	 */
	/*
	@Override
	public final <R> R filter(final FilterInterface<R> filter)
		{
		return filter.apply(this);
		}
	*/

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	@Override
	public final void write(final Path path, final String format) throws IOException
		{
		write(image, format, path);
		}

	/**
	 * @since 0.1.0
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
	 * @since 0.1.0
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
	 * @since 0.1.0
	 */
	public static final void fill(final BufferedImage image, final Color color)
		{
		final var rgb = color.getRGB();
		final var width = image.getWidth();
		final var height = image.getHeight();

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
	 * @since 0.1.0
	 */
	public static final void walk(final BufferedImage image, final IntConsumer consumer)
		{
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
	 * @since 0.1.0
	 */
	public static final void walk(final BufferedImage image, final Consumer<Color> consumer)
		{
		walk(image, (IntConsumer) pixel ->
			{
			consumer.accept(new Color(pixel));
			});
		}
	}

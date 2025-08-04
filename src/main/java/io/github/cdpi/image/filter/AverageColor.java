package io.github.cdpi.image.filter;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Point;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.image.IImage;
import io.github.cdpi.image.Image;

/**
 * <h1>Average</h1>
 * 
 * https://stackoverflow.com/a/28162725
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public class AverageColor extends AbstractFilter<Color>
	{
	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.11.0
	 */
	@Override
	public final Color apply(final IImage<?> image)
		{
		return getAverageColor(Argument.notNull(image).getBufferedImage());
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.11.0
	 */
	public static final Color getAverageColor(final BufferedImage image)
		{
		Argument.notNull(image);

		final var consumer = new AverageColorConsumer();

		Image.walk(image, consumer);

		return consumer.getAverageColor();
		}

	/**
	 * <h1>AverageColor.AverageColorConsumer</h1>
	 * 
	 * @version 0.11.0
	 * @since 0.11.0
	 */
	public static class AverageColorConsumer implements IImage.IColorConsumer
		{
		private long count = 0;
		private long red = 0;
		private long green = 0;
		private long blue = 0;

		/**
		 * @since 0.11.0
		 */
		@Override
		public void accept(final Point point, final Color color)
			{
			count++;

			red += color.getRed();
			green += color.getGreen();
			blue += color.getBlue();
			}

		/**
		 * @since 0.11.0
		 */
		public Color getAverageColor()
			{
			return new Color((int) (red / count), (int) (green / count), (int) (blue / count));
			}
		}
	}

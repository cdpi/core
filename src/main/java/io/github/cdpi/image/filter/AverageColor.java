package io.github.cdpi.image.filter;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.function.Consumer;

import org.apache.commons.lang3.NotImplementedException;

import image.Image;
import io.github.cdpi.image.ImageInterface;

/**
 * <h1>Average</h1>
 * 
 * https://stackoverflow.com/a/28162725
 * 
 * @version 0.10.0
 * @since 0.10.0
 */
public class AverageColor extends AbstractFilter<Color>
	{
	/**
	 * @since 0.10.0
	 */
	@Override
	public final Color apply(final ImageInterface<?> image)
		{
		return getAverageColor(image.getBufferedImage());
		}

	/**
	 * @since 0.10.0
	 */
	public static final Color getAverageColor(final BufferedImage image)
		{
		final var consumer = new AverageColorConsumer();

		//Image.walk(image, consumer);
		//return consumer.getAverageColor();
		throw new NotImplementedException();
		}

	/**
	 * <h1>AverageColor.AverageColorConsumer</h1>
	 * 
	 * @version 0.10.0
	 * @since 0.10.0
	 */
	public static class AverageColorConsumer implements Consumer<Color>
		{
		private long count = 0;
		private long red = 0;
		private long green = 0;
		private long blue = 0;

		/**
		 * @since 0.10.0
		 */
		@Override
		public void accept(final Color color)
			{
			count++;

			red += color.getRed();
			green += color.getGreen();
			blue += color.getBlue();
			}

		/**
		 * @since 0.10.0
		 */
		public Color getAverageColor()
			{
			return new Color((int) (red / count), (int) (green / count), (int) (blue / count));
			}
		}
	}

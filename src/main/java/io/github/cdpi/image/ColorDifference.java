package io.github.cdpi.image;

import java.awt.Color;

/**
 * <h1>ColorDifference</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public class ColorDifference
	{
	private static final double MAXIMUM = Math.sqrt(255 * 255 + 255 * 255 + 255 * 255);

	/**
	 * @since 0.11.0
	 */
	public static final double getDifference(final Color left, final Color right)
		{
		final var red = left.getRed() - right.getRed();
		final var green = left.getGreen() - right.getGreen();
		final var blue = left.getBlue() - right.getBlue();

		return Math.sqrt(red * red + green * green + blue * blue);
		}

	/**
	 * @since 0.11.0
	 */
	public static final double difference(final Color left, final Color right)
		{
		return getDifference(left, right) / MAXIMUM;
		}
	}

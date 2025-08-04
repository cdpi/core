package io.github.cdpi.image;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.function.BiConsumer;
import io.github.cdpi.image.filter.AbstractFilter;

/**
 * <h1>IImage</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public interface IImage<T extends IImage<T>>
	{
	/**
	 * @since 0.11.0
	 */
	public BufferedImage getBufferedImage();

	/**
	 * @since 0.11.0
	 */
	public BufferedImage crop(int x, int y, int width, int height);

	/**
	 * @since 0.11.0
	 */
	public void fill(Color color);

	/**
	 * @since 0.11.0
	 */
	public <U extends AbstractFilter<R>, R> R filter(U filter);

	/**
	 * @since 0.11.0
	 */
	@SuppressWarnings("unchecked")
	public default T getThis()
		{
		return (T) this;
		}

	/**
	 * <h1>IImage.IPixelConsumer</h1>
	 * 
	 * @version 0.11.0
	 * @since 0.11.0
	 */
	@FunctionalInterface
	public static interface IPixelConsumer
		{
		/**
		 * @since 0.11.0
		 */
		public void accept(int x, int y, int pixel);
		}

	/**
	 * <h1>IImage.IColorConsumer</h1>
	 * 
	 * @version 0.11.0
	 * @since 0.11.0
	 */
	@FunctionalInterface
	public static interface IColorConsumer extends BiConsumer<Point, Color>
		{
		}
	}

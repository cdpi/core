package io.github.cdpi.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import io.github.cdpi.image.filter.AbstractFilter;

/**
 * <h1>ImageInterface</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public interface ImageInterface<T extends ImageInterface<T>>
	{
	/**
	 * @since 0.11.0
	 */
	public BufferedImage getBufferedImage();

	/**
	 * @since 0.11.0
	 */
	public T crop(int x, int y, int width, int height);

	/**
	 * @since 0.11.0
	 */
	public void fill(Color color);

	/**
	 * @since 0.11.0
	 */
	public <U extends AbstractFilter<R>, R> R filter(U filter);

	//public void write(Path path, String format) throws IOException;

	/**
	 * @since 0.11.0
	 */
	@SuppressWarnings("unchecked")
	public default T getThis()
		{
		return (T) this;
		}
	}

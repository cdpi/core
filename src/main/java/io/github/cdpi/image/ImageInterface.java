package io.github.cdpi.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import image.exceptions.UnsupportedImageException;
import io.github.cdpi.image.filter.FilterInterface;

/**
 * <h1>ImageInterface</h1>
 * 
 * @version 0.10.0
 * @since 0.10.0
 */
public interface ImageInterface<T extends ImageInterface<T>>
	{
	/**
	 * @since 0.10.0
	 */
	public BufferedImage getBufferedImage();

	/**
	 * @since 0.10.0
	 */
	public T crop(int x, int y, int width, int height);

	/**
	 * @since 0.10.0
	 */
	public void fill(Color color);

	/**
	 * @since 0.10.0
	 */
	public <R> R filter(FilterInterface<R> filter);

	/**
	 * @throws IOException
	 * @throws UnsupportedImageException
	 * 
	 * @since 0.10.0
	 */
	public void write(Path path, String format) throws IOException;

	/**
	 * @since 0.10.0
	 */
	@SuppressWarnings("unchecked")
	public default T getThis()
		{
		return (T) this;
		}
	}

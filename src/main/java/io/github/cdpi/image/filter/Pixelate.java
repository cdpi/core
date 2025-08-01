package io.github.cdpi.image.filter;

import java.awt.image.BufferedImage;

import org.apache.commons.lang3.NotImplementedException;

import image.ColorDifference;
import image.Image;
import io.github.cdpi.image.ImageInterface;
import java.awt.Color;

/**
 * <h1>Pixelate</h1>
 * 
 * @version 0.10.0
 * @since 0.10.0
 */
// https://stackoverflow.com/questions/15777821/how-can-i-pixelate-a-jpg-with-java
// mais avec avg à la place de dominant color
// https://stackoverflow.com/a/28162725
// et une version ligne de moi ;-)
public class Pixelate extends AbstractFilter<BufferedImage>
	{
	/**
	 * Pixelate.Mode
	 * 
	 * @since 0.10.0
	 */
	public static enum Mode
		{
		PIXEL,
		LINE
		}

	private static final int DEFAULT_PIXEL_SIZE = 20;
	private static final double DEFAULT_COLOR_DIFFERENCE = 0.1D;

	private final Mode mode;
	private final int pixelSize;
	private final double colorDifference;

	/**
	 * @since 0.10.0
	 */
	public Pixelate(final Mode mode, final int pixelSize, final double colorDifference)
		{
		super();

		this.mode = mode;
		this.pixelSize = pixelSize;
		this.colorDifference = colorDifference;
		}

	/**
	 * @since 0.10.0
	 */
	public Pixelate(final int pixelSize)
		{
		this(Mode.PIXEL, pixelSize, DEFAULT_COLOR_DIFFERENCE);
		}

	/**
	 * @since 0.10.0
	 */
	public Pixelate(final Mode mode)
		{
		this(mode, DEFAULT_PIXEL_SIZE, DEFAULT_COLOR_DIFFERENCE);
		}

	/**
	 * @since 0.10.0
	 */
	@Override
	public final BufferedImage apply(final ImageInterface<?> image)
		{
		switch (mode)
			{
			case PIXEL:
				throw new UnsupportedOperationException("PIXEL");
			case LINE:
				return line(image.getBufferedImage());
			default:
				throw new UnsupportedOperationException("INVALID MODE");
			}
		}

	@SuppressWarnings("unused")
	private final void pixel()
		{
		}

	/**
	 * @since 0.10.0
	 */
	private final BufferedImage line(final BufferedImage image)
		{
		/*
		final var width = image.getWidth();
		final var height = image.getHeight();

		final var pixelsH = width / pixelSize;
		final var pixelsV = height / pixelSize;

		final var newImage = new BufferedImage(pixelsH * pixelSize, pixelsV * pixelSize, image.getType());

		Image.draw(image, newImage);

		Color lastColor = null;

		for (var y = 0; y < pixelsV; y++)
		//for (var x = 0; x < pixelsH; x++)
			{
			//for (var y = 0; y < pixelsV; y++)
			for (var x = 0; x < pixelsH; x++)
				{
				final var cropped = Image.crop(newImage, x * pixelSize, y * pixelSize, pixelSize, pixelSize);

				var avgColor = AverageColor.getAverageColor(cropped);

				if (lastColor == null)
					{
					lastColor = avgColor;
					}

				final var difference = ColorDifference.difference(lastColor, avgColor);

				if (difference > colorDifference)
					{
					lastColor = avgColor;
					}

				Image.fill(cropped, lastColor);
				}
			}

		return newImage;
		*/
		throw new NotImplementedException();
		}
	}

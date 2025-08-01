package image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.lang3.NotImplementedException;
//import image.filter.AverageColor;

/**
 * <h2>Image</h2>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class Image //extends AbstractImage<Image>
	{
	/**
	 * @since 0.1.0
	 */
	public Image(final BufferedImage image)
		{
		//super(image);
		}

	/**
	 * @throws IOException 
	 * @throws UnsupportedOperationException
	 * 
	 * @since 0.1.0
	 */
	public Image(final File file) throws IOException
		{
		//this(read(file));
		}

	/**
	 * @throws IOException 
	 * @throws UnsupportedOperationException
	 * 
	 * @since 0.1.0
	 */
	public Image(final Path path) throws IOException
		{
		this(path.toFile());
		}

	/**
	 * @throws IOException 
	 * @throws UnsupportedOperationException
	 * 
	 * @since 0.1.0
	 */
	public Image(final String path) throws IOException
		{
		this(new File(path));
		}

	/**
	 * @since 0.1.0
	 */
	public Color getAverageColor()
		{
		//new AverageColor().apply(this);
		//walk(image, new AverageColor.AverageColorConsumer());

		throw new NotImplementedException("Image.getAverageColor()");
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
	}

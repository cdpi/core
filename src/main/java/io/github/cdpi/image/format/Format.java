package io.github.cdpi.image.format;

import java.awt.image.RenderedImage;
import java.nio.file.Path;
import org.apache.commons.lang3.NotImplementedException;
import io.github.cdpi.annotations.WorkInProgress;

/**
 * <h1>Format</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public enum Format
	{
	JPEG,
	PNG,
	TIFF;

	@WorkInProgress
	public static final void save(final Path path, final RenderedImage image)
		{
		throw new NotImplementedException();
		}
	}

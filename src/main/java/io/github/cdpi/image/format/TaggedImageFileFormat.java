package io.github.cdpi.image.format;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.lang3.NotImplementedException;

/**
 * <h1>TaggedImageFileFormat</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public class TaggedImageFileFormat
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.11.0
	 */
	public static final void save(final Path path, final RenderedImage image) throws IOException
		{
		//IO.write(image, "TIFF", path);
		throw new NotImplementedException();
		}
	}

/*
CaractéristiquesExtensions	
.tif, .tiff
Type MIME	
image/tiff
PUID	
fmt/353
Signatures	
4D 4D 00 2A (hexa)
49 49 2A 00 (hexa)
Version initiale	
1986
Site web	
(en) www.adobe.io/open/standards/TIFF.html
*/

package image.format;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.nio.file.Path;

import io.github.cdpi.image.IO;

/**
 * <h2>TaggedImageFileFormat</h2>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class TaggedImageFileFormat
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public static final void save(final Path path, final RenderedImage image) throws IOException
		{
		IO.write(image, "TIFF", path);
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

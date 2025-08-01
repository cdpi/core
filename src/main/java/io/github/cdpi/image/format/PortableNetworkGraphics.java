package io.github.cdpi.image.format;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.lang3.NotImplementedException;

/**
 * <h1>PortableNetworkGraphics</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public class PortableNetworkGraphics
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.11.0
	 */
	public static final void save(final Path path, final RenderedImage image) throws IOException
		{
		//IO.write(image, "PNG", path);
		throw new NotImplementedException();
		}
	}

/*
CaractéristiquesExtension	
.png
Type MIME	
image/png
Signature	
89 50 4E 47 0D 0A 1A 0A (hexa)
Développé par	
W3C
Version initiale	
1er octobre 1996
Type de format	
format d’image matriciel sans perte
Basé sur	
Deflate
Norme	
ISO 15948, W3C, IETF RFC 2083
Spécification	
Format ouvert
Sites web	
(en) www.libpng.org/pub/png
(en) png-mng.sourceforge.net/pub/png
*/

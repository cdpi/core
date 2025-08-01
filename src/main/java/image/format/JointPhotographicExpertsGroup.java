package image.format;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.nio.file.Path;

import io.github.cdpi.image.IO;

/**
 * <h2>JointPhotographicExpertsGroup</h2>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class JointPhotographicExpertsGroup
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public static final void save(final Path path, final RenderedImage image) throws IOException
		{
		IO.write(image, "JPEG", path);
		}
	}

/*
CaractéristiquesExtensions	
.jpg, .jpeg, .JPG, .JPEG, .jpe, .JPE
Type de format	
image matricielle
Site web	
(en) jpeg.org/jpeg
*/

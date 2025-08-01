package io.github.cdpi.image.format;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.lang3.NotImplementedException;

/**
 * <h1>JointPhotographicExpertsGroup</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public class JointPhotographicExpertsGroup
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.11.0
	 */
	public static final void save(final Path path, final RenderedImage image) throws IOException
		{
		//IO.write(image, "JPEG", path);
		throw new NotImplementedException();
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

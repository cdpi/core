package image.exceptions;

import org.apache.commons.lang3.exception.UncheckedException;

/**
 * <h2>ImageException</h2>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class ImageException extends UncheckedException
	{
	/**
	 * @since 0.1.0
	 */
	public ImageException(final Throwable cause)
		{
		super(cause);
		}
	}

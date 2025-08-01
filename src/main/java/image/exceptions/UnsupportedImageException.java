package image.exceptions;

/**
 * <h2>UnsupportedImageException</h2>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class UnsupportedImageException extends ImageException
	{
	private static final String INVALID_FORMAT = "Invalid format: %s";

	/**
	 * @since 0.1.0
	 */
	public UnsupportedImageException()
		{
		super(new UnsupportedOperationException());
		}

	/**
	 * @since 0.1.0
	 */
	public UnsupportedImageException(final Throwable cause)
		{
		super(cause);
		}

	/**
	 * @since 0.1.0
	 */
	public static UnsupportedImageException forInvalidFormat(final String format)
		{
		return new UnsupportedImageException(new IllegalArgumentException(INVALID_FORMAT.formatted(format)));
		}

	/**
	 * @since 0.1.0
	 */
	public static UnsupportedImageException forInvalidFile(final String file)
		{
		return new UnsupportedImageException(new IllegalArgumentException(file));
		}
	}

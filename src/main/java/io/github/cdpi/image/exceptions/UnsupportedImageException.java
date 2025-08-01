package io.github.cdpi.image.exceptions;

import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>UnsupportedImageException</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public final class UnsupportedImageException extends ImageException
	{
	private static final String INVALID_FORMAT = "Invalid format: %s";

	/**
	 * @since 0.11.0
	 */
	public UnsupportedImageException()
		{
		super(new UnsupportedOperationException());
		}

	/**
	 * @since 0.11.0
	 */
	public UnsupportedImageException(final Throwable cause)
		{
		super(cause);
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.11.0
	 */
	public static UnsupportedImageException forInvalidFormat(final String format)
		{
		return new UnsupportedImageException(new IllegalArgumentException(INVALID_FORMAT.formatted(Argument.notNull(format))));
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.11.0
	 */
	public static UnsupportedImageException forInvalidFile(final String file)
		{
		return new UnsupportedImageException(new IllegalArgumentException(Argument.notNull(file)));
		}
	}

package io.github.cdpi.exceptions;

/**
 * <h1>NullArgumentException</h1>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class NullArgumentException extends IllegalArgumentException
	{
	/**
	 * @since 0.1.0
	 */
	public NullArgumentException()
		{
		super();
		}

	/**
	 * @since 0.1.0
	 */
	public NullArgumentException(final String message)
		{
		super(message);
		}
	}

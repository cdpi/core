package io.github.cdpi.exceptions;

/**
 * <h1>UncheckedException</h1>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
@Deprecated // Pas sous cette forme...
public class UncheckedException extends RuntimeException
	{
	/**
	 * @since 0.1.0
	 */
	public UncheckedException()
		{
		super();
		}

	/**
	 * @since 0.1.0
	 */
	public UncheckedException(final String message)
		{
		super(message);
		}

	/**
	 * @since 0.1.0
	 */
	public UncheckedException(final Throwable cause)
		{
		super(cause);
		}

	/**
	 * @since 0.1.0
	 */
	public UncheckedException(final String message, final Throwable cause)
		{
		super(message, cause);
		}
	}

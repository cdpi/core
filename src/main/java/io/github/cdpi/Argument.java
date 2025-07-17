package io.github.cdpi;

import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>Argument</h1>
 * 
 * @version 0.3.0
 * @since 0.3.0
 */
public class Argument
	{
	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.0
	 */
	public static final <T> T notNull(final T value)
		{
		if (value == null)
			{
			throw new NullArgumentException();
			}

		return value;
		}

	//public static final <T> T notNull(final T value, final String name)
	//throw new NullArgumentException("%s cannot be null".formatted(name));
	}

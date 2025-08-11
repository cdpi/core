package io.github.cdpi.regex;

import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>Expression</h1>
 * 
 * @version 0.13.0
 * @since 0.13.0
 */
public class Expression
	{
	protected final String regex;
	protected final Modifier modifier;

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.13.0
	 */
	protected Expression(final String regex, final Modifier modifier)
		{
		super();

		this.regex = Argument.notNull(regex);
		this.modifier = modifier;
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.13.0
	 */
	protected Expression(final String regex)
		{
		this(regex, null);
		}

	/**
	 * @since 0.13.0
	 */
	@Override
	public final String toString()
		{
		var expression = regex;

		if (modifier != null)
			{
			expression += modifier.toString();
			}

		return expression;
		}
	}

package io.github.cdpi.regex;

import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>Modifier</h1>
 * 
 * @version 0.13.0
 * @since 0.13.0
 */
public class Modifier
	{
	public static final Modifier ZeroOrOne = new Modifier("?");
	public static final Modifier ZeroOrMore = new Modifier("*");
	public static final Modifier OneOrMore = new Modifier("+");

	protected final String regex;

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.13.0
	 */
	protected Modifier(final String regex)
		{
		super();

		this.regex = Argument.notNull(regex);
		}

	/**
	 * @since 0.13.0
	 */
	@Override
	public final String toString()
		{
		return regex;
		}

	/**
	 * <h1>Modifier.Repeat</h1>
	 * 
	 * @version 0.13.0
	 * @since 0.13.0
	 */
	public static final class Repeat extends Modifier
		{
		/**
		 * @since 0.13.0
		 */
		public Repeat(final int count)
			{
			super("{%d}".formatted(count));
			}
		}

	/**
	 * <h1>Modifier.Between</h1>
	 * 
	 * @version 0.13.0
	 * @since 0.13.0
	 */
	public static final class Between extends Modifier
		{
		/**
		 * @since 0.13.0
		 */
		public Between(final int minimum, final int maximum)
			{
			super("{%d,%d}".formatted(minimum, maximum));
			}
		}
	}

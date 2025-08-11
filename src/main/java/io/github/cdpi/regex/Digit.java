package io.github.cdpi.regex;

/**
 * <h1>Digit</h1>
 * 
 * @version 0.13.0
 * @since 0.13.0
 */
public final class Digit extends Expression
	{
	private static final String DIGIT = "\\d";

	/**
	 * @since 0.13.0
	 */
	public Digit(final Modifier modifier)
		{
		super(DIGIT, modifier);
		}

	/**
	 * @since 0.13.0
	 */
	public Digit()
		{
		this(null);
		}
	}

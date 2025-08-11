package io.github.cdpi.regex;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>RegEx</h1>
 * 
 * @version 0.13.0
 * @since 0.13.0
 */
public class RegEx
	{
	/*
	protected static final String START = "^";
	protected static final String END = "$";
	*/

	/**
	 * @since 0.13.0
	 */
	public RegEx()
		{
		super();
		}

	/**
	 * @since 0.13.0
	 */
	public static final Expression oneOrTwoDigits()
		{
		return new Digit(new Modifier.Between(1, 2));
		}

	/**
	 * @since 0.13.0
	 */
	public static final Expression twoDigits()
		{
		return new Digit(new Modifier.Repeat(2));
		}

	/**
	 * @since 0.13.0
	 */
	public static final String time()
		{
		// TIME (\\d{2}:\\d{2})
		return toString(twoDigits(), ":", twoDigits());
		}

	/**
	 * @since 0.13.0
	 */
	public static final String hhmm()
		{
		return toString(oneOrTwoDigits(), ":", oneOrTwoDigits());
		}

	public static final String toString(final Object... expressions)
		{
		return List.of(expressions).stream().map(Object::toString).collect(Collectors.joining());
		}

	public static void main(String[] args)
		{
		System.out.println(time());
		System.out.println(hhmm());
		}
	}

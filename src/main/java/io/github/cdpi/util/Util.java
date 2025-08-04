package io.github.cdpi.util;

import java.util.function.Predicate;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>Util</h1>
 * 
 * @version 0.10.0
 * @since ?
 */
public class Util
	{
	public static final String EMPTY_STRING = "";

	public static final String DOT = ".";
	public static final String HASH = "#";
	public static final String SLASH = "/";

	public static final String LEFT_CURLY_BRACKET = "{";
	public static final String RIGHT_CURLY_BRACKET = "}";
	public static final String OPEN_CURLY_BRACE = LEFT_CURLY_BRACKET;
	public static final String CLOSE_CURLY_BRACE = RIGHT_CURLY_BRACKET;

	public static final Predicate<String> BLANK = String::isBlank;

	public static final Predicate<String> NOT_BLANK = Predicate.not(BLANK);

	public static final Predicate<String> START_WITH_HASH = startWith(HASH);
	//public static final Predicate<String> IS_COMMENT = text -> text.startsWith(COMMENT);

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.10.0
	 */
	public static final Predicate<String> startWith(final String prefix)
		{
		Argument.notNull(prefix);

		return text -> text.startsWith(prefix);
		}
	}

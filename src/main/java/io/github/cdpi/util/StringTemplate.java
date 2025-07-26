package io.github.cdpi.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.github.cdpi.Argument;
import io.github.cdpi.annotations.CodeByCopilot;

/**
 * <h1>StringTemplate</h1>
 * 
 * @version 0.9.0
 * @since 0.8.0
 */
public class StringTemplate //implements Function<String, String>
	{
	protected final Map<String, Supplier<String>> values = new HashMap<>();

	//private static final String DELIMITERS = "{}";
	//private static final String REGEX = "\\%s([^%s]+)\\%s";
	private final Pattern pattern = Pattern.compile("\\{([^}]+)\\}");

	/**
	 * @since 0.8.0
	 */
	public StringTemplate()
		{
		super();

		//final var start = Character.toString(DELIMITERS.charAt(0));
		//final var end = Character.toString(DELIMITERS.charAt(1));

		//final var regex = REGEX.formatted(start, end, end);

		//pattern = Pattern.compile("\\{([^}]+)\\}");
		//pattern = Pattern.compile(regex);
		}

	/**
	 * @since 0.9.0
	 */
	public final void addValue(final String name, final Supplier<String> supplier)
		{
		Argument.notNull(name);
		Argument.notNull(supplier);

		values.put(name, supplier);
		}

	/**
	 * @since 0.9.0
	 */
	public final void addValue(final String name, final String value)
		{
		Argument.notNull(value);

		addValue(name, () -> value);
		}

	@Deprecated
	public String apply(final String variable)
		{
		throw new UnsupportedOperationException();
		}

	/**
	 * @since 0.9.0
	 */
	public final String getValue(final String name)
		{
		Argument.notNull(name);

		if (values.containsKey(name))
			{
			return values.get(name).get();
			}

		return "";
		}

	/**
	 * @since 0.8.0
	 */
	@CodeByCopilot
	public final String render(final String template)
		{
		final var matcher = pattern.matcher(template);

		final var buffer = new StringBuffer();

		while (matcher.find())
			{
			final var key = matcher.group(1);

			final var replacement = getValue(key);

			matcher.appendReplacement(buffer, Matcher.quoteReplacement(replacement));
			}

		matcher.appendTail(buffer);

		return buffer.toString();
		}

	@Deprecated
	@CodeByCopilot
	public final String render(final String template, final Map<String, String> values)
		{
		/*
		final var matcher = pattern.matcher(template);

		final var buffer = new StringBuffer();

		while (matcher.find())
			{
			final var key = matcher.group(1);

			final var replacement = values.getOrDefault(key, "");

			matcher.appendReplacement(buffer, Matcher.quoteReplacement(replacement));
			}

		matcher.appendTail(buffer);

		return buffer.toString();
		*/

		throw new UnsupportedOperationException();
		}
	}

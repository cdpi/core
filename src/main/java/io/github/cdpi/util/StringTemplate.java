package io.github.cdpi.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.github.cdpi.Argument;
import io.github.cdpi.annotations.CodeByCopilot;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>StringTemplate</h1>
 * 
 * @version 0.10.0
 * @since 0.8.0
 */
public class StringTemplate
	{
	public static final String PATTERN_TEMPLATE = "\\%s([^%s]+)\\%s";

	protected final Map<String, Supplier<String>> values = new HashMap<>();

	//private final Pattern pattern = Pattern.compile("\\{([^}]+)\\}");
	private final Pattern pattern;

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.8.0
	 */
	public StringTemplate(final String startDelimiter, final String endDelimiter)
		{
		super();

		Argument.notNull(startDelimiter);
		Argument.notNull(endDelimiter);

		pattern = Pattern.compile(PATTERN_TEMPLATE.formatted(startDelimiter, endDelimiter, endDelimiter));
		}

	/**
	 * @since 0.8.0
	 */
	public StringTemplate(final char startDelimiter, final char endDelimiter)
		{
		this(String.valueOf(startDelimiter), String.valueOf(endDelimiter));
		}

	/**
	 * @since 0.8.0
	 */
	public StringTemplate()
		{
		this(Util.OPEN_CURLY_BRACE, Util.CLOSE_CURLY_BRACE);
		}

	/**
	 * @since 0.9.0
	 */
	public final void addValue(final String name, final Supplier<String> supplier)
		{
		values.put(Argument.notNull(name), Argument.notNull(supplier));
		}

	/**
	 * @since 0.9.0
	 */
	public final void addValue(final String name, final String value)
		{
		addValue(name, () -> Argument.notNull(value));
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

		return values.getOrDefault(name, () -> Util.EMPTY_STRING).get();
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.8.0
	 */
	@CodeByCopilot
	public final String render(final String template)
		{
		final var matcher = pattern.matcher(Argument.notNull(template));

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

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.8.0
	 */
	public static final String render(final String template, final Map<String, String> values)
		{
		Argument.notNull(values);

		final var stringTemplate = new StringTemplate();

		values.forEach((name, value) ->
			{
			stringTemplate.addValue(name, value);
			});

		return stringTemplate.render(template);
		}
	}

package io.github.cdpi.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

	/**
	 * @throws NullArgumentException
	 * @throws ReflectiveOperationException
	 * 
	 * @since 0.8.0
	 */
	public static final Object newInstance(final String name) throws ReflectiveOperationException
		{
		final var clazz = Class.forName(Argument.notNull(name));

		return clazz.getConstructor().newInstance();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * 
	 * @since 0.8.0
	 */
	public static final Class<?> load(final Path path, final String name) throws IOException, ClassNotFoundException
		{
		Argument.notNull(path);
		Argument.notNull(name);

		final var bytes = Files.readAllBytes(path);

		final var loader = new ClassLoader()
			{
			@Override
			protected Class<?> findClass(final String name) throws ClassNotFoundException
				{
				return defineClass(name, bytes, 0, bytes.length);
				}
			};

		return loader.loadClass(name);
		}
	}

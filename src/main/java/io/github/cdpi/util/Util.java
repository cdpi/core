package io.github.cdpi.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

public class Util
	{
	public static final String DOT = ".";

	// TODO: # name
	private static final String XXX = "#";
	private static final String COMMENT = XXX;

	public static final Predicate<String> BLANK = String::isBlank;

	public static final Predicate<String> NOT_BLANK = Predicate.not(BLANK);

	public static final Predicate<String> IS_COMMENT = text -> text.startsWith(COMMENT);

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

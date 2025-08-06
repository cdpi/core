package io.github.cdpi.util;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>Reflection</h1>
 * 
 * @version 0.11.0
 * @since 0.10.0
 */
public class Reflection
	{
	public static final IntPredicate FINAL = Modifier::isFinal;
	public static final IntPredicate PRIVATE = Modifier::isPrivate;
	public static final IntPredicate PROTECTED = Modifier::isProtected;
	public static final IntPredicate PUBLIC = Modifier::isPublic;
	public static final IntPredicate STATIC = Modifier::isStatic;

	/**
	 * @since 0.10.0
	 */
	private Reflection()
		{
		throw new UnsupportedOperationException();
		}

	/**
	 * @throws NullArgumentException
	 * @throws ReflectiveOperationException
	 * 
	 * @since 0.11.0
	 */
	public static final Map<String, Object> getDeclaredFields(final Object object, final IntPredicate modifiers) throws ReflectiveOperationException
		{
		Argument.notNull(object);
		Argument.notNull(modifiers);

		if (object instanceof Class<?>)
			{
			throw new RuntimeException("CLASS");
			}

		final var clazz = Argument.notNull(object).getClass();

		final var fields = new HashMap<String, Object>();

		for (final var field : clazz.getDeclaredFields())
			{
			System.out.println(field.getName());
			if (modifiers.test(field.getModifiers()))
				{
				fields.put(field.getName(), field.get(object));
				}
			}

		return fields;
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * 
	 * @since 0.8.0
	 */
	public static final Class<?> loadClassFromFile(final Path path, final String name) throws IOException, ClassNotFoundException
		{
		return new FileClassLoader(path).loadClass(name);
		}

	/**
	 * @throws NullArgumentException
	 * @throws ReflectiveOperationException
	 * 
	 * @since 0.11.0
	 */
	public static final Object newInstance(final String name) throws ReflectiveOperationException
		{
		final var clazz = Class.forName(Argument.notNull(name));

		return clazz.getConstructor().newInstance();
		}

	/**
	 * <h1>Reflection.FileClassLoader</h1>
	 * 
	 * @version 0.11.0
	 * @since 0.11.0
	 */
	public static final class FileClassLoader extends ClassLoader
		{
		private final byte[] bytes;

		/**
		 * @throws NullArgumentException
		 * @throws IOException
		 * 
		 * @since 0.11.0
		 */
		public FileClassLoader(final Path path) throws IOException
			{
			super();

			bytes = Files.readAllBytes(Argument.notNull(path));
			}

		/**
		 * @throws NullArgumentException
		 * @throws ClassNotFoundException
		 * 
		 * @since 0.11.0
		 */
		@Override
		protected Class<?> findClass(final String name) throws ClassNotFoundException
			{
			return defineClass(Argument.notNull(name), bytes, 0, bytes.length);
			}
		}
	}

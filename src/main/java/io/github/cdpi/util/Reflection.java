package io.github.cdpi.util;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>StringTemplate</h1>
 * 
 * @version 0.10.0
 * @since 0.10.0
 */
public class Reflection
	{
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
	 * @since 0.10.0
	 */
	public static final Map<String, Object> getPublicStaticFields(final Object object) throws ReflectiveOperationException
		{
		Argument.notNull(object);

		final var clazz = object.getClass();

		final var fields = new HashMap<String, Object>();

		for (final var field : clazz.getDeclaredFields())
			{
			final var modifiers = field.getModifiers();

			if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers))
				{
				final var name = field.getName();
				final var value = field.get(object);

				fields.put(name, value);
				}
			}

		return fields;
		}
	}

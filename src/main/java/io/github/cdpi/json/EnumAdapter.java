package io.github.cdpi.json;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>EnumAdapter</h1>
 * 
 * @version 0.12.1
 * @since 0.12.1
 */
public final class EnumAdapter<T extends Enum<?>> extends TypeAdapter<T>
	{
	private final T[] values;

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.12.1
	 */
	public EnumAdapter(final Class<T> classOfT)
		{
		super();

		values = Argument.notNull(classOfT).getEnumConstants();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	@Override
	public T read(final JsonReader reader) throws IOException
		{
		final var text = reader.nextString();

		for (final T value : values)
			{
			if (value.name().equalsIgnoreCase(text))
				{
				return value;
				}
			}

		return null;
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	@Override
	public void write(final JsonWriter writer, final T value) throws IOException
		{
		writer.value(value.name());
		}
	}

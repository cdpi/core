package io.github.cdpi.json;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.internal.LinkedTreeMap;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>JSON</h1>
 * 
 * @version 0.8.0
 * @since 0.1.0
 */
public class JSON
	{
	/**
	 * @since 0.1.0
	 */
	public static final <T extends Enum<?>> JsonDeserializer<T> getEnumDeserializer(final Class<T> classOfT)
		{
		final T[] constants = classOfT.getEnumConstants();

		return new JsonDeserializer<T>()
			{
			@Override
			public T deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException
				{
				final var value = json.getAsString();

				for (final T constant : constants)
					{
					if (constant.name().equalsIgnoreCase(value))
						{
						return constant;
						}
					}

				/*
				Type enumType = (Type) typeOfT;
				if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString())
					{
					String enumValue = json.getAsString();
					for (T constant : ((Class<T>) enumType).getEnumConstants())
						{
						if (constant.name().equalsIgnoreCase(enumValue))
							{
							return constant;
							}
						}
					}
				else if (json.isJsonObject() && json.getAsJsonObject().has("name"))
					{
					String enumValue = json.getAsJsonObject().get("name").getAsString();
					for (T constant : ((Class<T>) enumType).getEnumConstants())
						{
						if (constant.name().equalsIgnoreCase(enumValue))
							{
							return constant;
							}
						}
					}
				throw new JsonParseException("Unknown enum value: " + json);
				*/
				return null;
				}
			};
		}

	/**
	 * @since 0.1.0
	 */
	public static final JsonDeserializer<OffsetDateTime> getOffsetDateTimeDeserializer()
		{
		return new JsonDeserializer<OffsetDateTime>()
			{
			@Override
			public OffsetDateTime deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException
				{
				return OffsetDateTime.parse(json.getAsString());
				}
			};
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.8.0
	 */
	@SuppressWarnings("unchecked")
	public static final Map<String, ?> readAsMap(final String json)
		{
		final var object = new Gson().fromJson(Argument.notNull(json), Object.class);

		// TODO: Gson internal on a le droit d'utiliser comme ça ??
		return LinkedTreeMap.class.cast(object);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.8.0
	 */
	public static final Map<String, ?> readAsMap(final Path path) throws IOException
		{
		return readAsMap(Files.readString(Argument.notNull(path)));
		}
	}

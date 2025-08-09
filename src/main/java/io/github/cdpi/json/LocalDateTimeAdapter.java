package io.github.cdpi.json;

import java.io.IOException;
import java.time.LocalDateTime;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * <h1>LocalDateTimeAdapter</h1>
 * 
 * @version 0.12.1
 * @since 0.12.1
 */
public final class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime>
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	@Override
	public LocalDateTime read(final JsonReader reader) throws IOException
		{
		return LocalDateTime.parse(reader.nextString());
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	@Override
	public void write(final JsonWriter writer, final LocalDateTime date) throws IOException
		{
		writer.value(date.toString());
		}
	}

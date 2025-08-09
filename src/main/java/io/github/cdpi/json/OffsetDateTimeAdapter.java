package io.github.cdpi.json;

import java.io.IOException;
import java.time.OffsetDateTime;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * <h1>OffsetDateTimeAdapter</h1>
 * 
 * @version 0.12.1
 * @since 0.12.1
 */
public final class OffsetDateTimeAdapter extends TypeAdapter<OffsetDateTime>
	{
	/**
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	@Override
	public OffsetDateTime read(final JsonReader reader) throws IOException
		{
		return OffsetDateTime.parse(reader.nextString());
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.12.1
	 */
	@Override
	public void write(final JsonWriter writer, final OffsetDateTime date) throws IOException
		{
		writer.value(date.toString());
		}
	}

package io.github.cdpi.io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.apache.commons.lang3.function.FailableSupplier;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.util.Util;

/**
 * <h1>IO</h1>
 * 
 * @version 0.11.0
 * @since 0.11.0
 */
public class IO
	{
	/**
	 * @since 0.11.0
	 */
	public static final Function<Path, String> READ = IO::read;

	/**
	 * @since 0.11.0
	 */
	public static final BiFunction<Path, String, Path> WRITE = IO::write;

	/**
	 * @since 0.11.0
	 */
	public static final Path getCurrentDirectory()
		{
		return Paths.get(Util.EMPTY_STRING).toAbsolutePath();
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedIOException
	 * 
	 * @since 0.11.0
	 */
	public static final String read(final Path path)
		{
		Argument.notNull(path);

		return wrap(() -> Files.readString(path, StandardCharsets.UTF_8));
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedIOException
	 * 
	 * @since 0.11.0
	 */
	public static final Path write(final Path path, final String content)
		{
		Argument.notNull(path);
		Argument.notNull(content);

		return wrap(() -> Files.writeString(path, content, StandardCharsets.UTF_8));
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedIOException
	 * 
	 * @since 0.11.0
	 */
	public static final <R> R wrap(final FailableSupplier<R, IOException> supplier)
		{
		try
			{
			return Argument.notNull(supplier).get();
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}

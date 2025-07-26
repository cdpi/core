package io.github.cdpi.pandoc;

import java.io.IOException;
import io.github.cdpi.Argument;
import io.github.cdpi.ExternalExecutable;

/**
 * <h1>Pandoc</h1>
 * 
 * @version 0.7.0
 * @since 0.7.0
 */
public final class Pandoc
	{
	/**
	 * <h1>Pandoc.Format</h1>
	 * 
	 * @version 0.7.0
	 * @since 0.7.0
	 */
	public static enum Format
		{
		HTML,
		HTML5,
		MARKDOWN,
		ODT
		}

	private static final String PANDOC = "pandoc";
	private static final String FROM = "-f";
	private static final String TO = "-t";
	//private static final String OUTPUT = "-o";

	/**
	 * @since 0.7.0
	 */
	private Pandoc()
		{
		throw new UnsupportedOperationException();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.7.0
	 */
	public static String execute(final Format from, final Format to, final String input) throws IOException
		{
		Argument.notNull(from);
		Argument.notNull(to);
		Argument.notNull(input);

		final var pandoc = new ExternalExecutable()
			{
			@Override
			protected ProcessBuilder getProcessBuilder()
				{
				return new ProcessBuilder(PANDOC, FROM, from.name().toLowerCase(), TO, to.name().toLowerCase(), input);
				}

			public String execute() throws IOException
				{
				final var buffer = new StringBuilder();

				super.execute(output -> buffer.append(output));

				return buffer.toString();
				}
			};

		return pandoc.execute();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.7.0
	 */
	public static String odtToHTML(final String input) throws IOException
		{
		return execute(Format.ODT, Format.HTML, input);
		}
	}

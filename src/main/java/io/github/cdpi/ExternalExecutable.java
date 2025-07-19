package io.github.cdpi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.function.Consumer;
import org.apache.commons.lang3.NotImplementedException;

/**
 * <h1>ExternalExecutable</h1>
 * 
 * @version 0.4.0
 * @since 0.4.0
 */
public class ExternalExecutable
	{
	/**
	 * @throws NotImplementedException
	 * @throws IOException
	 * 
	 * @since 0.4.0
	 */
	public int execute(final Consumer<String> consumer) throws IOException
		{
		try
			{
			final var process = getProcessBuilder().start();

			final var output = readOutput(process);

			final var exitCode = process.waitFor();

			consumer.accept(output);

			// Sert à rien si erreur -> throw pas return ;-)
			return exitCode;
			}
		catch (final InterruptedException ex)
			{
			throw new IOException(ex);
			}
		}

	/**
	 * @throws NotImplementedException
	 * 
	 * @since 0.4.0
	 */
	protected ProcessBuilder getProcessBuilder()
		{
		throw new NotImplementedException();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.4.0
	 */
	protected final String readOutput(final Process process) throws IOException
		{
		try (final var writer = new StringWriter())
			{
			try (final var reader = new BufferedReader(new InputStreamReader(process.getInputStream())))
				{
				reader.transferTo(writer);

				return writer.toString();
				}
			}
		}

	/*
	void asdsd() throws Exception
		{
		ProcessBuilder pb =  new ProcessBuilder("myCommand", "myArg1", "myArg2");
		Map<String, String> env = pb.environment();
		env.put("VAR1", "myValue");
		env.remove("OTHERVAR");
		env.put("VAR2", env.get("VAR1") + "suffix");
		pb.directory(new File("myDir"));
		File log = new File("log");
		pb.redirectErrorStream(true);
		pb.redirectOutput(Redirect.appendTo(log));
		Process p = pb.start();
		assert pb.redirectInput() == Redirect.PIPE;
		assert pb.redirectOutput().file() == log;
		assert p.getInputStream().read() == -1;
		}
	*/

	public static void main(String[] args)
		{
		try
			{
			var ls = new ExternalExecutable()
				{
				@Override
				protected ProcessBuilder getProcessBuilder()
					{
					return new ProcessBuilder("ls");
					}
				};

			ls.execute(output ->
				{
				System.out.println(output);
				});
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}
	}

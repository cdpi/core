package io.github.cdpi.git;

import java.io.File;
import java.io.IOException;
import java.util.List;
import io.github.cdpi.Argument;
import io.github.cdpi.ExternalExecutable;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>Git</h1>
 * 
 * @version 0.7.0
 * @since 0.7.0
 */
public class Git
	{
	protected static final String GIT = "git";
	protected static final String ADD = "add";
	protected static final String COMMIT = "commit";
	protected static final String PUSH = "push";
	protected static final String ORIGIN = "origin";
	protected static final String MAIN = "main";
	protected static final String MESSAGE = "-m";
	protected static final String DOT = ".";

	private final String workingDirectory;

	/**
	 * @since 0.7.0
	 */
	public Git(final String workingDirectory)
		{
		super();

		this.workingDirectory = workingDirectory;
		}

	@SuppressWarnings("unused")
	private Git()
		{
		this(null);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.7.0
	 */
	public final void add(final String path) throws IOException
		{
		execute(List.of(GIT, ADD, Argument.notNull(path)));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.7.0
	 */
	public final void add() throws IOException
		{
		// git add .
		add(DOT);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.7.0
	 */
	public final void commit(final String message) throws IOException
		{
		Argument.notNull(message);

		// TODO: Ajouter "" !!!!!!

		execute(List.of(GIT, COMMIT, MESSAGE, "TODOGitCommitAddQuote"));
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.7.0
	 */
	public final void push(final String from, final String to) throws IOException
		{
		Argument.notNull(from);
		Argument.notNull(to);

		execute(List.of(GIT, PUSH, from, to));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.7.0
	 */
	public final void push() throws IOException
		{
		push(ORIGIN, MAIN);
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.7.0
	 */
	protected final int execute(final List<String> command) throws IOException
		{
		final var dir = new File(workingDirectory);

		final var git = new ExternalExecutable()
			{
			@Override
			protected ProcessBuilder getProcessBuilder()
				{
				final var builder = new ProcessBuilder();

				builder.command(command);
				builder.directory(dir);

				return builder;
				}
			};

		return git.execute(output -> {});
		}
	}

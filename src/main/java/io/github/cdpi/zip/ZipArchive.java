package io.github.cdpi.zip;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <h1>ZipArchive</h1>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class ZipArchive implements Closeable
	{
	protected final FileSystem zipfs;

	@SuppressWarnings("unused")
	private ZipArchive()
		{
		throw new UnsupportedOperationException();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	private ZipArchive(final Path path) throws IOException
		{
		super();

		zipfs = FileSystems.newFileSystem(path);
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public ZipArchive(final String path) throws IOException
		{
		this(Paths.get(path));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final byte[] readAsBytes(final String path) throws IOException
		{
		return Files.readAllBytes(getZipPath(path));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final String readAsString(final String path) throws IOException
		{
		return Files.readString(getZipPath(path));
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	@Override
	public void close() throws IOException
		{
		zipfs.close();
		}

	/**
	 * @since 0.1.0
	 */
	protected final Path getZipPath(final String path)
		{
		return zipfs.getPath(path);
		}
	}

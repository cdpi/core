package io.github.cdpi.xml;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

// Context

/**
 * <h1>Handler</h1>
 * 
 * @version 0.10.0
 * @since 0.10.0
 */
public class Handler extends DefaultHandler
	{
	protected final List<Pair<String, String>> path;

	/**
	 * @since 0.10.0
	 */
	public Handler()
		{
		super();

		path = new LinkedList<Pair<String, String>>();
		}

	/**
	 * @since 0.10.0
	 */
	public final List<Pair<String, String>> getPath()
		{
		return Collections.unmodifiableList(path);
		}

	/**
	 * @since 0.10.0
	 */
	public final String getPathAsString()
		{
		return path.stream().map(element -> element.getValue()).collect(Collectors.joining("/"));
		}

	/**
	 * @since 0.10.0
	 */
	public final String getPathAsString2()
		{
		return path.stream().map(element -> "%s:%s".formatted(element.getKey(), element.getValue())).collect(Collectors.joining("/"));
		}

	/**
	 * @since 0.10.0
	 */
	@Override
	public void startDocument()
		{
		}

	/**
	 * @since 0.10.0
	 */
	@Override
	public void endDocument()
		{
		}

	/**
	 * @since 0.10.0
	 */
	@Override
	public void startPrefixMapping(final String prefix, final String uri)
		{
		}

	/**
	 * @since 0.10.0
	 */
	@Override
	public void endPrefixMapping(final String prefix)
		{
		}

	/**
	 * @since 0.10.0
	 */
	@Override
	public void startElement(final String uri, final String localName, final String qName, final Attributes attributes)
		{
		path.add(Pair.of(uri, localName));
		}

	/**
	 * @since 0.10.0
	 */
	@Override
	public void endElement(final String uri, final String localName, final String qName)
		{
		path.remove(path.size() - 1);
		}
	}

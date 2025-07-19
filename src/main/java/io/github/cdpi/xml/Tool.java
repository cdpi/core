package io.github.cdpi.xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <h1>Tool</h1>
 * 
 * @version 0.5.0
 * @since 0.5.0
 */
public class Tool
	{
	public static final Collector collect(final String xml) throws IOException, SAXException
		{
		try (final var reader = new StringReader(xml))
			{
			final var collector = new Collector();

			//XML.getSAXParser().getXMLReader();

			XML.getSAXParser(true).parse(new InputSource(reader), collector);

			return collector;
			}
		}

	/**
	 * <h1>Tool.Collector</h1>
	 * 
	 * @version 0.5.0
	 * @since 0.5.0
	 */
	public static class Collector extends DefaultHandler
		{
		private final Map<String, String> namespaces = new HashMap<>();
		private final Set<String> prefixes = new HashSet<>();
		private final Set<String> uris = new HashSet<>();
		private final Set<String> elements = new HashSet<>();

		public final Map<String, String> getNamespaces()
			{
			return Collections.unmodifiableMap(namespaces);
			}

		public final Collection<String> getPrefixes()
			{
			final var list = new ArrayList<>(prefixes);

			Collections.sort(list);

			return Collections.unmodifiableList(list);
			}

		public final Collection<String> getURIs()
			{
			final var list = new ArrayList<>(uris);

			Collections.sort(list);

			return Collections.unmodifiableList(list);
			}

		public final Collection<String> getElements()
			{
			final var list = new ArrayList<>(elements);

			Collections.sort(list);

			return Collections.unmodifiableList(list);
			}

		@Override
		public void startPrefixMapping(final String prefix, final String uri)
			{
			namespaces.putIfAbsent(prefix, uri);
			prefixes.add(prefix);
			//uris.add(uri);
			}

		@Override
		public void startElement(final String uri, final String localName, final String qName, final Attributes attributes)
			{
			uris.add(uri);
			elements.add(localName);
			}

		@Override
		public String toString()
			{
			final var buffer = new StringBuilder();

			buffer.append("Namespaces:\n");

			getNamespaces().forEach((prefix, uri) ->
				{
				buffer.append(prefix).append(": ").append(uri).append("\n");
				});

			buffer.append("Prefixes:\n");

			getPrefixes().forEach(prefix ->
				{
				buffer.append(prefix);
				buffer.append("\n");
				});

			buffer.append("URIs:\n");

			getURIs().forEach(uri ->
				{
				buffer.append(uri);
				buffer.append("\n");
				});

			buffer.append("Elements:\n");

			getElements().forEach(element ->
				{
				buffer.append(element);
				buffer.append("\n");
				});

			return buffer.toString();
			}
		}
	}

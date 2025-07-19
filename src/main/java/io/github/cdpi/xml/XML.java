package io.github.cdpi.xml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import io.github.cdpi.xml.exceptions.ParseException;
import io.github.cdpi.xml.exceptions.XMLException;

/**
 * <h1>XML</h1>
 * 
 * @version 0.5.0
 * @since 0.5.0
 */
public class XML extends Factory
	{
	/**
	 * @since 0.5.0
	 */
	private XML()
		{
		throw new UnsupportedOperationException();
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.5.0
	 */
	public static final Document parse(final String xml) throws IOException
		{
		try (final var reader = new StringReader(xml))
			{
			return getDocumentBuilder(true).parse(new InputSource(reader));
			}
		catch (final SAXException ex)
			{
			throw new ParseException(ex);
			}
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.5.0
	 */
	public static final void parse(final String xml, final DefaultHandler handler) throws IOException
		{
		try (final var reader = new StringReader(xml))
			{
			getSAXParser(true).parse(new InputSource(reader), handler);
			}
		catch (final SAXException ex)
			{
			throw new ParseException(ex);
			}
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.5.0
	 */
	public static final String documentToString(final Document document)
		{
		try (final var writer = new StringWriter())
			{
			//writer.write("<!DOCTYPE html>\n");

			final var transformer = newTransformer();

			transformer.transform(new DOMSource(document), new StreamResult(writer));

			return writer.toString();
			}
		catch (final TransformerException ex)
			{
			// TODO: Erreur Transformer
			throw new XMLException(ex);
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}

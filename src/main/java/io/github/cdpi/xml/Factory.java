package io.github.cdpi.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import io.github.cdpi.xml.exceptions.FactoryException;
import io.github.cdpi.xml.exceptions.XMLException;

/**
 * <h1>Factory</h1>
 * 
 * @version 0.5.0
 * @since 0.5.0
 */
public class Factory
	{
	/**
	 * @throws FactoryException
	 * 
	 * @since 0.5.0
	 */
	public static final SAXParserFactory getSAXParserFactory()
		{
		try
			{
			return SAXParserFactory.newInstance();
			}
		catch (final FactoryConfigurationError ex)
			{
			throw new FactoryException(ex);
			}
		}

	/**
	 * @throws FactoryException
	 * @throws XMLException
	 * 
	 * @since 0.5.0
	 * 
	 * @todo ParserException
	 */
	public static final SAXParser getSAXParser(final boolean useNamespace)
		{
		try
			{
			final var factory = getSAXParserFactory();

			factory.setNamespaceAware(useNamespace);

			return factory.newSAXParser();
			}
		catch (final ParserConfigurationException ex)
			{
			throw new FactoryException(ex);
			}
		catch (final SAXException ex)
			{
			// TODO: ParserException
			throw new XMLException(ex);
			}
		}

	/**
	 * @throws FactoryException
	 * @throws XMLException
	 * 
	 * @since 0.5.0
	 * 
	 * @todo ParserException
	 */
	public static final SAXParser getSAXParser()
		{
		return getSAXParser(false);
		}

	/**
	 * @throws FactoryException
	 * 
	 * @since 0.5.0
	 */
	public static final DocumentBuilderFactory getDocumentBuilderFactory()
		{
		try
			{
			return DocumentBuilderFactory.newInstance();
			}
		catch (final FactoryConfigurationError ex)
			{
			throw new FactoryException(ex);
			}
		}

	/**
	 * @throws FactoryException
	 * 
	 * @since 0.5.0
	 */
	public static final DocumentBuilder getDocumentBuilder(final boolean useNamespace)
		{
		try
			{
			final var factory = getDocumentBuilderFactory();

			factory.setNamespaceAware(useNamespace);

			return factory.newDocumentBuilder();
			}
		catch (final ParserConfigurationException ex)
			{
			throw new FactoryException(ex);
			}
		}

	/**
	 * @throws FactoryException
	 * 
	 * @since 0.5.0
	 */
	public static final DocumentBuilder getDocumentBuilder()
		{
		return getDocumentBuilder(false);
		}

	/**
	 * @throws FactoryException
	 * 
	 * @since 0.5.0
	 */
	public static final Document newDocument()
		{
		return getDocumentBuilder().newDocument();
		}

	/**
	 * @throws FactoryException
	 * 
	 * @since 0.5.0
	 */
	public static final TransformerFactory getTransformerFactory()
		{
		try
			{
			return TransformerFactory.newInstance();
			}
		catch (final TransformerFactoryConfigurationError ex)
			{
			throw new FactoryException(ex);
			}
		}

	/**
	 * @throws FactoryException
	 * 
	 * @since 0.5.0
	 */
	public static final Transformer newTransformer(final TransformerConfiguration configuration)
		{
		try
			{
			final var transformer = getTransformerFactory().newTransformer();

			configuration.configure(transformer);

			return transformer;
			}
		catch (final TransformerConfigurationException ex)
			{
			throw new FactoryException(ex);
			}
		}

	/**
	 * @throws FactoryException
	 * 
	 * @since 0.5.0
	 */
	public static final Transformer newTransformer()
		{
		final var configuration = new TransformerConfiguration();

		configuration.setStandalone(true);
		configuration.setIndent(true);
		configuration.setMethod("html");

		return newTransformer(configuration);
		}

	public static final class TransformerConfiguration
		{
		private Boolean standalone;
		private Boolean indent;
		private String method;

		public TransformerConfiguration setStandalone(final boolean standalone)
			{
			this.standalone = Boolean.valueOf(standalone);

			return this;
			}

		public TransformerConfiguration setIndent(final boolean indent)
			{
			this.indent = Boolean.valueOf(indent);

			return this;
			}

		public TransformerConfiguration setMethod(final String method)
			{
			this.method = method;

			return this;
			}

		void configure(final Transformer transformer)
			{
			//transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			//transformer.setOutputProperty(OutputKeys.STANDALONE, yesOrNo(standalone));
			//transformer.setOutputProperty(OutputKeys.METHOD, "html");
			//transformer.setOutputProperty(OutputKeys.INDENT, yesOrNo(indent));

			//transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "");
			//transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "");

			//transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "");
			//transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "about:legacy-compat");

			if (standalone != null)
				{
				transformer.setOutputProperty(OutputKeys.STANDALONE, yesOrNo(standalone.booleanValue()));
				}

			if (indent != null)
				{
				transformer.setOutputProperty(OutputKeys.INDENT, yesOrNo(indent.booleanValue()));
				}

			if (method != null)
				{
				transformer.setOutputProperty(OutputKeys.METHOD, method);
				}
			}

		String yesOrNo(final boolean value)
			{
			return value ? "yes" :"no";
			}
		}
	}

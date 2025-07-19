package io.github.cdpi.xml.dev;

import java.io.StringReader;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import io.github.cdpi.xml.XML;

public class Reader
	{
	public static void dev() throws Throwable
		{
		final var reader = XML.getSAXParser(true).getXMLReader();

		final var handler = new DefaultHandler();

		reader.setEntityResolver(handler);
		reader.setDTDHandler(handler);
		reader.setErrorHandler(handler);

		/*
		reader.setErrorHandler(new ErrorHandler()
			{

				@Override
				public void warning(SAXParseException exception) throws SAXException {
				}

				@Override
				public void error(SAXParseException exception) throws SAXException {
				}

				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
				}
			});
			*/

		/*
		reader.setDTDHandler(new DTDHandler()
			{

				@Override
				public void notationDecl(String name, String publicId, String systemId) throws SAXException {
					throw new UnsupportedOperationException("Unimplemented method 'notationDecl'");
				}

				@Override
				public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName)
						throws SAXException {
					throw new UnsupportedOperationException("Unimplemented method 'unparsedEntityDecl'");
				}
			
			});
		*/

		/*
		reader.setEntityResolver(new EntityResolver()
			{
			@Override
			public InputSource resolveEntity(final String publicId, final String systemId)
				{
				System.out.println(publicId);
				System.out.println(systemId);
				return null;
				}
			});
			*/

		reader.parse(new InputSource(new StringReader("<xml><a>sdfsdff &gt;</a></xml>")));

		System.out.println("OK");
		}
	}

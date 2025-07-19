package io.github.cdpi.xml.exceptions;

import org.xml.sax.SAXException;

/**
 * <h1>ParseException</h1>
 * 
 * @version 0.5.0
 * @since 0.5.0
 */
public final class ParseException extends XMLException
	{
	/**
	 * @since 0.5.0
	 */
	public ParseException(final SAXException cause)
		{
		super(cause);
		}
	}

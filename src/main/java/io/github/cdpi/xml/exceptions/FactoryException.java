package io.github.cdpi.xml.exceptions;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;

/**
 * <h1>FactoryException</h1>
 * 
 * @version 0.5.0
 * @since 0.5.0
 */
public final class FactoryException extends XMLException
	{
	/**
	 * @since 0.5.0
	 */
	public FactoryException(final FactoryConfigurationError cause)
		{
		super(cause);
		}

	/**
	 * @since 0.5.0
	 */
	public FactoryException(final ParserConfigurationException cause)
		{
		super(cause);
		}

	/**
	 * @since 0.5.0
	 */
	public FactoryException(final TransformerFactoryConfigurationError cause)
		{
		super(cause);
		}

	/**
	 * @since 0.5.0
	 */
	public FactoryException(final TransformerConfigurationException cause)
		{
		super(cause);
		}
	}

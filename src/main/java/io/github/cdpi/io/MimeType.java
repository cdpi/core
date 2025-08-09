package io.github.cdpi.io;

/**
 * <h1>MimeType</h1>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class MimeType
	{
	public static final String APPLICATION = "application";
	public static final String IMAGE = "image";
	public static final String TEXT = "text";

	public static final String BINARY = "binary";
	public static final String PNG = "png";
	public static final String RDF_XML = "rdf+xml";
	public static final String XML = "xml";

	public static final String APPLICATION_BINARY = join(APPLICATION, BINARY);
	public static final String APPLICATION_RDF_XML = join(APPLICATION, RDF_XML);

	public static final String IMAGE_PNG = join(IMAGE, PNG);

	public static final String TEXT_XML = join(TEXT, XML);

	private static final String JOIN_TEMPLATE = "%s/%s";

	private static final String join(final String left, final String right)
		{
		return JOIN_TEMPLATE.formatted(left, right);
		}
	}

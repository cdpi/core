package io.github.cdpi.api;

/**
 * <h1>API</h1>
 * 
 * @version 0.13.0
 * @since 0.1.0
 */
public class API extends Client
	{
	/**
	 * @since 0.7.0
	 */
	public API()
		{
		super();
		}

	/**
	 * @since 0.13.0
	 */
	public API(final String userAgent)
		{
		this();

		if (userAgent != null)
			{
			userAgent(userAgent);
			}
		}
	}

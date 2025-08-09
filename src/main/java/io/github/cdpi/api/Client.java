package io.github.cdpi.api;

/**
 * <h1>Client</h1>
 * 
 * @version 0.12.1
 * @since 0.12.1
 */
public class Client
	{
	//return new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, Argument.notNull(language));

	public void sdsd()
		{
		builder().acceptLanguage("fr");
		}

	/**
	 * @since 0.12.1
	 */
	public static final Builder builder()
		{
		return new Builder();
		}

	/**
	 * <h1>Client.Builder</h1>
	 * 
	 * @version 0.12.1
	 * @since 0.12.1
	 */
	public static final class Builder
		{
		private String acceptLanguage = null;

		/**
		 * @since 0.12.1
		 */
		private Builder()
			{
			super();
			}

		/**
		 * @since 0.12.1
		 */
		public Builder acceptLanguage(final String language)
			{
			this.acceptLanguage = language;

			return this;
			}
		}
	}

package io.github.cdpi.uuid;

/**
 * <h1>Version</h1>
 * 
 * @version 0.3.0
 * @since 0.3.0
 */
public enum Version
	{
	// Version 1: Time-based UUID
	TIME_BASED(1),

	// Version 2: DCE Security UUID
	DCE_SECURITY(2),

	// Version 3: Name-based UUID using MD5 hashing
	NAME_BASED_MD5(3),

	// Version 4: Randomly generated UUID
	RANDOM(4),

	// Version 5: Name-based UUID using SHA-1 hashing
	NAME_BASED_SHA1(5);

	private final int version;

	/**
	 * @since 0.3.0
	 */
	private Version(final int version)
		{
		this.version = version;
		}

	/**
	 * @since 0.3.0
	 */
	public int getVersion()
		{
		return this.version;
		}
	}

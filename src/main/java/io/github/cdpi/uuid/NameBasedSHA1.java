package io.github.cdpi.uuid;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.apache.commons.lang3.exception.UncheckedException;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>NameBasedSHA1</h1>
 * 
 * @version 0.3.0
 * @since 0.3.0
 */
public final class NameBasedSHA1
	{
	/**
	 * <h1>NameBasedSHA1.Namespace</h1>
	 * 
	 * @version 0.3.0
	 * @since 0.3.0
	 */
	public static enum Namespace
		{
		OID(UUID.fromString("6ba7b812-9dad-11d1-80b4-00c04fd430c8"))

		/*
		DNS 6ba7b810-9dad-11d1-80b4-00c04fd430c8
		URL 6ba7b811-9dad-11d1-80b4-00c04fd430c8
		OID 6ba7b812-9dad-11d1-80b4-00c04fd430c8
		X.500 DN 6ba7b814-9dad-11d1-80b4-00c04fd430c8
		*/
		;

		private final UUID uuid;

		/**
		 * @since 0.3.0
		 */
		private Namespace(final UUID uuid)
			{
			this.uuid = uuid;
			}

		/**
		 * @since 0.3.0
		 */
		public UUID getUUID()
			{
			return this.uuid;
			}
		}

	private final MessageDigest sha1;

	/**
	 * @throws UncheckedException
	 * 
	 * @since 0.3.0
	 */
	public NameBasedSHA1()
		{
		super();

		try
			{
			sha1 = MessageDigest.getInstance("SHA-1");
			}
		catch (final NoSuchAlgorithmException ex)
			{
			// Utilisation "correcte" de UncheckedException
			throw new UncheckedException(ex);
			}
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.0
	 */
	public UUID generate(final UUID uuid, final String name)
		{
		// Généré par Copilot que j'ai modifié un peu

		Argument.notNull(uuid);
		Argument.notNull(name);

		sha1.reset();

		sha1.update(toBytes(uuid));
		sha1.update(name.getBytes(StandardCharsets.UTF_8));

		final var hash = sha1.digest();

		// Set version to 5
		hash[6] &= 0x0f;
		hash[6] |= 0x50;

		// Set variant to IETF
		hash[8] &= 0x3f;
		hash[8] |= 0x80;

		long msb = 0;
		long lsb = 0;
		for (int i = 0; i < 8; i++) msb = (msb << 8) | (hash[i] & 0xff);
		for (int i = 8; i < 16; i++) lsb = (lsb << 8) | (hash[i] & 0xff);

		return new UUID(msb, lsb);
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.0
	 */
	public UUID generate(final Namespace namespace, final String name)
		{
		return generate(Argument.notNull(namespace).getUUID(), name);
		}

	/**
	 * @since 0.3.0
	 */
	private byte[] toBytes(final UUID uuid)
		{
		// Généré par Copilot que j'ai modifié un peu

		final var msb = uuid.getMostSignificantBits();
		final var lsb = uuid.getLeastSignificantBits();

		byte[] bytes = new byte[16];

		for (var i = 0; i < 8; i++)
			{
			bytes[i] = (byte) (msb >>> (8 * (7 - i)));
			}

		for (var i = 8; i < 16; i++)
			{
			bytes[i] = (byte) (lsb >>> (8 * (15 - i)));
			}

		return bytes;
		}
	}

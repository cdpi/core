package io.github.cdpi.security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.lang3.exception.UncheckedException;
import org.apache.commons.lang3.function.FailableBiConsumer;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>AbstractAliceAndBob</h1>
 * 
 * @version 0.10.0
 * @since 0.10.0
 */
public abstract class AbstractAliceAndBob extends Factory
	{
	/**
	 * @since 0.10.0
	 */
	public AbstractAliceAndBob()
		{
		super();
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public final PublicKey readPublicKey(final String path) throws IOException
		{
		return (PublicKey) readKey(path, true);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public final PrivateKey readPrivateKey(final String path) throws IOException
		{
		return (PrivateKey) readKey(path, false);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public final void writePublicKey(final String path, final PublicKey key) throws IOException
		{
		writeKey(path, key);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	public final void writePrivateKey(final String path, final PrivateKey key) throws IOException
		{
		writeKey(path, key);
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedException
	 * @throws E
	 * 
	 * @since 0.10.0
	 */
	public final <E extends Throwable> void generate(final FailableBiConsumer<PublicKey, PrivateKey, E> consumer) throws E
		{
		Argument.notNull(consumer);

		final var keys = getKeyPairGenerator().generateKeyPair();

		consumer.accept(keys.getPublic(), keys.getPrivate());
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedException
	 * 
	 * @since 0.10.0
	 */
	public final byte[] sign(final byte[] bytes, final PrivateKey privateKey)
		{
		Argument.notNull(bytes);
		Argument.notNull(privateKey);

		try
			{
			final var signature = getSignature();

			signature.initSign(privateKey);

			signature.update(bytes);

			return signature.sign();
			}
		catch (final InvalidKeyException | SignatureException ex)
			{
			throw new UncheckedException(ex);
			}
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedException
	 * 
	 * @since 0.10.0
	 */
	public final boolean verify(final byte[] bytes, final byte[] signatureBytes, final PublicKey publicKey)
		{
		Argument.notNull(bytes);
		Argument.notNull(signatureBytes);
		Argument.notNull(publicKey);

		try
			{
			final var signature = getSignature();

			signature.initVerify(publicKey);

			signature.update(bytes);

			return signature.verify(signatureBytes);
			}
		catch (final InvalidKeyException | SignatureException ex)
			{
			throw new UncheckedException(ex);
			}
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	private final Key readKey(final String path, final boolean publicKey) throws IOException
		{
		try
			{
			final var bytes = Files.readAllBytes(Paths.get(Argument.notNull(path)));

			final var keySpec = publicKey ? new X509EncodedKeySpec(bytes) : new PKCS8EncodedKeySpec(bytes);

			final var factory = getKeyFactory();

			return publicKey ? factory.generatePublic(keySpec) : factory.generatePrivate(keySpec);
			}
		catch (final InvalidKeySpecException ex)
			{
			throw new UncheckedException(ex);
			}
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.10.0
	 */
	private final void writeKey(final String path, final Key key) throws IOException
		{
		Files.write(Paths.get(Argument.notNull(path)), Argument.notNull(key).getEncoded());
		}
	}

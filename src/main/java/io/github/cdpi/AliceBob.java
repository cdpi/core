package io.github.cdpi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.lang3.exception.UncheckedException;
import org.apache.commons.lang3.function.FailableBiConsumer;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>AliceBob</h1>
 * 
 * @version 0.6.0
 * @since 0.6.0
 */
public final class AliceBob
	{
	private static final String DSA = "DSA";
	private static final String SHA1PRNG = "SHA1PRNG";
	private static final String SHA1withDSA = "SHA1withDSA";

	/**
	 * @since 0.6.0
	 */
	public AliceBob()
		{
		super();
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedException
	 * 
	 * @since 0.6.0
	 */
	public byte[] sign(final byte[] bytes, final PrivateKey privateKey)
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
	 * @since 0.6.0
	 */
	public boolean verify(final byte[] bytes, final byte[] signatureBytes, final PublicKey publicKey)
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
	 * @throws UncheckedException
	 * @throws E
	 * 
	 * @since 0.6.0
	 */
	public <E extends Throwable> void generate(final FailableBiConsumer<PublicKey, PrivateKey, E> consumer) throws E
		{
		Argument.notNull(consumer);

		final var keys = getKeyPairGenerator().generateKeyPair();

		consumer.accept(keys.getPublic(), keys.getPrivate());
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.6.0
	 */
	public PublicKey readPublicKey(final String path) throws IOException
		{
		return (PublicKey) readKey(path, true);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.6.0
	 */
	public PrivateKey readPrivateKey(final String path) throws IOException
		{
		return (PrivateKey) readKey(path, false);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.6.0
	 */
	public void writePublicKey(final String path, final PublicKey key) throws IOException
		{
		writeKey(path, key);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.6.0
	 */
	public void writePrivateKey(final String path, final PrivateKey key) throws IOException
		{
		writeKey(path, key);
		}

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.6.0
	 */
	private Key readKey(final String path, final boolean publicKey) throws IOException
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
	 * @since 0.6.0
	 */
	private void writeKey(final String path, final Key key) throws IOException
		{
		Files.write(Paths.get(Argument.notNull(path)), Argument.notNull(key).getEncoded());
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedException
	 * 
	 * @since 0.6.0
	 */
	private SecureRandom getSecureRandom(final String algorithm)
		{
		try
			{
			return SecureRandom.getInstance(Argument.notNull(algorithm));
			}
		catch (final NoSuchAlgorithmException ex)
			{
			throw new UncheckedException(ex);
			}
		}

	/**
	 * @throws UncheckedException
	 * 
	 * @since 0.6.0
	 */
	private SecureRandom getSecureRandom()
		{
		return getSecureRandom(SHA1PRNG);
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedException
	 * 
	 * @since 0.6.0
	 */
	private KeyPairGenerator getKeyPairGenerator(final String algorithm)
		{
		try
			{
			return KeyPairGenerator.getInstance(Argument.notNull(algorithm));
			}
		catch (final NoSuchAlgorithmException ex)
			{
			throw new UncheckedException(ex);
			}
		}

	/**
	 * @throws UncheckedException
	 * 
	 * @since 0.6.0
	 */
	private KeyPairGenerator getKeyPairGenerator()
		{
		final var generator = getKeyPairGenerator(DSA);

		final var random = getSecureRandom();

		generator.initialize(1024, random);

		return generator;
		}

	/**
	 * @throws UncheckedException
	 * 
	 * @since 0.6.0
	 */
	private KeyFactory getKeyFactory()
		{
		try
			{
			return KeyFactory.getInstance(DSA);
			}
		catch (final NoSuchAlgorithmException ex)
			{
			throw new UncheckedException(ex);
			}
		}

	/**
	 * @throws UncheckedException
	 * 
	 * @since 0.6.0
	 */
	private Signature getSignature()
		{
		try
			{
			return Signature.getInstance(SHA1withDSA);
			}
		catch (final NoSuchAlgorithmException ex)
			{
			throw new UncheckedException(ex);
			}
		}
	}

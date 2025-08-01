package io.github.cdpi.security;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import org.apache.commons.lang3.exception.UncheckedException;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>Factory</h1>
 * 
 * @version 0.10.0
 * @since 0.10.0
 */
public class Factory
	{
	private static final String DSA = "DSA";
	private static final String SHA1PRNG = "SHA1PRNG";
	private static final String SHA1withDSA = "SHA1withDSA";

	/**
	 * @throws UncheckedException
	 * 
	 * @since 0.10.0
	 */
	public static final KeyFactory getKeyFactory()
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
	 * @throws NullArgumentException
	 * @throws UncheckedException
	 * 
	 * @since 0.10.0
	 */
	public static final KeyPairGenerator getKeyPairGenerator(final String algorithm)
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
	 * @since 0.10.0
	 */
	public static final KeyPairGenerator getKeyPairGenerator()
		{
		final var generator = getKeyPairGenerator(DSA);

		final var random = getSecureRandom();

		generator.initialize(1024, random);

		return generator;
		}

	/**
	 * @throws NullArgumentException
	 * @throws UncheckedException
	 * 
	 * @since 0.10.0
	 */
	public static final SecureRandom getSecureRandom(final String algorithm)
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
	 * @since 0.10.0
	 */
	public static final SecureRandom getSecureRandom()
		{
		return getSecureRandom(SHA1PRNG);
		}

	/**
	 * @throws UncheckedException
	 * 
	 * @since 0.10.0
	 */
	public static final Signature getSignature()
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

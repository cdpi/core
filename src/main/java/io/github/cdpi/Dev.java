package io.github.cdpi;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Dev
	{
	static void keys(final String publicKeyPath, final String privateKeyPath)
		{
		try
			{
			final var generator = new AliceBob();

			generator.generate((publicKey, privateKey) ->
				{
				generator.writePublicKey(publicKeyPath, publicKey);
				generator.writePrivateKey(privateKeyPath, privateKey);
				});
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}

	static void sign(final String path, final String privateKeyPath)
		{
		try
			{
			final var bob = new AliceBob();

			final var key = bob.readPrivateKey(privateKeyPath);

			final var bytes = Files.readAllBytes(Paths.get(path));

			final var signature = bob.sign(bytes, key);

			Files.write(Paths.get(path + ".sig"), signature);
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}

	static void verify(final String path, final String signaturePath, final String publicKeyPath)
		{
		try
			{
			final var alice = new AliceBob();

			final var key = alice.readPublicKey(publicKeyPath);

			final var bytes = Files.readAllBytes(Paths.get(path));
			final var signatureBytes = Files.readAllBytes(Paths.get(signaturePath));

			final var ok = alice.verify(bytes, signatureBytes, key);

			System.out.println(ok);
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}

	public static void main(String[] args)
		{
		//keys("public.key", "private.key");
		//sign("pom.xml", "private.key");
		verify("pom.xml", "pom.xml.sig", "public.key");

		/*
		try {
			new AliceBob().readPublicKey("public.key");
			System.out.println(233);
		} catch (Exception e) {
		}
		*/
		}
	}

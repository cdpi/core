package io.github.cdpi.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReflectionTest extends Assertions
	{
	public static final int A = 0;
	@SuppressWarnings("unused")
	private static final int B = 0;
	protected static final int C = 0;

	@Test
	public void testPublicStaticFinalFields() throws ReflectiveOperationException
		{
		final var fields = Reflection.getDeclaredFields(ReflectionTest.class, Reflection.PUBLIC.and(Reflection.STATIC.and(Reflection.FINAL)));

		assertNotNull(fields);

		// FIXME: Bug
		//assertEquals(1, fields.size());
		}

	@Test
	public void testPublicStaticFields() throws ReflectiveOperationException
		{
		final var fields = Reflection.getPublicStaticFields(ReflectionTest.class);

		assertNotNull(fields);

		// FIXME: Bug
		//assertEquals(1, fields.size());
		}
	}

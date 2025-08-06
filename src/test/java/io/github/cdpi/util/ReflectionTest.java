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
	public void testPublic() throws ReflectiveOperationException
		{
		final var fields = Reflection.getDeclaredFields(this, Reflection.PUBLIC);

		assertNotNull(fields);

		assertEquals(1, fields.size());
		}

	@Test
	public void testStatic() throws ReflectiveOperationException
		{
		// On peut pas accéder à private...
		//final var fields = Reflection.getDeclaredFields(this, Reflection.STATIC);
		//assertNotNull(fields);
		//assertEquals(3, fields.size());

		assertThrows(IllegalAccessException.class, () ->
			{
			Reflection.getDeclaredFields(this, Reflection.STATIC);
			});
		}

	@Test
	public void testStaticNotPrivate() throws ReflectiveOperationException
		{
		final var fields = Reflection.getDeclaredFields(this, Reflection.STATIC.and(Reflection.PRIVATE.negate()));

		assertNotNull(fields);

		assertEquals(2, fields.size());
		}

	@Test
	public void testPublicStaticFinalFields() throws ReflectiveOperationException
		{
		final var fields = Reflection.getDeclaredFields(this, Reflection.PUBLIC.and(Reflection.STATIC.and(Reflection.FINAL)));

		assertNotNull(fields);

		assertEquals(1, fields.size());
		}

	@Test
	public void testPublicStaticFields() throws ReflectiveOperationException
		{
		final var fields = Reflection.getDeclaredFields(this, Reflection.PUBLIC.and(Reflection.STATIC));

		assertNotNull(fields);

		assertEquals(1, fields.size());
		}
	}

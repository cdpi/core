package io.github.cdpi.regex;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegExTest extends Assertions
	{
	@Test
	public void testTwoDigits()
		{
		ok(RegEx.twoDigits(), "12");

		ko(RegEx.twoDigits(), "1");
		ko(RegEx.twoDigits(), "123");
		ko(RegEx.twoDigits(), "Abc");
		}

	@Test
	public void testHHMM()
		{
		ok(RegEx.hhmm(), "1:0");
		ok(RegEx.hhmm(), "12:0");
		ok(RegEx.hhmm(), "1:20");
		ok(RegEx.hhmm(), "20:20");
		ok(RegEx.hhmm(), "02:05");
		}

	public static boolean test(final String regex, final String text)
		{
		return Pattern.compile(regex).matcher(text).matches();
		}

	public static void ok(final String regex, final String text)
		{
		assertTrue(test(regex, text));
		}

	public static void ok(final Expression expression, final String text)
		{
		ok(expression.toString(), text);
		}

	public static void ko(final String regex, final String text)
		{
		assertFalse(test(regex, text));
		}

	public static void ko(final Expression expression, final String text)
		{
		ko(expression.toString(), text);
		}
	}

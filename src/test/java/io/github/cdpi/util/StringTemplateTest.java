package io.github.cdpi.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTemplateTest extends Assertions
	{
	@Test
	public void test()
		{
		final var stringTemplate = new StringTemplate();

		stringTemplate.addValue("name", "Alice");
		stringTemplate.addValue("score", "42");

		final var template = "Hello {name}, your score is {score}.";

		assertEquals("Hello Alice, your score is 42.", stringTemplate.render(template));
		}

	@Test
	public void testDelimiters()
		{
		@SuppressWarnings("deprecation")
		final var stringTemplate = new StringTemplate("<", ">");

		stringTemplate.addValue("name", "Alice");
		stringTemplate.addValue("score", "42");

		final var template = "Hello <name>, your score is <score>.";

		assertEquals("Hello Alice, your score is 42.", stringTemplate.render(template));
		}

	/*
	public static void main(String[] args) throws Throwable
		{
		stringTemplate.addValue("time", () -> LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));

		final var template = "Hello {name}, today {time} your score is {score}.";

		System.out.println(stringTemplate.render(template));

		Thread.sleep(3000);

		System.out.println(stringTemplate.render(template));
		}
	*/
	}

package io.github.cdpi.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DevStringTemplate
	{
	public static void main(String[] args) throws Throwable
		{
		final var stringTemplate = new StringTemplate();

		stringTemplate.addValue("name", "Alice");
		stringTemplate.addValue("score", "42");

		stringTemplate.addValue("time", () -> LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));

		final var template = "Hello {name}, today {time} your score is {score}.";

		System.out.println(stringTemplate.render(template));

		Thread.sleep(3000);

		System.out.println(stringTemplate.render(template));
		}
}

package io.github.cdpi.git;

public class Dev
	{
	public static void main(String[] args) throws Throwable
		{
		final var git = new Git("../CDPI/cdpi.github.io");

		git.add();
		git.commit("sdfsfsdfs");
		git.push();
		}
	}

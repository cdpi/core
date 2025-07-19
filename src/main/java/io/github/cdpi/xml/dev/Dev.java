package io.github.cdpi.xml.dev;

import org.w3c.dom.Text;

public class Dev
	{
	static void nodeHandler()
		{
		final var printText = new TextAction()
			{
			@Override
			public void accept(final Text node)
				{
				System.out.println(node.getNodeValue());
				}
			};

		final var textNodeHandler = new TextHandler()
			{
			@Override
			public void accept(final Text node, final INodeAction<? super Text> action)
				{
				action.accept(node);
				}
			};

		textNodeHandler.accept(null, printText);
		}

	public static void main(String[] args)
		{
		nodeHandler();
		}
	}

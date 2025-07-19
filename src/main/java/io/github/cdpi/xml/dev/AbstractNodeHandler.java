package io.github.cdpi.xml.dev;

import org.w3c.dom.Node;

/**
 * <h1>AbstractNodeAction</h1>
 * 
 * @version 0.5.0
 * @since 0.5.0
 */
public abstract class AbstractNodeHandler<T extends Node> implements INodeHandler<T>
	{
	/**
	 * @since 0.5.0
	 */
	@Override
	public void accept(final T node, final INodeAction<? super T> action)
		{
		}
	}

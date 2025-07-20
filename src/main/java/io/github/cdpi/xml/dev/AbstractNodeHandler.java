package io.github.cdpi.xml.dev;

import org.w3c.dom.Node;
import io.github.cdpi.annotations.WorkInProgress;

/**
 * <h1>AbstractNodeAction</h1>
 * 
 * @version 0.6.2
 * @since 0.5.0
 */
public abstract class AbstractNodeHandler<T extends Node> implements INodeHandler<T>
	{
	/**
	 * @since 0.5.0
	 */
	//@Override
	@WorkInProgress
	public void accept(final T node, final INodeAction<? super T> action)
		{
		throw new UnsupportedOperationException();
		}

	/**
	 * @since 0.6.2
	 */
	@Override
	public void accept(final T node)
		{
		throw new UnsupportedOperationException();
		}
	}

package io.github.cdpi.xml.dev;

import org.w3c.dom.Node;
import io.github.cdpi.IHandler;

/**
 * <h1>INodeHandler</h1>
 * 
 * @version 0.6.2
 * @since 0.5.0
 */
@FunctionalInterface
public interface INodeHandler<T extends Node> extends IHandler //<T, INodeAction<? super T>>
	{
	/**
	 * @since 0.6.2
	 */
	public void accept(T node);
	}

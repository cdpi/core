package io.github.cdpi.xml.dev;

import org.w3c.dom.Node;
import io.github.cdpi.IAction;

/**
 * <h1>INodeAction</h1>
 * 
 * @version 0.6.2
 * @since 0.5.0
 */
@FunctionalInterface
public interface INodeAction<T extends Node> extends IAction
	{
	/**
	 * @since 0.6.2
	 */
	public void accept(T node);
	}

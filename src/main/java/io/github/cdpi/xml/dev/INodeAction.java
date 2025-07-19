package io.github.cdpi.xml.dev;

import org.w3c.dom.Node;
import io.github.cdpi.IAction;

/**
 * <h1>INodeAction</h1>
 * 
 * @version 0.5.0
 * @since 0.5.0
 */
@FunctionalInterface
public interface INodeAction<T extends Node> extends IAction<T>
	{
	}

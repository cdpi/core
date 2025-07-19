package io.github.cdpi;

import java.util.function.Consumer;

/**
 * <h1>IAction</h1>
 * 
 * @version 0.5.0
 * @since 0.5.0
 */
@FunctionalInterface
public interface IAction<T> extends Consumer<T>
	{
	}

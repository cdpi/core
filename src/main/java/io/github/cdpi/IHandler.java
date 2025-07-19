package io.github.cdpi;

import java.util.function.BiConsumer;

/**
 * <h1>IHandler</h1>
 * 
 * @version 0.5.0
 * @since 0.5.0
 */
@FunctionalInterface
public interface IHandler<T, U extends IAction<? super T>> extends BiConsumer<T, U>
	{
	}

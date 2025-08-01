package io.github.cdpi.image.filter;

import java.util.function.Function;
import io.github.cdpi.image.ImageInterface;

/**
 * <h1>FilterInterface</h1>
 * 
 * @version 0.10.0
 * @since 0.10.0
 */
@FunctionalInterface
public interface FilterInterface<T> extends Function<ImageInterface<?>, T>
	{
	}

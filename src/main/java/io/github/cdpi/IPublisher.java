package io.github.cdpi;

import org.apache.commons.lang3.function.FailableRunnable;

/**
 * <h1>IPublisher</h1>
 * 
 * @version 0.6.1
 * @since 0.6.1
 */
@FunctionalInterface
public interface IPublisher<E extends Throwable> extends FailableRunnable<E>
	{
	/**
	 * @throws E
	 * 
	 * @since 0.6.1
	 */
	public default void publish() throws E
		{
		run();
		}
	}

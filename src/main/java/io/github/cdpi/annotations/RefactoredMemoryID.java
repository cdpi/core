package io.github.cdpi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>RefactoredMemoryID</h1>
 * 
 * @version 0.6.0
 * @since 0.6.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RefactoredMemoryID
	{
	public String value();
	}

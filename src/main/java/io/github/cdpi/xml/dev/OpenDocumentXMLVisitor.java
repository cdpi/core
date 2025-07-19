package io.github.cdpi.xml.dev;

public class OpenDocumentXMLVisitor
	{
	/*
	public class OpenDocumentHandler extends AbstractHandler<OpenDocument, IOpenDocumentAction>
		{
		}

	public class OpenDocumentActionHandler extends AbstractActionHandler<OpenDocumentActionHandler, OpenDocument, IOpenDocumentAction, OpenDocumentHandler>
		{
		}

	public static interface IAction<N>
		{
		}

	public static interface IOpenDocumentAction extends IAction<OpenDocument>
		{
		}

	public static abstract class AbstractHandler<N, A extends IAction<? super N>>
		{
		}

	public static abstract class AbstractActionHandler<T extends AbstractActionHandler<T, N, A, H>, N, A extends IAction<N>, H extends AbstractHandler<N, A>>
		{
		}
	*/
	}

//public interface AstAction<N>
//abstract public class AstHandler<N, A extends AstAction<? super N>>
	//public abstract class AstActionHandler<C extends AstActionHandler<C, N, A, H>, N, A extends AstAction<N>, H extends AstHandler<N, A>>
		/**
 * Intended to be completed by subclasses for specific node types and node actions
 *
 * @param <C> subclass of this class to have functions returning this to have the correct type
 * @param <N> base node type, this class does not care but in specific handlers it should be a common supertype for all nodes
 * @param <A> action type, subclasses of {@link AstAction} and {@link AstHandler} provide actual functionality
 * @param <H> handler to invoke the functionality during AST traversal for specific node
 */
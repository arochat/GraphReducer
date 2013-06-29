package org.arochat.graphReducer.callable;

import java.util.concurrent.Callable;

// TODO : how to have a Callable to which I can set properties (like data to handle?)
public class CallableWrapper<V, A> {

	private Callable<V> callable;
	private A argument;

	public V call(A argument) throws Exception {
		this.argument = argument;
		return callable.call();
	}

}

package org.arochat.graphReducer.step.handler;

import java.util.concurrent.BlockingQueue;

// TODO : rename this class
public class Step1Handler<I, O> extends AbstractStepHandler<I, O> {

	private final BlockingQueue<I> inBlockingQueue;
	private final BlockingQueue<O> outBlockingQueue;
	private final BlockingQueue<O> nextBlockingQueue;

	public Step1Handler(BlockingQueue<I> inBlockingQueue, BlockingQueue<O> outBlockingQueue,
			BlockingQueue<O> nextBlockingQueue) {
		this.inBlockingQueue = inBlockingQueue;
		this.outBlockingQueue = outBlockingQueue;
		this.nextBlockingQueue = nextBlockingQueue;
	}

}

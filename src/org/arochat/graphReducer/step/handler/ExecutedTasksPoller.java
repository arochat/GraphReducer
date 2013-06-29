package org.arochat.graphReducer.step.handler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public class ExecutedTasksPoller<O> implements Runnable {

	private final BlockingQueue<O> nextBlockingQueue;
	private final BlockingQueue<O> outBlockingQueue;
	private final ExecutorService executorService;

	public ExecutedTasksPoller(BlockingQueue<O> outBlockingQueue, BlockingQueue<O> nextBlockingQueue,
			ExecutorService executorService) {
		this.nextBlockingQueue = nextBlockingQueue;
		this.outBlockingQueue = outBlockingQueue;
		this.executorService = executorService;
	}

	@Override
	public void run() {
		// TODO poll outgoing tasks and put them in outBlockingQueue

	}

}

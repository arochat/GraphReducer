package org.arochat.graphReducer.step.handler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public class IncomingTasksPoller<I> implements Runnable {

	private final BlockingQueue<I> inBlockingQueue;
	private final ExecutorService executorService;

	public IncomingTasksPoller(BlockingQueue<I> inBlockingQueue, ExecutorService executorService) {
		this.inBlockingQueue = inBlockingQueue;
		this.executorService = executorService;
	}

	@Override
	public void run() {
		// TODO poll inBlockingQueue and submit to executorService

	}

}

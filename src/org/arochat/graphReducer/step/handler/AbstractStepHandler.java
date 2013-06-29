package org.arochat.graphReducer.step.handler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AbstractStepHandler<I, O> {

	private final int poolSize = 10;
	private ExecutorService executorService;

	public void start(BlockingQueue<I> inBlockingQueue, BlockingQueue<O> outBlockingQueue,
			BlockingQueue<O> nextBlockingQueue) {
		// TODO : get impl from context
		executorService = Executors.newFixedThreadPool(poolSize);
		executorService.submit(new IncomingTasksPoller(inBlockingQueue, executorService));
		executorService.submit(new ExecutedTasksPoller(outBlockingQueue, nextBlockingQueue, executorService));
	}

	public final void shutdown() {
		executorService.shutdown();
	}

}

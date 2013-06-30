package org.arochat.graphReducer.step.handler;

import java.util.Map;
import java.util.Timer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public class BaseCommonPotHandler<O> extends AbstractStepHandler<O> {

	public BaseCommonPotHandler(BlockingQueue<Map<String, Integer>> inBlockingQueue, BlockingQueue<O> outBlockingQueue,
			BlockingQueue<O> nextBlockingQueue, ExecutorService executorService, Timer incomingTasksTimer,
			Timer executedTasksTimer) {
		super(inBlockingQueue, outBlockingQueue, nextBlockingQueue, executorService, incomingTasksTimer,
				executedTasksTimer);

	}

	// how to receive what the incomingTaskPoller has retrieved from the queue?
	// need a reference to incomingTaskPoller here
	// because here we know which type of Worker to implement

	// Worker w = new Worker(element);
	// executorService.submit(w);

}

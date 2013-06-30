package org.arochat.graphReducer.step.handler;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public class IncomingTasksPoller extends AbstractIncomingTasksPoller<Map<String, Integer>> {

	public IncomingTasksPoller(BlockingQueue<Map<String, Integer>> inBlockingQueue, ExecutorService executorService) {
		super(inBlockingQueue, executorService);
	}

}

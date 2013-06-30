package org.arochat.graphReducer.step.handler;

import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public class IncomingTasksPoller extends TimerTask {

	private final BlockingQueue<Map<String, Integer>> inBlockingQueue;
	private final ExecutorService executorService;

	public IncomingTasksPoller(BlockingQueue<Map<String, Integer>> inBlockingQueue, ExecutorService executorService) {
		this.inBlockingQueue = inBlockingQueue;
		this.executorService = executorService;
	}

	@Override
	public void run() {
		// TODO poll inBlockingQueue and submit to executorService
		Map<String, Integer> element = inBlockingQueue.poll();
		if (element != null) {
			System.out.println("polled from inQueue : map of size " + element.size());
		} else {
			System.out.println("queue empty");
		}
	}

}

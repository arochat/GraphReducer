package org.arochat.graphReducer.step.handler;

import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public abstract class AbstractIncomingTasksPoller<I> extends TimerTask {

	private final BlockingQueue<I> inBlockingQueue;
	private final ExecutorService executorService;

	public AbstractIncomingTasksPoller(BlockingQueue<I> inBlockingQueue, ExecutorService executorService) {
		this.inBlockingQueue = inBlockingQueue;
		this.executorService = executorService;
	}

	@Override
	public void run() {
		// TODO poll element in inBlockingQueue and submit related task to
		// executorService

		// For this we need to know which Worker needs to be implemented for the
		// task, depending on the incomingQueue (need a registry somewhere)

		I element = inBlockingQueue.poll();
		if (element != null) {
			System.out.println("polled 1 element from inQueue : map of size ");

			// Worker w = new Worker(element);
			// executorService.submit(w);
		} else {
			System.out.println("queue empty");
		}
	}
}

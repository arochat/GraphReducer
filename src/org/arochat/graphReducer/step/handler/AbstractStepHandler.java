package org.arochat.graphReducer.step.handler;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public abstract class AbstractStepHandler<O> {

	private final long delay = 0;
	private final long period = 5000;

	private final BlockingQueue<Map<String, Integer>> inBlockingQueue;
	private final BlockingQueue<O> outBlockingQueue;
	private final BlockingQueue<O> nextBlockingQueue;
	private final ExecutorService executorService;
	private Timer incomingTasksTimer;
	private Timer executedTasksTimer;

	private TimerTask incomingTasksPoller;
	private TimerTask executedTasksPoller;

	public AbstractStepHandler(BlockingQueue<Map<String, Integer>> inBlockingQueue, BlockingQueue<O> outBlockingQueue,
			BlockingQueue<O> nextBlockingQueue, ExecutorService executorService, Timer incomingTasksTimer,
			Timer executedTasksTimer) {
		this.inBlockingQueue = inBlockingQueue;
		this.outBlockingQueue = outBlockingQueue;
		this.nextBlockingQueue = nextBlockingQueue;
		this.executorService = executorService;
		this.incomingTasksTimer = incomingTasksTimer;
		this.executedTasksTimer = executedTasksTimer;
	}

	public void start() {

		incomingTasksPoller = new IncomingTasksPoller(inBlockingQueue, executorService);
		executedTasksPoller = new ExecutedTasksPoller<O>(outBlockingQueue, nextBlockingQueue, executorService);

		incomingTasksTimer.schedule(incomingTasksPoller, delay, period);
		executedTasksTimer.schedule(executedTasksPoller, delay, period);

		executorService.submit(incomingTasksPoller);
		executorService.submit(executedTasksPoller);
	}

	public void shutdown() {
		System.out.println("shutting down");
		incomingTasksTimer.cancel();
		executedTasksTimer.cancel();
		executorService.shutdownNow();
	}

}

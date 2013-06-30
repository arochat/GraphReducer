package org.arochat.graphReducer.step.handler;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

// TODO : rename this class
public class Step1Handler<O> extends AbstractStepHandler<O> {

	private final BlockingQueue<Map<String, Integer>> inBlockingQueue;
	private final BlockingQueue<O> outBlockingQueue;
	private final BlockingQueue<O> nextBlockingQueue;
	private final ExecutorService executorService;

	public Step1Handler(BlockingQueue<Map<String, Integer>> inBlockingQueue, BlockingQueue<O> outBlockingQueue,
			BlockingQueue<O> nextBlockingQueue, ExecutorService executorService) {
		this.inBlockingQueue = inBlockingQueue;
		this.outBlockingQueue = outBlockingQueue;
		this.nextBlockingQueue = nextBlockingQueue;
		this.executorService = executorService;
	}

	public void start() {
		TimerTask incomingTasksPoller = new IncomingTasksPoller(inBlockingQueue, executorService);
		TimerTask executedTasksPoller = new ExecutedTasksPoller<O>(outBlockingQueue, nextBlockingQueue, executorService);

		long delay = 0;
		long period = 5000;

		Timer myTimer1 = new Timer();
		myTimer1.schedule(incomingTasksPoller, delay, period);

		Timer myTimer2 = new Timer();
		myTimer2.schedule(executedTasksPoller, delay, period);

		super.start(executorService, incomingTasksPoller, executedTasksPoller);
	}

}

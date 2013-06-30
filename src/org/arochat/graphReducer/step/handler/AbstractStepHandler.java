package org.arochat.graphReducer.step.handler;

import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AbstractStepHandler<O> {

	private final int poolSize = 10;

	public void start(ExecutorService executorService, TimerTask incomingTasksPoller, TimerTask executedTasksPoller) {

		// TODO : get impl from context
		executorService = Executors.newFixedThreadPool(poolSize);
		executorService.submit(incomingTasksPoller);
		executorService.submit(executedTasksPoller);
	}

	public final void shutdown(ExecutorService executorService) {
		// TODO : does not stop the timertasks...!!!
		System.out.println("shuting down");
		executorService.shutdown();
	}

}

package org.arochat.graphReducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.arochat.graphReducer.work.CommonPotWorker;

public class GraphReducerExecutor {

	private final int BLOCKING_QUEUE_CAPACITY = 100;
	private static final int maximumPoolSize = 20;
	private static final TimeUnit timeUnit = TimeUnit.MINUTES;
	private static final long keepAliveTime = 1;
	private int corePoolSize = 10;

	private ExecutorService executorService;

	public void run() {
		// TODO : inject from context
		executorService = new ThreadPoolExecutor(
				corePoolSize, // core thread pool size
				maximumPoolSize, // maximum thread pool size
				keepAliveTime, // time to wait before resizing pool
				timeUnit, new ArrayBlockingQueue<Runnable>(BLOCKING_QUEUE_CAPACITY, true),
				new ThreadPoolExecutor.CallerRunsPolicy()); // TODO : change
															// this policy

		for (int i = 0; i < corePoolSize; i++) {
			executorService.submit(new CommonPotWorker());
		}

	}

	public void shutdown() {
		executorService.shutdown();
	}
}

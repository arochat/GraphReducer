package org.arochat.graphReducer.step;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.arochat.graphReducer.step.handler.Step1Handler;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

public class GraphReducer {

	public static void main(String[] args) throws InterruptedException {

		final int queueCapacity = 100;

		BlockingQueue<Map<String, Integer>> inBlockingQueue = new ArrayBlockingQueue<Map<String, Integer>>(
				queueCapacity);

		BlockingQueue<DirectedWeightedMultigraph<String, DefaultWeightedEdge>> outBlockingQueue = //
		new ArrayBlockingQueue<DirectedWeightedMultigraph<String, DefaultWeightedEdge>>(queueCapacity);

		BlockingQueue<DirectedWeightedMultigraph<String, DefaultWeightedEdge>> nextBlockingQueue = //
		new ArrayBlockingQueue<DirectedWeightedMultigraph<String, DefaultWeightedEdge>>(queueCapacity);

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Step1Handler<DirectedWeightedMultigraph<String, DefaultWeightedEdge>> handler = //
		new Step1Handler<DirectedWeightedMultigraph<String, DefaultWeightedEdge>>(inBlockingQueue, outBlockingQueue,
				nextBlockingQueue, executorService);

		// prepare data
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("key1", 1);
		map1.put("key2", 2);

		inBlockingQueue.add(map1);

		handler.start();

		Thread.sleep(10000);
		handler.shutdown(executorService);

	}
}

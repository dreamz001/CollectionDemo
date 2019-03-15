package com.rajinder.multithreading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMapExampleSimple {

	//static Map<String, Integer> orders = new ConcurrentHashMap<String, Integer>();
	static Map<String, AtomicInteger> orders = new ConcurrentHashMap<>();
	static void processOrders() {
		for(String city : orders.keySet()) {
			for(int i = 0 ; i<50 ; i++) {
				//int val = orders.get(city);
				orders.get(city).getAndIncrement();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
	//	orders.put("Bombay", 0);
		orders.put("Bombay", new AtomicInteger(0));
		orders.put("Delhi", new AtomicInteger(0));
		orders.put("Punjab", new AtomicInteger(0));
		orders.put("Dehradoon", new AtomicInteger(0));
		orders.put("Shimla", new AtomicInteger(0));
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(ConcurrentHashMapExampleSimple::processOrders);
		service.submit(ConcurrentHashMapExampleSimple::processOrders);
		service.awaitTermination(300, TimeUnit.MILLISECONDS);
		service.shutdown();
		
		System.out.println(orders);
	}
}



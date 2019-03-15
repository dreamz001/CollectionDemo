package com.rajinder.multithreading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapExample {

	static Map<String, Integer> orders = new ConcurrentHashMap<String, Integer>();
	static void processOrders() {
		for(String city : orders.keySet()) {
			for(int i = 0 ; i<50 ; i++) {
				//int val = orders.get(city);
				orders.put(city, (orders.get(city) + 1));
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		orders.put("Bombay", 0);
		orders.put("Delhi", 0);
		orders.put("Punjab", 0);
		orders.put("Dehradoon", 0);
		orders.put("Shimla", 0);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(ConcurrentHashMapExample::processOrders);
		service.submit(ConcurrentHashMapExample::processOrders);
		service.awaitTermination(300, TimeUnit.MILLISECONDS);
		service.shutdown();
		
		System.out.println(orders);
	}
}



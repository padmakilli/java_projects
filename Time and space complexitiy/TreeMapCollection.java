package com.rgt.training.session2basics.collections.service;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.rgt.training.session2basics.collections.interfaces.CollectionMapData;

public class TreeMapCollection implements CollectionMapData {
	
	Map<Integer, String> map = new TreeMap<>();

	/**
	 * insertOperation for inserting the data
	 * */
	@Override
	public void insertOperation(int numElements) {
		long startTime = System.nanoTime();

		for (int i = 1; i < numElements; i++) {
			map.put(i, "Value "+i);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Insert operation completed for " + map.getClass().getSimpleName() + ".");
		System.out.println("Start Time "+ TimeUnit.NANOSECONDS.toSeconds( startTime ));
		System.out.println("End Time "+ TimeUnit.NANOSECONDS.toSeconds( endTime ));
		System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toSeconds( elapsedTime ) + " seconds. With: "+elapsedTime+" of milliseconds");
		System.out.println("Total Memory: " + totalRunTime + " bytes.");
		System.out.println("Free Memory: " + freeRunTime + " bytes.");
		System.out.println("Memory used: " + memoryUsed + " bytes.");
	}
	
	
	/**
	 * updateOperation for reading the data
	 * */
	@Override
	public void updateOperation(int numElements) {
		long startTime = System.nanoTime();
		numElements+=1;
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			Integer key = entry.getKey();
			if (key==numElements) {
				map.put(key, "Updated Value"+numElements);
			}
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Update operation completed for " + map.getClass().getSimpleName() + ".");
		System.out.println("Start Time "+ TimeUnit.NANOSECONDS.toSeconds( startTime ));
		System.out.println("End Time "+ TimeUnit.NANOSECONDS.toSeconds( endTime ));
		System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toSeconds( elapsedTime ) + " seconds. With: "+elapsedTime+" of milliseconds");
		System.out.println("Total Memory: " + totalRunTime + " bytes.");
		System.out.println("Free Memory: " + freeRunTime + " bytes.");
		System.out.println("Memory used: " + memoryUsed + " bytes.");
	}

	/**
	 * readOperation for reading the data
	 * */
	@Override
	public void readOperation() {
		long startTime = System.nanoTime();

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Read operation completed for " + map.getClass().getSimpleName() + ".");
		System.out.println("Start Time "+ TimeUnit.NANOSECONDS.toSeconds( startTime ));
		System.out.println("End Time "+ TimeUnit.NANOSECONDS.toSeconds( endTime ));
		System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toSeconds( elapsedTime ) + " seconds. With: "+elapsedTime+" of milliseconds");
		System.out.println("Total Memory: " + totalRunTime + " bytes.");
		System.out.println("Free Memory: " + freeRunTime + " bytes.");
		System.out.println("Memory used: " + memoryUsed + " bytes.");
	}

	/**
	 * deleteOperation for deleting the data
	 * */
	@Override
	public void deleteOperation() {
		long startTime = System.nanoTime();

		Iterator<Map.Entry<Integer, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
	        Map.Entry<Integer, String> entry = iter.next();
	        int mapKey = entry.getKey();
	        String mapValue = entry.getValue();
	            iter.remove();
	    }

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Delete operation completed for " + map.getClass().getSimpleName() + ".");
		System.out.println("Start Time "+ TimeUnit.NANOSECONDS.toSeconds( startTime ));
		System.out.println("End Time "+ TimeUnit.NANOSECONDS.toSeconds( endTime ));
		System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toSeconds( elapsedTime ) + " seconds. With: "+elapsedTime+" of milliseconds");
		System.out.println("Total Memory: " + totalRunTime + " bytes.");
		System.out.println("Free Memory: " + freeRunTime + " bytes.");
		System.out.println("Memory used: " + memoryUsed + " bytes.");
	}

}

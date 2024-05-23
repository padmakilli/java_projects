package com.rgt.training.session2basics.collections.service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.rgt.training.session2basics.collections.interfaces.CollectionListData;

public class LinkedListCollection implements CollectionListData {
	
	List<Integer> linkedList = new LinkedList<Integer>();

	/**
	 * insertOperation for inserting the data
	 * */
	@Override
	public void insertOperation(int numElements) {
		long startTime = System.nanoTime();

		for (int i = 0; i < numElements; i++) {
			linkedList.add(i);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Insert operation completed for " + linkedList.getClass().getSimpleName() + ".");
		System.out.println("Start Time "+ TimeUnit.NANOSECONDS.toSeconds( startTime ));
		System.out.println("End Time "+ TimeUnit.NANOSECONDS.toSeconds( endTime ));
		System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toSeconds( elapsedTime ) + " seconds. With: "+elapsedTime+" of milliseconds");
		System.out.println("Total Memory: " + totalRunTime + " bytes.");
		System.out.println("Free Memory: " + freeRunTime + " bytes.");
		System.out.println("Memory used: " + memoryUsed + " bytes.");
	}

	/**
	 * updateOperation for updating the data
	 * */
	@Override
	public void updateOperation(int numElements) {
		long startTime = System.nanoTime();

		for (int i = 0; i < numElements; i++) {
			int indexOf = linkedList.indexOf(i);
			linkedList.set(indexOf, i+1);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Update operation completed for " + linkedList.getClass().getSimpleName() + ".");
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

		for (int i = 0; i < linkedList.size(); i++) {
			Integer integer = linkedList.get(i);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Read operation completed for " + linkedList.getClass().getSimpleName() + ".");
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

		for (int i = 0; i < linkedList.size(); i++) {
			linkedList.remove(i);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Delete operation completed for " + linkedList.getClass().getSimpleName() + ".");
		System.out.println("Start Time "+ TimeUnit.NANOSECONDS.toSeconds( startTime ));
		System.out.println("End Time "+ TimeUnit.NANOSECONDS.toSeconds( endTime ));
		System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toSeconds( elapsedTime ) + " seconds. With: "+elapsedTime+" of milliseconds");
		System.out.println("Total Memory: " + totalRunTime + " bytes.");
		System.out.println("Free Memory: " + freeRunTime + " bytes.");
		System.out.println("Memory used: " + memoryUsed + " bytes.");
	}

}

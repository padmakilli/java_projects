package com.rgt.training.session2basics.collections.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.rgt.training.session2basics.collections.interfaces.CollectionListData;

/**
 * ArrayListCollection implements CollectionListData class to use the methods of it
 * */
public class ArrayListCollection implements CollectionListData {
	
	List<Integer> arrayList = new ArrayList<>();

	/**
	 * insertOperation for insert operation
	 * */
	@Override
	public void insertOperation(int numElements) {
		long startTime = System.nanoTime();

		for (int i = 0; i < numElements; i++) {
			arrayList.add(i);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Insert operation completed for " + arrayList.getClass().getSimpleName() + ".");
		System.out.println("Start Time "+ TimeUnit.NANOSECONDS.toSeconds( startTime ));
		System.out.println("End Time "+ TimeUnit.NANOSECONDS.toSeconds( endTime ));
		System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toSeconds( elapsedTime ) + " seconds. With: "+elapsedTime+" of milliseconds");
		System.out.println("Total Memory: " + totalRunTime + " bytes.");
		System.out.println("Free Memory: " + freeRunTime + " bytes.");
		System.out.println("Memory used: " + memoryUsed + " bytes.");
	}

	/**
	 * updateOperation for deleting the data
	 * */
	@Override
	public void updateOperation(int numElements) {
		long startTime = System.nanoTime();

		for (int i = 0; i < numElements; i++) {
			int indexOf = arrayList.indexOf(i);
			arrayList.set(indexOf, i+1);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Updating operation completed for " + arrayList.getClass().getSimpleName() + ".");
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

		for (int i = 0; i < arrayList.size(); i++) {
			Integer integer = arrayList.get(i);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Reading operation completed for " + arrayList.getClass().getSimpleName() + ".");
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

		for (int i = 0; i < arrayList.size(); i++) {
			arrayList.remove(i);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Deleting operation completed for " + arrayList.getClass().getSimpleName() + ".");
		System.out.println("Start Time "+ TimeUnit.NANOSECONDS.toSeconds( startTime ));
		System.out.println("End Time "+ TimeUnit.NANOSECONDS.toSeconds( endTime ));
		System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toSeconds( elapsedTime ) + " seconds. With: "+elapsedTime+" of milliseconds");
		System.out.println("Total Memory: " + totalRunTime + " bytes.");
		System.out.println("Free Memory: " + freeRunTime + " bytes.");
		System.out.println("Memory used: " + memoryUsed + " bytes.");
	}

}

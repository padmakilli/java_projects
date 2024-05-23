package com.rgt.training.session2basics.collections.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.rgt.training.session2basics.collections.interfaces.CollectionSetData;

public class HashSetCollection implements CollectionSetData {
	
	Set<Integer> set = new HashSet<Integer>();

	/**
	 * insertOperation for inserting the data
	 * */
	@Override
	public void insertOperation(int numElements) {
		long startTime = System.nanoTime();

		for (int i = 0; i < numElements; i++) {
			set.add(i);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Insert operation completed for " + set.getClass().getSimpleName() + ".");
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

		Iterator<Integer> iterator = set.iterator(); 
	      // check values
	      while (iterator.hasNext()){
	         String ss = "Set Value: "+iterator.next(); 
	      }

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Read operation completed for " + set.getClass().getSimpleName() + ".");
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

		for (int i = 0; i < set.size(); i++) {
			set.remove(i);
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		
		Runtime runtime = Runtime.getRuntime();
		long totalRunTime = runtime.totalMemory();
		long freeRunTime = runtime.freeMemory();
		
		long memoryUsed = totalRunTime - freeRunTime;
		System.out.println("Delete operation completed for " + set.getClass().getSimpleName() + ".");
		System.out.println("Start Time "+ TimeUnit.NANOSECONDS.toSeconds( startTime ));
		System.out.println("End Time "+ TimeUnit.NANOSECONDS.toSeconds( endTime ));
		System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toSeconds( elapsedTime ) + " seconds. With: "+elapsedTime+" of milliseconds");
		System.out.println("Total Memory: " + totalRunTime + " bytes.");
		System.out.println("Free Memory: " + freeRunTime + " bytes.");
		System.out.println("Memory used: " + memoryUsed + " bytes.");
	}

}

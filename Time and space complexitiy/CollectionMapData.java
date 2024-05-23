package com.rgt.training.session2basics.collections.interfaces;

/**
 * CollectionMapData class to reuse the methods in child classes
 * */
public interface CollectionMapData {

	/**
	 * insertOperation for inserting the data
	 * */
	public abstract void insertOperation(int numElements);
	
	/**
	 * updateOperation for deleting the data
	 * */
	public abstract void updateOperation(int numElements);
	
	/**
	 * readOperation for reading the data
	 * */
	public abstract void readOperation();
	
	/**
	 * deleteOperation for deleting the data
	 * */
	public abstract void deleteOperation();

}

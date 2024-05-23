package com.rgt.training.session2basics.collections.interfaces;


/**
 * CollectionListData class to reuse the methods in child classes
 * */
public interface CollectionSetData {
	
	/**
	 * insertOperation for inserting the data
	 * */
	public abstract void insertOperation(int numElements);
	
	/**
	 * readOperation for reading the data
	 * */
	public abstract void readOperation();
	
	/**
	 * deleteOperation for deleting the data
	 * */
	public abstract void deleteOperation();

}

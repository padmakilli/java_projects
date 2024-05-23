package com.rgt.training.session2basics.collections.helper;

import java.util.Scanner;

import com.rgt.training.session2basics.collections.interfaces.CollectionListData;
import com.rgt.training.session2basics.collections.interfaces.CollectionMapData;
import com.rgt.training.session2basics.collections.interfaces.CollectionSetData;
import com.rgt.training.session2basics.collections.service.ArrayListCollection;
import com.rgt.training.session2basics.collections.service.HashMapCollection;
import com.rgt.training.session2basics.collections.service.HashSetCollection;
import com.rgt.training.session2basics.collections.service.LinkedListCollection;
import com.rgt.training.session2basics.collections.service.TreeMapCollection;
import com.rgt.training.session2basics.collections.service.TreeSetCollection;

/**
 * CollectionsHelper class is used as helper for invoking other classes and there methods
 * */
public class CollectionsHelper {

	CollectionListData list;
	CollectionListData linkedList;
	CollectionSetData set;
	CollectionSetData treeSet;
	CollectionMapData map;
	CollectionMapData treeMap;

	/**
	 * CollectionsHelper constructor to create object for the classes
	 * */
	public CollectionsHelper() {
		list = new ArrayListCollection();
		linkedList = new LinkedListCollection();
		set = new HashSetCollection();
		treeSet = new TreeSetCollection();
		map = new HashMapCollection();
		treeMap = new TreeMapCollection();
	}

	/**
	 * collectionsListMenu methods shows the option to enter data
	 * */
	private int collectionsListMenu(Scanner scanner) {
		System.out.println("Enter data to the operations");
		int nextInt = scanner.nextInt();
		return nextInt;
	}

	/**
	 * insert method to insert the data into the collections
	 * */
	public void insert(Scanner scanner) {

		int choice = collectionsListMenu(scanner);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		list.insertOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		linkedList.insertOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		set.insertOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		treeSet.insertOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		map.insertOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		treeMap.insertOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

	}

	/**
	 * update method to update the data into the collections
	 * */
	public void update(Scanner scanner) {

		int choice = collectionsListMenu(scanner);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		list.updateOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		linkedList.updateOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		map.updateOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		treeMap.updateOperation(choice);

		System.out.println("=======================================================");
		System.out.println("=======================================================");

	}

	/**
	 * read method to read the data into the collections
	 * */
	public void read() {

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		list.readOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		linkedList.readOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		set.readOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		treeSet.readOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		map.readOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		treeMap.readOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

	}

	/**
	 * delete method to delete the data into the collections
	 * */
	public void delete() {

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		list.deleteOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		linkedList.deleteOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		set.deleteOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		treeSet.deleteOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		map.deleteOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

		treeMap.deleteOperation();

		System.out.println("=======================================================");
		System.out.println("=======================================================");

	}

}

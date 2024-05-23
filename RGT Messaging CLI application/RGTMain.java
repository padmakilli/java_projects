package com.rgt.training.session2basics.twitter.main;

import java.io.IOException;

import com.rgt.training.session2basics.twitter.helper.RGTMainHelper;

/**
 * RGTMain is the main class runs the code
 * */
public class RGTMain {
	
	/**
	 * main method which invokes helper class to invoke methods
	 * */
	public static void main(String[] args) throws IOException {
		RGTMainHelper main = new RGTMainHelper();
		main.rgtMessagingMainMenu();
	}
}

package com.rgt.training.session2basics.twitter.serviceImpl;

import java.io.IOException;
import java.util.Scanner;

import com.rgt.training.session2basics.twitter.dto.Tweet;
import com.rgt.training.session2basics.twitter.dto.User;

/**
 * RGTMessagingImpl interface used for service class
 * */
public interface RGTMessagingImpl {
	
	/**
	 * registerUser to register new user
	 * */
	public String registerUser(User user)throws IOException ;
	
	/**
	 * login used for logging in for user
	 * */
	public boolean login(String username,String password);
	
	/**
	 * getAllUsers to fetch all users
	 * */
	public void getAllUsers();
	
	/**
	 * getAllTweets to get all Tweets
	 * */
	public void getAllTweets();
	
	/**
	 * getAllLikes to get all likes
	 * */
	public void getAllLikes();
	
	/**
	 * getTweetById to like a tweet
	 * */
	public Tweet getTweetById(Scanner scanner, String currentUserName);
	
	/**
	 * follow used to follow a user
	 * */
	public void follow(Scanner scanner, String currentUserName);
	
	/**
	 * unfollow used to unfollow a user
	 * */
	public void unfollow(Scanner scanner, String currentUserName);
	
	/**
	 * postTweet used to post a tweet
	 * */
	public void postTweet(Scanner scanner, String currentUserName);
	
	/**
	 * deleteTweet to delete a tweet
	 * */
	public void deleteTweet(Scanner scanner, String currentUserName);
	
	/**
	 * writeData to save data into datasource
	 * */
	public void writeData() throws IOException;

	/**
	 * getTweetMyById is used to get current user tweets
	 * */
	public Tweet getTweetMyById(Scanner scanner, String currentUserName);

	/**
	 * unlikeTweetById is used unlike a tweet
	 * */
	public Tweet unlikeTweetById(Scanner scanner, String currentUserName);

	/**
	 * retweet used to re post a tweet
	 * */
	public void retweet(Scanner scanner, String currentUserName);

	/**
	 * reply used to reply to a tweet
	 * */
	public void reply(Scanner scanner, String currentUserName);
	
}

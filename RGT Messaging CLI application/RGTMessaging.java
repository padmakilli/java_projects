package com.rgt.training.session2basics.twitter.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.rgt.training.session2basics.twitter.dto.Tweet;
import com.rgt.training.session2basics.twitter.dto.User;
import com.rgt.training.session2basics.twitter.serviceImpl.RGTMessagingImpl;

/**
 * RGTMessaging class implements RGTMessagingImpl to use its methods
 * */
public class RGTMessaging implements RGTMessagingImpl {

	private Map<String, User> users;

	private DataStore dataStore;

	private int generateTweetId;

	public RGTMessaging() {
		this.users = new HashMap<>();
		this.dataStore = new DataStore();
		this.users = dataStore.loadDataUsers();
		dataStore.gettingId();
		this.generateTweetId = DataStore.generateTweetId();
	}

	/**
	 * registerUser to register new user
	 * */
	public String registerUser(User user) throws IOException {
		String message = "";
		String userName = user.getUserName();
		boolean containsKey = users.containsKey(userName);
		if (!containsKey) {
			users.put(userName, user);
			dataStore.saveData(users);
			message = "Registered SuccessFully";
		} else {
			message = "Try with Another UserName! " + userName + " already exits";
		}
		return message;
	}

	/**
	 * login used for logging in for user
	 * */
	public boolean login(String username, String password) {
		if (users.isEmpty()) {
			System.out.println("No users listed! Register and please Login Again");
			return false;
		} else {
			for (Map.Entry<String, User> entry : users.entrySet()) {
				if (entry.getValue() != null) {
					if (entry.getValue().getUserName().equalsIgnoreCase(username.toLowerCase())
							&& entry.getValue().getPassword().equals(password)) {
						System.out.println("Login successful!");
						return true;
					}

				} else {
					System.out.println("Invalid username or password.");
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * getAllUsers to fetch all users
	 * */
	public void getAllUsers() {
		System.out.println("List of User names");
		for (Map.Entry<String, User> entry : users.entrySet()) {
			System.out.println(
					"UserName : " + entry.getValue().getUserName() + " posts - " + entry.getValue().getTweets().size());
		}
	}

	/**
	 * getAllTweets to get all Tweets
	 * */
	public void getAllTweets() {
		System.out.println("List of User tweets");
		for (Map.Entry<String, User> entry : users.entrySet()) {
			User value = entry.getValue();
			Set<Tweet> tweets = value.getTweets();
			if (tweets != null) {
				for (Tweet tweet : tweets) {
					LocalTime localTime = tweet.getTimestamp().toLocalTime();
					LocalDate localDate = tweet.getTimestamp().toLocalDate();
					System.out.println(
							"Tweet id is : " + tweet.getId() + ". Content is : " + tweet.getContent() + " timeLine : "
									+ localDate + " " + localTime.getHour()+":"+localTime.getMinute());
				}
			} else {
				System.out.println("User has no tweets");
			}
		}
	}

	/**
	 * follow used to follow a user
	 * */
	public void follow(Scanner scanner, String currentUserName) {
		System.out.print("Enter the username of the user to follow: ");
		String username = scanner.nextLine();
		User currentUser = users.get(currentUserName);
		if (users.containsKey(username)) {
			User userToFollow = users.get(username);
			currentUser.follow(username);
			userToFollow.follow(currentUserName);
			System.out.println("You are now following " + userToFollow.getName() + ".");
		} else {
			System.out.println("User does not exist.");
		}
	}

	/**
	 * unfollow used to unfollow a user
	 * */
	public void unfollow(Scanner scanner, String currentUserName) {
		System.out.print("Enter the username of the user to unfollow: ");
		String username = scanner.nextLine();

		User currentUser = users.get(currentUserName);
		if (users.containsKey(username)) {
			User userToUnfollow = users.get(username);
			currentUser.unfollow(username);
			userToUnfollow.unfollow(currentUserName);
			System.out.println("You have unfollowed " + userToUnfollow.getName() + ".");
		} else {
			System.out.println("User does not exist.");
		}
	}

	/**
	 * postTweet used to post a tweet
	 * */
	public void postTweet(Scanner scanner, String currentUserName) {
		User currentUser = users.get(currentUserName);
		if (currentUser != null) {
			System.out.print("Enter the content of your tweet: ");
			String content = scanner.nextLine();
			int generateTweetId2 = generateTweetId(generateTweetId);
			currentUser.postTweet(content, currentUserName, generateTweetId2);
		}
	}

	/**
	 * deleteTweet to delete a tweet
	 * */
	public void deleteTweet(Scanner scanner, String currentUserName) {
		User currentUser = users.get(currentUserName);
		System.out.print("Enter the ID of the tweet to delete: ");
		int tweetId = scanner.nextInt();
		scanner.nextLine();

		boolean deleted = currentUser.deleteTweet(tweetId);
		if (deleted) {
			System.out.println("Tweet deleted successfully.");
		} else {
			System.out.println("Tweet not found or you do not have permission to delete it.");
		}
	}

	/**
	 * writeData to save data into datasource
	 * */
	public void writeData() throws IOException {
		dataStore.saveData(users);
	}

	/**
	 * getTweetById to like a tweet
	 * */
	@Override
	public Tweet getTweetById(Scanner scanner, String currentUserName) {
		System.out.println("Enter Tweet id to like : ");
		int id = scanner.nextInt();
		for (Map.Entry<String, User> entry : users.entrySet()) {
			User value = entry.getValue();
			if (value != null) {
				Set<Tweet> tweets = value.getTweets();
				if (tweets.size() > 0) {
					for (Tweet tweet : tweets) {
						if (tweet.getId() == id) {
							tweet.setLike(currentUserName);
							return tweet;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * unlikeTweetById is used unlike a tweet
	 * */
	@Override
	public Tweet unlikeTweetById(Scanner scanner, String currentUserName) {
		System.out.println("Enter Tweet id to unlike : ");
		int id = scanner.nextInt();
		for (Map.Entry<String, User> entry : users.entrySet()) {
			User value = entry.getValue();
			if (value != null) {
				Set<Tweet> tweets = value.getTweets();
				if (tweets.size() > 0) {
					for (Tweet tweet : tweets) {
						if (tweet.getId() == id) {
							Set<String> like = tweet.getLike();
							boolean contains = like.contains(currentUserName);
							if (contains) {
								like.remove(currentUserName);
								System.out.println("You have unliked the tweet id : " + tweet.getId());
							} else {
								System.out.println("You have not yet likes the tweet or already unlikes the tweet!");
							}
//							tweet.setLike(currentUserName);
							return tweet;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * getTweetMyById is used to get current user tweets
	 * */
	@Override
	public Tweet getTweetMyById(Scanner scanner, String currentUserName) {
		System.out.println("List of Your Tweets : ");
		for (Map.Entry<String, User> entry : users.entrySet()) {
			User value = entry.getValue();
			if (value != null) {
				if (value.getUserName().equalsIgnoreCase(currentUserName.toLowerCase())) {
					Set<Tweet> tweets = value.getTweets();
					if (tweets.size() > 0) {
						for (Tweet tweet : tweets) {
							System.out
									.println("Tweet id is : " + tweet.getId() + ". Content is : " + tweet.getContent());
							System.out.println("Replys of this : " + tweet.getReply());
						}
					}

				}
			}
		}
		return null;
	}

	/**
	 * getAllLikes to get all likes
	 * */
	@Override
	public void getAllLikes() {
		System.out.println("List of All Likes");
		for (Map.Entry<String, User> entry : users.entrySet()) {
			User value = entry.getValue();
			if (value != null) {
				Set<Tweet> tweets = value.getTweets();
				if (tweets.size() > 0) {
					for (Tweet tweet : tweets) {
						Set<String> like = tweet.getLike();
						for (String likes : like) {
							System.out.println("Likes of the Post : " + tweet.getAuthor() + " liked by : " + likes);
						}
					}
				}
			}
		}

	}

	/**
	 * retweet used to re post a tweet
	 * */
	@Override
	public void retweet(Scanner scanner, String currentUserName) {
		User currentUser = users.get(currentUserName);
		String content = "";
		boolean flag = false;
		System.out.println("Enter Tweet id to retweet : ");
		int id = scanner.nextInt();
		if (currentUser != null) {
			Set<Entry<String, User>> entrySet = users.entrySet();
			for (Map.Entry<String, User> entry : entrySet) {
				User value = entry.getValue();
				if (value != null) {
					Set<Tweet> tweets = value.getTweets();
					if (tweets.size() > 0) {
						for (Tweet tweet : tweets) {
							if (tweet.getId() == id) {
								flag = true;
								content = "reposted : "+tweet.getContent();
								break;
							}
						}
					}
				}
			}
		}
		
		if (flag) {
			int generateTweetId2 = generateTweetId(generateTweetId);
			currentUser.postTweet(content, currentUserName, generateTweetId2);
		}
	}

	/**
	 * reply used to reply to a tweet
	 * */
	@Override
	public void reply(Scanner scanner, String currentUserName) {
		User currentUser = users.get(currentUserName);
		System.out.println("Enter Tweet id to reply : ");
		int id = scanner.nextInt();
		if (currentUser != null) {
			for (Map.Entry<String, User> entry : users.entrySet()) {
				User value = entry.getValue();
				if (value != null) {
					Set<Tweet> tweets = value.getTweets();
					if (tweets.size() > 0) {
						for (Tweet tweet : tweets) {
							if (tweet.getId() == id) {
								System.out.print("Enter the reply content for the tweet : ");
								Scanner sc = new Scanner(System.in);
								String content = sc.nextLine();
								String reply = tweet.getReply();
								String con = "username : " + currentUserName + " content : " + content;
								tweet.setReply(reply + ", " + con);
								System.out.println("successfully replied to tweet");
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * generateTweetId used to generate if for tweets
	 * */
	private int generateTweetId(int id) {
		return this.generateTweetId++;
	}

}

package com.rgt.training.session2basics.twitter.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User implements Serializable to do serialization
 * */
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String name;
	private String bio;
	private List<String> followings;
	private List<String> followers;
	private Set<Tweet> tweets;

	public User() {
		super();
		followings = new ArrayList<>();
		followers = new ArrayList<>();
		tweets = new HashSet<>();
	}

	public User(String username) {
		userName = username;
	}
	
	public User(String userName, String password, String name, String bio,
			List<String> followings, List<String> followers, HashSet<Tweet> tweets) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.bio = bio;
		this.followings = followings;
		this.followers = followers;
		this.tweets = tweets;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<String> getFollowings() {
		return followings;
	}

	public void setFollowings(List<String> followings) {
		this.followings = followings;
	}

	public List<String> getFollowers() {
		return followers;
	}

	public void setFollowers(List<String> followers) {
		this.followers = followers;
	}

	public Set<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(HashSet<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	public void clear() {
		userName = "";
		password = "";
	}
	
	/**
	 * follow used to follow a user
	 * */
	public void follow(String userToFollow) {
        if (!followings.contains(userToFollow)) {
            followings.add(userToFollow);
        } else {
            System.out.println("Your already following " + userToFollow);
        }
    }
	
	/**
	 * unfollow used to unfollow a user
	 * */
	public void unfollow(String userToUnfollow) {
        if (followings.contains(userToUnfollow)) {
            followings.remove(userToUnfollow);
        } else {
            System.out.println("Your not following " + userToUnfollow);
        }
    }

	/**
	 * postTweet used to post a tweet
	 * */
    public Tweet postTweet(String content,String username, int id) {
        Tweet tweet = new Tweet(content, username, id);
//        tweet.setTimestamp(LocalDateTime.now());
        tweets.add(tweet);
        System.out.println(username+ " has posted a new tweet: " + content);
        return tweet;
    }

    /**
	 * deleteTweet to delete a tweet
	 * */
    public boolean deleteTweet(int tweetId) {
    	if (tweets!=null) {
    		for (Tweet tweet : tweets) {
    			if (tweet.getId() == tweetId) {
                    tweets.remove(tweet);
                    System.out.println(this.name + " has deleted the tweet with ID: " + tweetId);
                    return true;
                }
    		}
		}
        return false;
    }
}

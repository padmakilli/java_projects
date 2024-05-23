package com.rgt.training.session2basics.twitter.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Tweet implements Serializable to do serialization
 * */
public class Tweet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String content;
	private String author;
	private LocalDateTime timestamp;
	private Set<String> like;
	private String reply;
	
	public Tweet(String content, String author,int id) {
		this.id = id;
		this.content = content;
		this.author = author;
		this.timestamp = LocalDateTime.now();
		like = new HashSet<>();
		this.reply= "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Set<String> getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like.add(like);
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
}

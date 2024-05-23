package com.rgt.training.session2basics.twitter.helper;

import java.io.IOException;
import java.util.Scanner;

import com.rgt.training.session2basics.twitter.dto.User;
import com.rgt.training.session2basics.twitter.service.RGTMessaging;
import com.rgt.training.session2basics.twitter.serviceImpl.RGTMessagingImpl;

/**
 * RGTMainHelper class used to invoke methods
 * */
public class RGTMainHelper {
	
	RGTMessagingImpl rgtMessaging = new RGTMessaging();

	/**
	 * menu method which invokes service class methods
	 * */
	public void rgtMessagingMainMenu() throws IOException {
		Scanner scanner = new Scanner(System.in);
		int options;
		User account = new User();
		while (true) {
			String username = "";
			String fullname = "";
			String password = "";
			String bio = "";
			String saveAndUnSave = "";
			System.out.println("Welcome to the RGTMessaging!");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			options = scanner.nextInt();
			scanner.nextLine();

			switch (options) {
			case 1:
				System.out.println("ENTER USERNAME");
				username = scanner.next();
				account.setUserName(username);

				System.out.println("ENTER FULLNAME");
				fullname = scanner.next();
				account.setName(fullname);

				System.out.println("ENTER BIO");
				bio = scanner.next();
				account.setBio(bio);
				
				System.out.println("ENTER PASSWORD");
				password = scanner.next();
				account.setPassword(password);

				System.out.println("ENTER Y to save and N clear the data");
				saveAndUnSave = scanner.next();
				switch (saveAndUnSave.toLowerCase()) {
				case "y":
					rgtMessaging.registerUser(account);
					System.out.println("Account Created Successfully!");
					break;
				case "n":
					System.out.println("Account is not Created");
					account.clear();
					defalutMessage(scanner);
					break;
				default:
					System.out.println("Invalid option. Please try again.");
				}
				break;
			case 2:
				System.out.println("ENTER USERNAME");
				username = scanner.next();

				System.out.println("ENTER PASSWORD");
				password = scanner.next();

				boolean login = rgtMessaging.login(username, password);
				if (login) {
					this.loggedInUSerData(username, scanner);
				}else {
					System.out.println("invalid username or password");
				}
				break;
			case 3:
				System.out.println("Exited Successfully");
				defalutMessage(scanner);
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	/**
	 * loggedInUSerData is used if user logins successfully
	 * */
	public void loggedInUSerData(String username, Scanner scanner) throws IOException {
		int choice;
		do {
			System.out.println("Please choose an option:");
			System.out.println("1. List Users");
			System.out.println("2. Follow");
			System.out.println("3. Unfollow");
			System.out.println("4. Post Tweet");
			System.out.println("5. See All Tweets");
			System.out.println("6. See My Tweets");
			System.out.println("7. Delete Tweet");
			System.out.println("8. Like Tweet");
			System.out.println("9. UnLike Tweet");
			System.out.println("10. See All Likes");
			System.out.println("11. ReTweet a Tweet");
			System.out.println("12. Reply to Tweet");
			System.out.println("13. Logout");
			System.out.print("Choose an option: ");
			
			choice = scanner.nextInt();
			Scanner scanner2 = new Scanner(System.in);

			switch (choice) {
			case 1:
				rgtMessaging.getAllUsers();
				break;
			case 2:
				rgtMessaging.follow(scanner2, username);
				break;
			case 3:
				rgtMessaging.unfollow(scanner2, username);
				break;
			case 4:
				rgtMessaging.postTweet(scanner2,username);
				break;
			case 5:
				rgtMessaging.getAllTweets();
				break;
			case 6:
				rgtMessaging.getTweetMyById(scanner, username);
				break;
			case 7:
				rgtMessaging.deleteTweet(scanner2, username);
				break;
			case 8:
				rgtMessaging.getTweetById(scanner2, username);
				break;
			case 9:
				rgtMessaging.unlikeTweetById(scanner, username);
				break;
			case 10:
				rgtMessaging.getAllLikes();
				break;
			case 11:
				rgtMessaging.retweet(scanner, username);
				break;
			case 12:
				rgtMessaging.reply(scanner, username);
				break;
			case 13:
				rgtMessaging.writeData();
				System.out.println("You have logged out successfully");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 13);
	}

	/**
	 * defalutMessage used to show some default message to user
	 * */
	public void defalutMessage(Scanner scanner) {
		do {
			System.out.println("     click 1 to go to Main Menu     ");
		} while (scanner.nextInt() != 1);
	}
}

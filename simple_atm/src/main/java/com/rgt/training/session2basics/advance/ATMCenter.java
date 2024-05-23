package com.rgt.training.session2basics.advance;

import java.util.Scanner;

public class ATMCenter {
	UserAccount accountsArray[] = new UserAccount[15];
	int newUsersAddedList = 0;

	public ATMMachinePoint loggedInUSerData(ATMMachinePoint atm, Scanner scanner) {
		int choice;
		do {
			System.out.println("Welcome to the ATM Simulator");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. View Transaction History");
			System.out.println("5. Logout");
			System.out.print("Choose an option: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Current balance: $" + atm.checkBalance());
				break;
			case 2:
				System.out.print("Enter deposit amount: $");
				double depositAmount = scanner.nextDouble();
				atm.deposit(depositAmount);
				break;
			case 3:
				System.out.print("Enter withdrawal amount: $");
				double withdrawalAmount = scanner.nextDouble();
				atm.withdraw(withdrawalAmount);
				break;
			case 4:
				atm.showTransactionHistory();
				break;
			case 5:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();
		} while (choice != 5);

		return atm;
	}

	public void login(String username, int password, Scanner scanner) {

		for (int i = 0; i < accountsArray.length; i++) {
			UserAccount userAccount = accountsArray[i];
			if (accountsArray[0] == null) {
				System.out.println("no users present! please create new Account and Try Login");
				defalutMessage(scanner);
				break;
			} else if (accountsArray[i] == null) {
				break;
			} else {
				String userName2 = userAccount.getUserName();
				Long password2 = userAccount.getPassword();
				if (username.equals(userName2) && password == password2) {
					ATMMachinePoint atmMachinePoint = userAccount.getAtmMachinePoint();
					ATMMachinePoint loggedInUSerData = loggedInUSerData(atmMachinePoint, scanner);
					userAccount.setAtmMachinePoint(loggedInUSerData);
				} else {
					System.out.println("enterd invalid credentials! please enter valid credentials");
					defalutMessage(scanner);
				}
			}

		}
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int options;
		UserAccount account = new UserAccount();
		while (true) {
			String username = "";
			int password;
			String saveAndUnSave = "";
			System.out.println("Welcome to the ATM Simulator");
			System.out.println("1. Login");
			System.out.println("2. Create your Account");
			System.out.println("3. contact us");
//			System.out.println("4. Exit");
			System.out.print("Choose an option: ");
			options = scanner.nextInt();

			switch (options) {
			case 1:
				System.out.println("ENTER USERNAME");
				username = scanner.next();

				System.out.println("ENTER PASSWORD");
				password = scanner.nextInt();

				this.login(username, password, scanner);

				break;
			case 2:
				System.out.println("ENTER USERNAME");
				username = scanner.next();
				account.setUserName(username);

				System.out.println("ENTER ACCOUNT NUMBER");
				String accountNumber = scanner.next();
				account.setAccountNumber(accountNumber);

				System.out.println("ENTER PASSWORD");
				password = scanner.nextInt();
				account.setPassword((long) password);

				System.out.println("ENTER CONFIRM PASSWORD");
				int confirmPassword = scanner.nextInt();
				account.setConfirmPassword((long) confirmPassword);

				System.out.println("ENTER Y to save and N clear the data");
				saveAndUnSave = scanner.next();
				switch (saveAndUnSave.toLowerCase()) {
				case "y":
					account.setAtmMachinePoint(new ATMMachinePoint());
					accountsArray[newUsersAddedList] = account;
					newUsersAddedList++;
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
			case 3:
				System.out.println("Please visit nearest branch at your location for better convinence");
				defalutMessage(scanner);
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	public void defalutMessage(Scanner scanner) {
		do {
			System.out.println("     click 1 to go to Main Menu     ");
		} while (scanner.nextInt() != 1);
	}

	public static void main(String[] args) {
		ATMCenter atm = new ATMCenter();
		atm.menu();
	}
}

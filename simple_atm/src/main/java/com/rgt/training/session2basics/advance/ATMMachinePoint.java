package com.rgt.training.session2basics.advance;

public class ATMMachinePoint {
	private double balance;
	private double[] transactions;
	private int transactionCount;

	public ATMMachinePoint() {
		balance = 0;
		transactions = new double[100];
		transactionCount = 0;
	}

	public double checkBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			transactions[transactionCount++] = amount;
			System.out.println("Deposit successful!");
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient balance.");
		} else if (amount <= 0) {
			System.out.println("Invalid withdrawal amount.");
		} else {
			balance -= amount;
			transactions[transactionCount++] = -amount;
			System.out.println("Withdrawal successful!");
		}
	}

	public void showTransactionHistory() {
		System.out.println("Transaction History:");
		for (int i = 0; i < transactionCount; i++) {
			if (transactions[i] > 0) {
				System.out.println("Deposit: $" + transactions[i]);
			} else {
				System.out.println("Withdraw: $" + (-transactions[i]));
			}
		}
	}
}
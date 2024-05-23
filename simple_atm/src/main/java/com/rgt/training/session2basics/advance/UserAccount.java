package com.rgt.training.session2basics.advance;

public class UserAccount {
	private String userName;
	private String accountNumber;
	private Long password;
	private Long confirmPassword;
	private ATMMachinePoint atmMachinePoint;

	public UserAccount() {
		super();
	}

	public UserAccount(String username) {
		userName = username;
	}

	public UserAccount(String userName, String accountNumber, Long password, Long confirmPassword,ATMMachinePoint atmMachinePoint) {
		super();
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.atmMachinePoint = atmMachinePoint;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getPassword() {
		return password;
	}

	public void setPassword(Long password) {
		this.password = password;
	}

	public Long getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(Long confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public ATMMachinePoint getAtmMachinePoint() {
		return atmMachinePoint;
	}

	public void setAtmMachinePoint(ATMMachinePoint atmMachinePoint) {
		this.atmMachinePoint = atmMachinePoint;
	}

	public void clear() {
		userName = "";
		accountNumber = "";
		password = 0L;
		confirmPassword = 0L;
	}
}
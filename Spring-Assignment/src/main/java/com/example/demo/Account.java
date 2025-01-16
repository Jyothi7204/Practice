package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Account {

	 @Id
	    private String accountNumber;
	    private String currency;
	    private String bank;
	    private String branch;

	    // Getters and Setters
	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public void setAccountNumber(String accountNumber) {
	        this.accountNumber = accountNumber;
	    }

	    public String getCurrency() {
	        return currency;
	    }

	    public void setCurrency(String currency) {
	        this.currency = currency;
	    }

	    public String getBank() {
	        return bank;
	    }

	    public void setBank(String bank) {
	        this.bank = bank;
	    }

	    public String getBranch() {
	        return branch;
	    }

	    public void setBranch(String branch) {
	        this.branch = branch;
	    }
	}

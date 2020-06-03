package com.java.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class AccountBean {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Integer account_number; 
	private String account_name;
	private String account_type;
	private Date balance_date;
	private String currency;
	private BigDecimal opening_available_balance;
	
	public Integer getAccount_number() {
		return account_number;
	}
	public void setAccount_number(Integer account_number) {
		this.account_number = account_number;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public Date getBalance_date() {
		return balance_date;
	}
	public void setBalance_date(Date balance_date) {
		this.balance_date = balance_date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getOpening_available_balance() {
		return opening_available_balance;
	}
	public void setOpening_available_balance(BigDecimal opening_available_balance) {
		this.opening_available_balance = opening_available_balance;
	}

}

package com.java.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "account_id")
	private Integer account_id;
	
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	@Column(name = "account_number")
	private Integer account_number;
	
	@Column(name = "account_name")
	private String account_name;
	
	@Column(name = "account_type")
	private String account_type;
	
	@Column(name = "balance_date")
	private Date balance_date;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "opening_available_balance")
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

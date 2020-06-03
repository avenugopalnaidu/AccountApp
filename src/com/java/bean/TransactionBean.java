package com.java.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class TransactionBean {
	private Integer id;
	private Integer account_number; 
	private String account_name;
	private Date value_date;
	private String currency;
	private BigDecimal debit_ammount;
	private BigDecimal credit_ammount;
	private String debitcredit;
	private String transaction_narrative;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Date getValue_date() {
		return value_date;
	}
	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getDebit_ammount() {
		return debit_ammount;
	}
	public void setDebit_ammount(BigDecimal debit_ammount) {
		this.debit_ammount = debit_ammount;
	}
	public BigDecimal getCredit_ammount() {
		return credit_ammount;
	}
	public void setCredit_ammount(BigDecimal credit_ammount) {
		this.credit_ammount = credit_ammount;
	}
	public String getDebitcredit() {
		return debitcredit;
	}
	public void setDebitcredit(String debitcredit) {
		this.debitcredit = debitcredit;
	}
	public String getTransaction_narrative() {
		return transaction_narrative;
	}
	public void setTransaction_narrative(String transaction_narrative) {
		this.transaction_narrative = transaction_narrative;
	}
	
	
}

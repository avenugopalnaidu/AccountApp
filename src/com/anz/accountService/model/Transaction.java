package com.anz.accountService.model;

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
@Table(name="Transaction")
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	
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
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "account_number")
	private Integer account_number; 
	@Column(name = "account_name")
	private String account_name;
	@Column(name = "value_date")
	private Date value_date;
	@Column(name = "currency")
	private String currency;
	@Column(name = "debit_ammount")
	private BigDecimal debit_ammount;
	@Column(name = "credit_ammount")
	private BigDecimal credit_ammount;
	@Column(name = "debitcredit")
	private String debitcredit;
	@Column(name = "transaction_narrative")
	private String transaction_narrative;


}

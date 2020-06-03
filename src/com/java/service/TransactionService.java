package com.java.service;

import java.util.List;

import com.java.model.Transaction;


public interface TransactionService {

	
public List<Transaction> listAccountTransaction();
	
	public Transaction getAccount(int account_id);
}

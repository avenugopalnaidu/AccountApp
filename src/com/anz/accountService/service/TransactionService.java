package com.anz.accountService.service;

import java.util.List;

import com.anz.accountService.model.Transaction;


public interface TransactionService {

	
public List<Transaction> listAccountTransaction();
	
	public Transaction getAccount(int account_id);
}

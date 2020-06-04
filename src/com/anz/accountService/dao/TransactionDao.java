package com.anz.accountService.dao;

import java.util.List;

import com.anz.accountService.model.Account;
import com.anz.accountService.model.Transaction;

public interface TransactionDao {

public List<Transaction> listAccountTransaction();
	
	public Transaction getAccount(int account_id);
	

}

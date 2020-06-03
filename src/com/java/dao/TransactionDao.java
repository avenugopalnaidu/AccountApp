package com.java.dao;

import java.util.List;

import com.java.model.Account;
import com.java.model.Transaction;

public interface TransactionDao {

public List<Transaction> listAccountTransaction();
	
	public Transaction getAccount(int account_id);
	

}

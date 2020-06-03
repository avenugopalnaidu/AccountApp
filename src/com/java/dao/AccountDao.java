package com.java.dao;

import java.util.List;

import com.java.model.Account;

public interface AccountDao {
	
		public List<Account> listAccounts();
	
	public Account getAccount(int account_id);
	
	}

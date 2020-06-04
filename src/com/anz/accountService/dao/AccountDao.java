package com.anz.accountService.dao;

import java.util.List;

import com.anz.accountService.model.Account;

public interface AccountDao {
	
		public List<Account> listAccounts();
	
	public Account getAccount(int account_id);
	
	}

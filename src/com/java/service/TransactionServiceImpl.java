package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.TransactionDao;
import com.java.model.Transaction;

@Service("accountTransactionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionDao accountTransactionDao;
	
	
	
	public List<Transaction> listAccountTransaction() {
		System.out.println("service class");
		return accountTransactionDao.listAccountTransaction();
	}

	public Transaction getAccount(int account_id) {
		return accountTransactionDao.getAccount(account_id);
	}
}

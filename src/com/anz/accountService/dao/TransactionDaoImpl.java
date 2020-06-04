package com.anz.accountService.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anz.accountService.model.Transaction;

@Repository("accountTransactionDao")
public class TransactionDaoImpl implements TransactionDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@SuppressWarnings("unchecked")
	public List<Transaction> listAccountTransaction() {
		return (List<Transaction>) sessionFactory.getCurrentSession().createCriteria(Transaction.class).list();
	}

	public Transaction getAccount(int account_id) {
		return (Transaction) sessionFactory.getCurrentSession().get(Transaction.class, account_id);
	}

}

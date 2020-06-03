package com.java.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.model.Transaction;

@Repository("accountTransactionDao")
public class TransactionDaoImpl implements TransactionDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@SuppressWarnings("unchecked")
	public List<Transaction> listAccountTransaction() {
		System.out.println("enter into dao");
		return (List<Transaction>) sessionFactory.getCurrentSession().createCriteria(Transaction.class).list();
	}

	public Transaction getAccount(int account_id) {
		return (Transaction) sessionFactory.getCurrentSession().get(Transaction.class, account_id);
	}

}

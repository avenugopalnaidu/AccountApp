package com.java.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.model.Account;




@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	

	@SuppressWarnings("unchecked")
	public List<Account> listAccounts() {
		return (List<Account>) sessionFactory.getCurrentSession().createCriteria(Account.class).list();
	}

	public Account getAccount(int account_id) {
		return (Account) sessionFactory.getCurrentSession().get(Account.class, account_id);
	}

	
}

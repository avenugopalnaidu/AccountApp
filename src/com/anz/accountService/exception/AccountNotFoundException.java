package com.anz.accountService.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Account Not Found") //404
	public class AccountNotFoundException extends Exception {

		private static final long serialVersionUID = -3332292346834265371L;

		public AccountNotFoundException(int id){
			super("AccountNotFoundException with id="+id);
		}

}

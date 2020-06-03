package com.java.exception;
	import org.springframework.web.bind.annotation.ResponseStatus;
	import org.springframework.http.HttpStatus;

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Account Transaction Not Found") //404
		public class TransactionNotFoundException extends Exception {

			private static final long serialVersionUID = -3332292346834265371L;

			public TransactionNotFoundException(int id){
				super("TransactionNotFoundException with id="+id);
			}

	}



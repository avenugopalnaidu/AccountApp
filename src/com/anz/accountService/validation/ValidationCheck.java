package com.anz.accountService.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.anz.accountService.bean.AccountBean;
import com.anz.accountService.controller.AccountController;

public class ValidationCheck {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	
@Autowired
AccountBean accountBean;
	
	public boolean validateAccountNumber() {
	
		
		
		/*String sampleString =accountBean.account_number.toString() ;
		String[] stringArray = sampleString.split("");
	      int[] intArray = new int[stringArray.length];
	      int totalCount = 0;
	    //Check Digit Formula = 9 – (Total Modulus 11 / Total%11) 
	      int digitFormula = 9 - (totalCount % 11);
	      logger.info("digitFormula: " + digitFormula);
	      int lastNumber = intArray[intArray.length-1];
	      logger.info("lastNumber: " + lastNumber);
	      if(digitFormula == lastNumber){
	    	  logger.info("success");
	      }
	      */
	      
		Pattern pattern=Pattern.compile("^[0-9]{9-18}$)");
		Matcher matcher=pattern.matcher(accountBean.account_number.toString());
		
		if(matcher.matches()) {
			logger.info("is valid account number");
		}
		else {
			logger.info("is invalid account number");

		}
		return true;
		
	}
	
	public boolean validateAccountId() {
		
		String regex = "[+-]?[0-9][0-9]*"; 
        
        // compiling regex 
        Pattern p = Pattern.compile(regex); 
          
        
        Matcher m = p.matcher(accountBean.id.toString()); 
          
        // If match found and equal to input1 
        if(m.find() && m.group().equals(accountBean.id.toString())) 
        	logger.info(accountBean.id.toString() + " is a valid number"); 
        else
        	logger.info(accountBean.id.toString() + " is not a valid number"); 
        
		return true;
		
	}
		
	

}

package com.nitya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitya.entity.Bank;
import com.nitya.entity.Bank.Accountstatus;
import com.nitya.repo.BankRepository;
@Service
public class BankService  implements BankserviceInterface{
	@Autowired
	private BankRepository repo;

	@Override
	public Bank Accountcreate(Bank bank) {
	Bank bank2	= repo.save(bank);
		return bank2;
	}

	@Override
	public Bank Balancecheck(Bank bank) 
		{
     String account = bank.getAccountNumber();
     String name   = bank.getName();
     String password = bank.getPassword();
     Bank  bank2  = repo.findById(account).get();
     if(bank2.getAccountNumber().equals(account)&& bank2.getName().equals(name)&& bank2.getPassword().equals(password)&&bank2.getStatus()==Accountstatus.active)
    		 {
    	 return bank2;
    		 }
     else {
	return null; 
	  
}

}

	@Override
	public Bank deposit(Bank bank) {
		String account = bank.getAccountNumber();
		String name   = bank.getName();
		String password = bank.getPassword(); 
		double Amount = bank.getAmount();
		double totalAmount=0.0;
		     Bank  bank2  = repo.findById(account).get();
		     
		     if(bank2.getAccountNumber().equals(account)&& bank2.getName().equals(name)&& bank2.getPassword().equals(password)&&bank2.getStatus()==Accountstatus.active)
    		 {
		    	 
		    	 totalAmount = Amount + bank2.getAmount(); 
		    	 bank2.setAmount(totalAmount);
		    	 repo.save(bank2);
		    	 return bank2;
    		 }
		     else
		     {
		    	 return null;
		     }
	
	}

	@Override
	public Bank withdraw(Bank bank) {
		String account = bank.getAccountNumber();
		String name   = bank.getName();
		String password = bank.getPassword();
		double Amount = bank.getAmount();
		double totalAmount=0.0;
		     Bank  bank2  = repo.findById(account).get();
		     
		     if(bank2.getAccountNumber().equals(account)&& bank2.getName().equals(name)&& bank2.getPassword().equals(password)&&Amount<bank2.getAmount()&&bank2.getStatus()==Accountstatus.active)
    		 {
		    	 
		    	 totalAmount = bank2.getAmount()- Amount; 
		    	 bank2.setAmount(totalAmount);
		    	 repo.save(bank2);
		    	 return bank2;
    		 }
		     else
		     {
		    	 return null;  
		     }

	}

	@Override
	public Bank transfer(Bank bank,String accountNumber) {
		String account = bank.getAccountNumber();
		String name   = bank.getName();
		String password = bank.getPassword();   
		String taccount = accountNumber;
		
		double Amount = bank.getAmount();
		double totalAmount=0.0;    
		double Afterdeposit =0.0;
		
	  Bank bank2	= repo.findById(account).get();
	  Bank target =repo.findById(taccount).get();   
//	  if (bank2.getAccountNumber().equals(account)&&bank2.getName().equals(name)&&bank2.getPassword().equals(password)&&Amount<bank2.getAmount()&&target.getAccountNumber().equals(taccount)&&
//			  bank2.getStatus()==Accountstatus.active&&target.getStatus()==Accountstatus.inactive) {
		
	
   if(bank2.getAccountNumber().equals(account)&& bank2.getName().equals(name)&& bank2.getPassword().
			   equals(password)&&Amount<bank2.getAmount()&&target.getAccountNumber().equals(taccount)&&bank2.getStatus()==Accountstatus.
			   active&&target.getStatus()==Accountstatus.active)	
	   {
		   
		   //withdraw
		   totalAmount = bank2.getAmount()-Amount;
		   bank2.setAmount(totalAmount);    
		   repo.save(bank2);  
		  
		   // deposit
		   Afterdeposit = target.getAmount()+Amount;
		   target.setAmount(Afterdeposit);
		   repo.save(target);  
		  System.out.println(bank2);  
		  System.out.println(target);
		   
		   return bank2;  
	   }
		   return  target;              
	   }
	   
	        
 
//==================================close account========================

	@Override
	public Bank close(Bank bank) {
		String account = bank.getAccountNumber();
		String name   = bank.getName();    
		String password = bank.getPassword();
        Bank bank2 =repo.findById(account).get();    
		   if(bank2.getAccountNumber().equals(account)&& bank2.getName().equals(name)&& bank2.getPassword().equals(password))
		   {
			  bank2.setStatus(Accountstatus.inactive);  
			  repo.save(bank2);
			  return bank2;  
	
		   }    
  else {
     return null;   
	  }
 }
      
}

package com.nitya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitya.entity.Bank;
import com.nitya.service.BankserviceInterface;

@RestController
@CrossOrigin(origins = "*")
public class Bankcontroller {
	
	@Autowired
	private BankserviceInterface service;
	
	@PostMapping("/save")
	public String Banksave(@RequestBody Bank bank )
	{
	Bank bank2	 = service.Accountcreate(bank);
	String message =null;
	if(bank2!=null)
	{
		message = "account created successfully";
	}
	else {
		message ="Account not created";
	}
		return message;
		
	}
	
	@GetMapping("/balance")
	public Bank balancefrom( @RequestBody Bank bank)
	{
	Bank bank2	 = service.Balancecheck(bank);

	if(bank2!=null)
	{
			
	
		return bank2;
	}
	else {

		return  null ;
	}
	
	}
//===========================================deposit=================
@GetMapping("/deposit")
public Bank deposit(@RequestBody Bank bank)
{
Bank data	  = service.deposit(bank);
if(data!=null)
{
	

	return data;
	}
else
{
	return null;
	}
}

//============================================WITHDRAW=========================

@GetMapping("/withdraw")
public Bank withdraw(@RequestBody Bank bank)
{
Bank data	  = service.withdraw(bank);
if(data!=null)
{
	
	return data;
	}
else
{
	return null;
	}
}

//=======================Transfer===================================
@GetMapping("/transfer/{accountNumber}")
public Bank transfer(@RequestBody Bank bank,@PathVariable String accountNumber)
{
Bank bank2	 = service.transfer(bank,accountNumber);
if(bank2!=null)
{
	return bank2;
	
	}
else {

	return null;
	
	}


}

//======================================close account====================
@GetMapping("/close")
public Bank close(@RequestBody Bank bank)
{
Bank  data	 = service.close(bank);

if(data!=null)
{  
	
	
	return data;
	}
else
{
	return null;
}

}


}

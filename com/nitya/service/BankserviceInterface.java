package com.nitya.service;

import com.nitya.entity.Bank;

public interface BankserviceInterface {
	//public Bank Accountcreate(Bank bank);
	public Bank Balancecheck(Bank bank);
	public Bank deposit(Bank bank);
	public Bank withdraw(Bank bank);
	public Bank transfer(Bank bank ,String accountNumber);
	public Bank close(Bank bank);
	public Bank Accountcreate(Bank bank);

}

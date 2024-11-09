package com.org.bank.dao;

public interface TransactionDAO 
{

void withdraw(int account_id,double amount) throws Exception;
void transfer(int fromAccountId,int toAccountId,double amount) throws Exception;
void displayTransactionHistory(int accountid);
void deposit(int accountId, double amount) throws Exception;
}

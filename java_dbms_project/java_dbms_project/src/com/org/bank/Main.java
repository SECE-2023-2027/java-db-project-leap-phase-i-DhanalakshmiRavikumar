package com.org.bank;
import java.util.*;
import com.org.bank.dao.AccountDAO;
import com.org.bank.dao.AccountDaoImpl;
import com.org.bank.model.Account;
import com.org.bank.dao.TransactionDAO;
import com.org.bank.dao.TransactionDaoImpl;

public class Main
{
   public static void main(String[] arg) throws Exception
   { Scanner scanner = new Scanner(System.in);
   AccountDAO accountDAO = new AccountDaoImpl();
   TransactionDAO transactionDAO = new TransactionDaoImpl();
	   while(true)
	   {
		   
		   System.out.println("\n====Banking Application=====");
			System.out.println("1.Create new account");
			System.out.println("2.View Account details");
			System.out.println("3.Update account information");
			System.out.println("4.Deposit Money");
			System.out.println("5.Withdraw money");
			System.out.println("6.Transfer Money");
			System.out.println("7.View Transaction");
			System.out.println("8.Check Balance");
			System.out.println("9.Exit");
			System.out.println("Enter your choice");
			int c = scanner.nextInt();
			scanner.nextLine();
			switch(c)
			{
			case 1:
				System.out.println("Enter account holder name");
				String accountholder=scanner.nextLine();
				System.out.println("Enter account type (savings/current):");
				String accountType=scanner.nextLine();
				System.out.println("Enter initial balance");
				double balance = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter address");
				String address=scanner.nextLine();
				System.out.println("Enter contact number");
				String contactNumber=scanner.nextLine();
				Account newAccount = new Account(0,accountholder,accountType,balance,address,contactNumber);
				try
				{
					accountDAO.createAccount(newAccount);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
			case 2:
				
				System.out.println("Enter account ID to view : ");
				int viewAccountId = scanner.nextInt();
				Account retrievedAccount = accountDAO.viewAccount(viewAccountId);
				if(retrievedAccount!= null)
				{
					System.out.println("Account Details: "+retrievedAccount);
				}
				else
				{
					System.out.println("Account not found.");
				}
				break;
			case 3:
				System.out.println("Enter account ID to update: ");
				int updateAccountId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter new address: ");
				String newAddress=scanner.nextLine();
				System.out.println("Enter new contact number: ");
				String newContact =scanner.nextLine();
				accountDAO.updateAccountinfo(updateAccountId, newAddress, newContact);
				break;	
			case 4:
				System.out.println("Enter account ID deposit into :");
				int depositAccountId = scanner.nextInt();
				System.out.println("Enter the amount to deposit : ");
				double depositAmount = scanner.nextDouble();
				transactionDAO.deposit(depositAccountId,depositAmount);
				break;
				
				
	   }
   }
}
}

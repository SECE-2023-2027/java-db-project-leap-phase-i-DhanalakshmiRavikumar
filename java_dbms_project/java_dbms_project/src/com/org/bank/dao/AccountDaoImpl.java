package com.org.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.org.bank.model.Account;
import com.org.bank.utils.DatabaseConnection;

public class AccountDaoImpl implements AccountDAO
{

	@Override
	public void createAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Account(account_holder,account_type,balance,address,contact_number) VALUES(?,?,?,?,?)";
	    try(Connection conn =DatabaseConnection.getConnection();
	    		PreparedStatement statement = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS))
	    {
	    	statement.setString(1, account.getAccountholder());
	    	statement.setString(2,account.getAccountType());
	    	statement.setDouble(3,account.getBalance());
	    	statement.setString(4, account.getAddress());
	    	statement.setString(5,account.getContactNumber());
	    	int affectedRows=statement.executeUpdate();
	    	if(affectedRows>0)
	    	{
	    		ResultSet generatedKeys= statement.getGeneratedKeys();
	    		if(generatedKeys.next())
	    		{
	    			int accountId=generatedKeys.getInt(1);
	    			if(account.getAccountType().equals("Savings"))
	    			{
	    				String sqlsavingaccount = "INSERT INTO SavingsAccount(account_id,interest_rate)VALUES(?, ?)";
	    				PreparedStatement stmtSaving = conn.prepareStatement(sqlsavingaccount);
	    				stmtSaving.setInt(1,accountId);
	    				stmtSaving.setDouble(2,0.4);
	    				stmtSaving.executeUpdate();
	    			}
	    			else if(account.getAccountType().equals("Current"))
	    			{
	    				String sqlCurrentAccount = "INSERT INTO CurrentAccount(account_id,overdraft_limit)VALUES(?, ?)";
	    				PreparedStatement stmtCurrent = conn.prepareStatement(sqlCurrentAccount);
	    				stmtCurrent.setInt(1,accountId);
	    				stmtCurrent.setDouble(2,5000.00);
	    				stmtCurrent.executeUpdate();
	    			}
	    		}
	    	}
	    }
	    System.out.println("Account created sucessfully.");
	    
	}

	@Override
	public Account viewAccount(int accountId) throws Exception
	{
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM Account WHERE account_id = ?";
		Account account = null;
		try(Connection conn =DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setInt(1, accountId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				account = new Account(
						rs.getInt("account_id"),
						rs.getString("account_holder"),
						rs.getString("account_type"),
						rs.getDouble("balance"),
						rs.getString("address"),
						rs.getString("Contact_number")
						);
			}
			if(account!=null)
			{
				System.out.println("Account details retrieved sucessfully");
			}
			else
			{
				System.out.println("Account not found");
			}
		}
		
		return null;
	}

	@Override
	public void updateAccountinfo(int accountId, String newAddress, String newContact) throws Exception
	{
		// TODO Auto-generated method stub
		String sql="UPDATE Account SET address = ?, contact_number= ? WHERE account_id= ?";
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql))
				{
			stmt.setString(1, newAddress);
			stmt.setString(2, newContact);
			stmt.setInt(3, accountId);
			int rowsAffected =stmt.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Account information update successfully.");
			}
			else
			{
				System.out.println("Account not found or update failed.");
			}
				}
		
	}

	@Override
	public void getbalance(int accountId) throws Exception 
	{
		// TODO Auto-generated method stub
		String sql="SELECT balance FROM Account where id = ? ";
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql))
		{
			
		}
		
	}

}

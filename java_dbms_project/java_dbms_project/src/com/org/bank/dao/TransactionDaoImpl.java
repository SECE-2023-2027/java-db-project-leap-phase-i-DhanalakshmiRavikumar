package com.org.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.bank.utils.DatabaseConnection;

public class TransactionDaoImpl implements TransactionDAO
{

	@Override
	public  void deposit(int accountId, double amount) throws Exception 
	{
		// TODO Auto-generated method stub
		String sql="UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE ACCOUNT_UD=?";
		try(Connection connection=DatabaseConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement(sql)
				)
		{
			String updateBalanceQuery="UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE ACCOUNT_UD=?";
			String insertTransactionQuery="INSERT INTO TRANSACTION(ACCOUNT_ID,TRANSACTION_TYPE,ANIYBT) VALUES(?,'Deposit',?)";
			executeTransaction(connection,accountId,amount,updateBalanceQuery,insertTransactionQuery);
			System.out.println("Deposite of $"+amount+ "to contact"+accountId+"completed");
			
		}	
		
	}

	@Override
	public void withdraw(int account_id, double amount) throws Exception
	{
		// TODO Auto-generated method stub
		try(Connection conn = DatabaseConnection.getConnection())
		{
			conn.setAutoCommit(false);
			String accountType = getAccountType(conn,account_id);
			double currentbalance= getcurrentBalanace(conn,account_id);
			if(accountType.equals("Current"))
			{
				double overdraftlimit = getOverdraftLimit(conn,account_id);
				if(amount>=overdraftlimit)
				{
					throw new Exception("Insufficent Balance or overdraft limit for withdraw");
				}
			}
			if(amount>currentbalance)
			{
				throw new Exception("Insufficent Balance for withdraw");
			}
			String updateBalanceQuery="UPDATE Account SET balance=balance -? where account_id=?";
			String insertTransactionQuery="INSERT INTO Transaction(account_id,transaction_type,amount)VALUE(?,'withdrawal'?)";
		    executeTransaction(conn,account_id,amount,updateBalanceQuery,insertTransactionQuery);
		    conn.commit();
		}
		
	}

	@Override
	public void transfer(int fromAccountId, int toAccountId, double amount) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTransactionHistory(int accountid)
	{
		// TODO Auto-generated method stub
		
	}
	private void executeUpdate(Connection conn, String query,double amount,int accountId) throws SQLException
	{
		try(PreparedStatement ps=conn.prepareStatement(query))
		{
			ps.setDouble(1, amount);
			ps.setInt(2,accountId);
			ps.executeUpdate();
		}
	}
	private  void executeTransaction(Connection conn,int accountId,double amount,String updateBalanceQuery,String insertTransactionQuery) throws SQLException
	{
		executeUpdate(conn,updateBalanceQuery,amount,accountId);
		try(PreparedStatement ps =conn.prepareStatement(insertTransactionQuery))
		{
			ps.setInt(1,accountId);
			ps.setDouble(2, amount);
			ps.executeUpdate();
		}
	}
	private double getcurrentBalanace(Connection conn, int accountId) throws SQLException
	{
		String checkBalanceQuery = "SELECT balance FROM Account where account_id=?";
		try(PreparedStatement ps =conn.prepareStatement(checkBalanceQuery))
		{
			ps.setInt(1, accountId);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				return rs.getDouble("balance");
			}
			else
			{
				throw new SQLException("not found");
			}
			
		}
	}
	private String getAccountType(Connection conn,int accountId) throws SQLException
	{
		String sql="SELECT account_type FROM Account WHERE account id=?";
		try(PreparedStatement stmt =conn.prepareStatement(sql))
		{
			stmt.setInt(1, accountId);
			ResultSet rs= stmt.executeQuery();
			if(rs.next())
			{
				return rs.getString("account_type");
			}
			else
			{
				throw new SQLException("Account not found");
			}
		}
	}
	private double getOverdraftLimit(Connection conn,int accountId) throws SQLException
	{
		String sql="SELECT overdraft_limit FROM Account WHERE account id=?";
		try(PreparedStatement stmt =conn.prepareStatement(sql))
		{
			stmt.setInt(1, accountId);
			ResultSet rs= stmt.executeQuery();
			if(rs.next())
			{
				return rs.getDouble("overdraft_limit");
			}
			else
			{
				throw new SQLException("Current account not found or overdraft limit not set ");
			}
	}
	}
	
	
	
    
}

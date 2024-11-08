package JAVA_PROJECT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_management
{
	private static final String URL="jdbc:mysql://localhost:3306/bank_management";
	private static final String USERNAME="root";
	private static final String PASSWORD="Dhana@13";
	public static Connection getConnection() {
		Connection connection=null;
		try{
			connection =DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Database Connected Successfully");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[]args) {
		getConnection();
	}

}

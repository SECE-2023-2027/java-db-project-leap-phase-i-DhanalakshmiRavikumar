package JAVA_PROJECT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Useroperation extends Database_management {
    
    public static void readUsers() {
        String sql = "SELECT * FROM customer";
        try (Connection connection = Database_management.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) 
        {
            
            while (resultSet.next())
            {
                int id = resultSet.getInt("c_id");
                String email = resultSet.getString("email");
                long phoneNo = resultSet.getLong("ph_no");
                String name = resultSet.getString("c_name");
                System.out.println("ID: " + id + ", Email: " + email + ", Phone Number: " + phoneNo + ", Name: " + name);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updateUser(int id, String newName, String newEmail, long phoneNo) 
    {
        String sql = "UPDATE customer SET c_name = ?, email = ?, ph_no = ? WHERE c_id = ?";
        try (Connection connection = Database_management.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) 
        {
            statement.setString(1, newName);
            statement.setString(2, newEmail);
            statement.setLong(3, phoneNo);
            statement.setInt(4, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User information updated successfully!");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id) 
    {
        String sql = "DELETE FROM customer WHERE c_id = ?";
        try (Connection connection = Database_management.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
            {
                System.out.println("User with ID: " + id + " has been deleted successfully");
            }
        } catch (SQLException e) 
        {
            
            e.printStackTrace();
        }
    }

    public static void insertUser(int id, String newName, String newEmail, long phoneNo) 
    {
        String sql = "INSERT INTO customer (c_id, c_name, email, ph_no) VALUES (?, ?, ?, ?)";
        try (Connection connection = Database_management.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) 
        {
            statement.setInt(1, id);
            statement.setString(2, newName);
            statement.setString(3, newEmail);
            statement.setLong(4, phoneNo);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) 
            {
                System.out.println("A new user has been inserted successfully!");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
       
        updateUser(4, "David Kumar", "davidkumar@gmail.com", 4444444444L);
        readUsers();
        deleteUser(1);
        readUsers();
        insertUser(1, "Alice", "alice@gmail.com", 1111111111L);
        readUsers();
        
    }
}

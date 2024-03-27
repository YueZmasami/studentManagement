package dao;

import entity.User;

import java.sql.*;

/**
 * @author: yue
 * @description:
 */
public class UserDao {

    private Connection conn = null;
// authentication
    public User checkAccount(String username, String password) throws Exception {
        initConnection();
        String sql = "SELECT * FROM User_Table WHERE Username = ? AND Password = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        // if match, return new user which will be stored in the session
        if (rs.next()) {
            user = new User();
            user.setUserID(rs.getInt("UserID"));
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("Password"));
            user.setFirstName(rs.getString("FirstName"));
            user.setLastName(rs.getString("LastName"));
            user.setPhone(rs.getString("Phone"));
            user.setRole(rs.getString("Role"));
        }
        closeConnection();
        return user;
    }
    // add new user
public void createNewUser(String Username, String Password, String FirstName, String LastName, String Phone, String Role) throws Exception{
    initConnection();
    String sql = "INSERT INTO User_Table (Username, Password, FirstName, LastName, Phone, Role) VALUES (?,?,?,?,?,?)";
    try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setString(1, Username);
        statement.setString(2, Password);
        statement.setString(3, FirstName);
        statement.setString(4, LastName);
        statement.setString(5, Phone);
        statement.setString(6, Role);
        statement.executeUpdate();
    }
    closeConnection();
}


    private void initConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_4assignment?useSSL=false", "root", "zhaiyue123");
    }

    private void closeConnection() throws Exception{
        conn.close();
    }

}

package hospital.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import hospital.model.Hospital;
import hospital.model.Users;

public class UsersDao {
	protected ConnectionManager connectionManager;
	
	private static UsersDao instance = null;
	
	protected UsersDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static UsersDao getInstance() {
		if(instance == null) {
			instance = new UsersDao();
		}
		return instance;
	}
	
	public Users create(Users user) throws SQLException {
		String insertUser = "INSERT INTO Users(UserName,Password,FirstName,LastName,Email,Phone) "
				+ "VALUES(?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser);
			insertStmt.setString(1, user.getUserName());
			insertStmt.setString(2, user.getPassword());
			insertStmt.setString(3, user.getFirstName());
			insertStmt.setString(4, user.getLastName());
			insertStmt.setString(5, user.getEmail());
			insertStmt.setString(6, user.getPhone());
			insertStmt.executeUpdate();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}
	
	public Users update(Users user) throws SQLException{
		String updateCompany = "UPDATE Users SET FirstName = ?, LastName = ?, Email = ?, Phone=?  WHERE UserId=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		String firstname = user.getFirstName();
		String lastname = user.getLastName();
		String email = user.getEmail();
		String phone = user.getPhone();
		int userid = user.getUserId();

		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateCompany);
			updateStmt.setString(1, firstname);
			updateStmt.setString(2, lastname);
			updateStmt.setString(3, email);
			updateStmt.setString(4, phone);
			updateStmt.setInt(5, userid);
			updateStmt.executeUpdate();
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	
	public Users getBlogUserFromUserName(String userName) throws SQLException {
		// To build an BlogUser object, we need the Persons record, too.
		String selectUser =
			"SELECT UserId, UserName, Password, FirstName, LastName, Email, Phone FROM Users WHERE UserName = ?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, userName);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int userid = results.getInt("UserId");
				String name = results.getString("UserName");
				String password = results.getString("Password");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String email = results.getString("Email");
				String Phone = results.getString("Phone");
				Users user = new Users(userid, name, password, firstName, lastName, email, Phone);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	
	public Users delete(Users user) throws SQLException {
		String deleteUser = "DELETE FROM Users WHERE UserName=?";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser);
			deleteStmt.setString(1, user.getUserName());
			deleteStmt.executeUpdate();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

	public boolean checkUser(String u, String p) throws SQLException {
		String checkuser="select * from users where UserName=? and Password=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(checkuser);
			selectStmt.setString(1, u);
			selectStmt.setString(2, p);
			results = selectStmt.executeQuery();
			if(results.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		
	}
	
	public boolean checkDuplicateUser(String u) throws SQLException {
		String checkuser="select * from users where UserName=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(checkuser);
			selectStmt.setString(1, u);
			results = selectStmt.executeQuery();
			if(results.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		
	}

}

package hospital.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hospital.model.Hospital;

public class HospitalDao {
	protected ConnectionManager connectionManager;
	
	private static HospitalDao instance = null;
	
	protected HospitalDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static HospitalDao getInstance() {
		if(instance == null) {
			instance = new HospitalDao();
		}
		return instance;
	}
	
	public Hospital create(Hospital hospital) throws SQLException {
		String insertHospital = "INSERT INTO Hospital(HospitalName, Address, City, State, Zip, Phone, EmergencyService, OverallRating, ListedHours) VALUES(?,?)";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertHospital, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, hospital.getHospitalName());
			insertStmt.setString(2, hospital.getAddress());
			insertStmt.setString(3, hospital.getCity());
			insertStmt.setString(4, hospital.getState());
			insertStmt.setInt(5, hospital.getZip());
			insertStmt.setString(6, hospital.getPhone());
			insertStmt.setBoolean(8, hospital.isEmergencyService());
			insertStmt.setDouble(9, hospital.getOverallRating());
			insertStmt.setString(10, hospital.getListofHours());
			insertStmt.executeUpdate();
			
			resultKey = insertStmt.getGeneratedKeys();
			int hospitalId = -1;
			if(resultKey.next()) {
				hospitalId = resultKey.getInt(1);
			}
			else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			hospital.setHospitalId(hospitalId);
			return hospital;
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
	
	public Hospital getHospitaByHospitalId(long hospitalId) throws SQLException {
		String selectHospital = "SELECT * FROM Hospital WHERE HospitalId=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHospital);
			selectStmt.setLong(1, hospitalId);
			results = selectStmt.executeQuery();
			if(results.next()) {
				long resultHospitalId = results.getLong("HospitalId");
				String hospitalName = results.getString("HospitalName");
				String address = results.getString("Address");
				String city = results.getString("City");
				String state = results.getString("State");
				int zip = results.getInt("Zip");
				String phone = results.getString("Phone");
				boolean emergencyService = results.getBoolean("EmergencyService");
				double overallRating = results.getDouble("OverallRating");
				String listofHours = results.getString("ListedHours");
				
				Hospital hospital = new Hospital(resultHospitalId, hospitalName, address, city, state, zip, phone, emergencyService, overallRating, listofHours);
				return hospital;
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
	
	public List<Hospital> getHospitaByState(String state) throws SQLException {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		String selectHospital = "SELECT * FROM Hospital WHERE State=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHospital);
			selectStmt.setString(1, state);
			results = selectStmt.executeQuery();
			while(results.next()) {
				long hospitalId = results.getLong("HospitalId");
				String hospitalName = results.getString("HospitalName");
				String address = results.getString("Address");
				String city = results.getString("City");
				int zip = results.getInt("Zip");
				String phone = results.getString("Phone");
				Boolean emergencyService = results.getBoolean("EmergencyService");
				double overallRating = results.getDouble("OverallRating");
				String listofHours = results.getString("ListedHours");
				Hospital hospital = new Hospital(hospitalId, hospitalName, address, city, state, zip, phone, emergencyService, overallRating, listofHours);
				hospitals.add(hospital);
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
		return hospitals;
	}
	
	public List<Hospital> getHospitaByCity(String city) throws SQLException {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		String selectHospital = "SELECT * FROM Hospital WHERE City=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHospital);
			selectStmt.setString(1, city);
			results = selectStmt.executeQuery();
			while(results.next()) {
				long hospitalId = results.getLong("HospitalId");
				String hospitalName = results.getString("HospitalName");
				String address = results.getString("Address");
				String state = results.getString("State");
				int zip = results.getInt("Zip");
				String phone = results.getString("Phone");
				Boolean emergencyService = results.getBoolean("EmergencyService");
				double overallRating = results.getDouble("OverallRating");
				String listofHours = results.getString("ListedHours");
				Hospital hospital = new Hospital(hospitalId, hospitalName, address, city, state, zip, phone, emergencyService, overallRating, listofHours);
				hospitals.add(hospital);
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
		return hospitals;
	}
}

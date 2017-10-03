package hospital.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import hospital.model.EmergencyCall;

public class EmergencyDao {
protected ConnectionManager connectionManager;
	
	private static EmergencyDao instance = null;
	
	protected EmergencyDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static EmergencyDao getInstance() {
		if(instance == null) {
			instance = new EmergencyDao();
		}
		return instance;
	}
	
	public void create(EmergencyCall call) throws SQLException {
		String insertemergency = "INSERT INTO EmergencyCall(Creattime,Recording,UserId,HospitalId,HospitalName) "
				+ "VALUES(?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertemergency);
			
			insertStmt.setTimestamp(1, new Timestamp(call.getCreattime().getTime()));
			insertStmt.setString(2, call.getRecording());
			insertStmt.setInt(3, call.getUserid());
			insertStmt.setLong(4, call.getHospitalid());
			insertStmt.setString(5, call.getHospitalName());
			insertStmt.executeUpdate();
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
	
}

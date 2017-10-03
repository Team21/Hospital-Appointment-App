package hospital.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import hospital.model.HealthReport;

public class HealthReportDao {
protected ConnectionManager connectionManager;
	
	private static HealthReportDao instance = null;
	
	protected HealthReportDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static HealthReportDao getInstance() {
		if(instance == null) {
			instance = new HealthReportDao();
		}
		return instance;
	}
	
	public void create(HealthReport hp) throws SQLException {
		String insertreport = "INSERT INTO HealthReport(ServiceDate,Description,UserId,DoctorId) "
				+ "VALUES(?,?,?,?)";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertreport);
			insertStmt.setTimestamp(1, new Timestamp(hp.getServicedate().getTime()));
			insertStmt.setString(2, hp.getDescription());
			insertStmt.setInt(3, hp.getUserid());
			insertStmt.setLong(4, hp.getDoctorid());
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
	
	public List<HealthReport> getHealthReportbyUserId(int userid) throws SQLException {
		List<HealthReport> healthreports = new LinkedList<HealthReport>();
		String selecthealthreport = "SELECT * FROM HealthReport WHERE UserId=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selecthealthreport);
			selectStmt.setInt(1, userid);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int reportid= results.getInt("ReportId");
				Date schedule = new Date(results.getTimestamp("ServiceDate").getTime());
				String description = results.getString("Description");
				int doctorid = results.getInt("DoctorId");
				
				HealthReport healthreport = new HealthReport(reportid, schedule, description, userid, doctorid);
				healthreports.add(healthreport);
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
		return healthreports;
	}
}

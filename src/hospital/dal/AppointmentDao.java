package hospital.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hospital.model.Appointment;
import hospital.model.Users;

public class AppointmentDao {
	protected ConnectionManager connectionManager;
	
	private static AppointmentDao instance = null;
	
	protected AppointmentDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static AppointmentDao getInstance() {
		if(instance == null) {
			instance = new AppointmentDao();
		}
		return instance;
	}
	
	public void create(Appointment appointment) throws SQLException {
		String insertappointment = "INSERT INTO APPOINTMENT(Scheduletime,Createtime,UserId,PatientName,Description,HospitalId,DoctorId,HospitalName) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertappointment);
			insertStmt.setTimestamp(1, new Timestamp(appointment.getScheduletime().getTime()));
			insertStmt.setTimestamp(2, new Timestamp(appointment.getCreattime().getTime()));
			insertStmt.setInt(3, appointment.getUserId());
			insertStmt.setString(4, appointment.getPatientName());
			insertStmt.setString(5, appointment.getDescription());
			insertStmt.setLong(6, appointment.getHospitalId());
			insertStmt.setLong(7, appointment.getDoctorId());
			insertStmt.setString(8, appointment.getHospitalName());
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
	
	public List<Appointment> getAppointmentbyUserId(int userid) throws SQLException {
		List<Appointment> appointments = new ArrayList<Appointment>();
		String selectappointment = "SELECT * FROM Appointment WHERE UserId=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectappointment);
			selectStmt.setInt(1, userid);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int appointmentid= results.getInt("AppointmentId");
				Date schedule = new Date(results.getTimestamp("Scheduletime").getTime());
				Date create = new Date(results.getTimestamp("Createtime").getTime());
				String description = results.getString("Description");
				long hospitalid = results.getLong("HospitalId");
				long doctorid = results.getLong("DoctorId");
				String hospitalname = results.getString("HospitalName");
				String patientname = results.getString("PatientName");
				
				Appointment appointment = new Appointment(appointmentid, schedule, create, userid, patientname, description, doctorid, hospitalid, hospitalname);
				appointments.add(appointment);
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
		return appointments;
	}
	
	public List<Appointment> getAppointmentbyDoctorId(long doctorid) throws SQLException {
		List<Appointment> appointments = new ArrayList<Appointment>();
		String selectappointment = "SELECT * FROM Appointment WHERE DoctorId=?";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectappointment);
			selectStmt.setLong(1, doctorid);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int appointmentid= results.getInt("AppointmentId");
				Date schedule = new Date(results.getTimestamp("Scheduletime").getTime());
				Date create = new Date(results.getTimestamp("Createtime").getTime());
				String description = results.getString("Description");
				long hospitalid = results.getLong("HospitalId");
				int userid = results.getInt("UserId");
				String hospitalname = results.getString("HospitalName");
				String patientname = results.getString("PatientName");
				
				Appointment appointment = new Appointment(appointmentid, schedule, create, userid, patientname, description, doctorid, hospitalid, hospitalname);
				appointments.add(appointment);
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
		return appointments;
	}
	
	public Appointment delete(int appointmentid) throws SQLException {
		String deleteappointment = "DELETE FROM Appointment WHERE AppointmentId=?";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteappointment);
			deleteStmt.setInt(1, appointmentid);
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

}

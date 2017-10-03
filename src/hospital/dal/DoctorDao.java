package hospital.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import hospital.model.Doctor;
import hospital.model.Hospital;
public class DoctorDao {
	
	protected ConnectionManager connectionManager;
	
	private static DoctorDao instance = null;
	
	protected DoctorDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static DoctorDao getInstance() {
		if(instance == null) {
			instance = new DoctorDao();
		}
		return instance;
	}
	
	public List<Doctor> getDoctorByHospitalId(long hospitalId) throws SQLException {
		List<Doctor> doctors = new LinkedList<Doctor>();
		String selectDoctor = "SELECT * FROM Doctor WHERE HospitalId=?";
		System.out.println(hospitalId);
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectDoctor);
			selectStmt.setLong(1, hospitalId);
			results = selectStmt.executeQuery();
			while(results.next()) {
				long resultDoctor= results.getLong("DoctorId");
				String ProfessionId = results.getString("ProfessionId");
				String Name = results.getString("DoctorName");
				String LastName = results.getString("LastName");
				String FirstName = results.getString("FirstName");
				String MiddleName = results.getString("MiddleName");
				String Gender = results.getString("Gender");
				String Specialty = results.getString("Specialty");
				String Phone = results.getString("Phone");
				long HospitalId = results.getLong("HospitalId");

				Doctor doctor = new Doctor(resultDoctor, ProfessionId, Name, LastName, FirstName, MiddleName, Gender, Specialty, Phone, HospitalId);
				doctors.add(doctor);
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
		return doctors;
	}
}

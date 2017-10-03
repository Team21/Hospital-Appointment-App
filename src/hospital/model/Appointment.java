package hospital.model;

import java.util.Date;

public class Appointment {
	protected int AppointmentId;
	protected Date Scheduletime;
	protected Date Creattime;
	protected int UserId;
	protected String PatientName;
	protected String Description;
	protected long DoctorId; 
	protected long HospitalId;
	protected String HospitalName;
	
	public Appointment(int appointmentId, Date scheduletime, Date creattime, int userId, String userName, String description, long doctorid,
			long hospitalId, String hospitalName) {
		super();
		AppointmentId = appointmentId;
		Scheduletime = scheduletime;
		Creattime = creattime;
		UserId = userId;
		PatientName = userName;
		Description = description;
		DoctorId = doctorid;
		HospitalId = hospitalId;
		HospitalName = hospitalName;
	}
	
	
	public String getPatientName() {
		return PatientName;
	}


	public void setPatientName(String userName) {
		PatientName = userName;
	}

	public String getHospitalName() {
		return HospitalName;
	}



	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
	}



	public int getAppointmentId() {
		return AppointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		AppointmentId = appointmentId;
	}

	public Date getScheduletime() {
		return Scheduletime;
	}

	public void setScheduletime(Date scheduletime) {
		Scheduletime = scheduletime;
	}

	public Date getCreattime() {
		return Creattime;
	}

	public void setCreattime(Date creattime) {
		Creattime = creattime;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public long getHospitalId() {
		return HospitalId;
	}

	public long getDoctorId() {
		return DoctorId;
	}


	public void setDoctorId(long doctorId) {
		DoctorId = doctorId;
	}


	public void setHospitalId(long hospitalId) {
		HospitalId = hospitalId;
	}
	
}

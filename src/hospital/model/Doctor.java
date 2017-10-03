package hospital.model;

public class Doctor {
	protected long doctorid;
	protected String profession;
	protected String Name;
	protected String LastName;
	protected String FirstName;
	protected String MiddleName;
	protected String Gender;
	protected String Specialty;
	protected String phone;
	protected long hospitalid;
	public long getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(long doctorid) {
		this.doctorid = doctorid;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getSpecialty() {
		return Specialty;
	}
	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(long hospitalid) {
		this.hospitalid = hospitalid;
	}
	public Doctor(long doctorid, String profession, String name, String lastName, String firstName, String middleName,
			String gender, String specialty, String phone, long hospitalid) {
		super();
		this.doctorid = doctorid;
		this.profession = profession;
		Name = name;
		LastName = lastName;
		FirstName = firstName;
		MiddleName = middleName;
		Gender = gender;
		Specialty = specialty;
		this.phone = phone;
		this.hospitalid = hospitalid;
	}
}

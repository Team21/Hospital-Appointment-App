package hospital.model;

public class Hospital {
	protected long hospitalId;
	protected String hospitalName;
	protected String address;
	protected String city;
	protected String state;
	protected int zip;
	protected String phone;
	protected Boolean emergencyService;
	protected double overallRating;
	protected String listedHours;

	public Hospital(long hospitalId, String hospitalName, String address, String city, String state, int zip, String phone, Boolean emergencyService, double overallRating, String listedHours) {
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.emergencyService = emergencyService;
		this.overallRating = overallRating;
		this.listedHours = listedHours;
	}

	public Hospital(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Hospital(String hospitalName, String address, String city, String state, int zip, String phone, String emergencyService2, Boolean emergencyService, double overallRating, String listedHours) {
		this.hospitalName = hospitalName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.emergencyService = emergencyService;
		this.overallRating = overallRating;
		this.listedHours = listedHours;
	}

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public Boolean isEmergencyService(){
		return emergencyService;
	}
	
	public void setEmergencyService(Boolean emergencyService){
		this.emergencyService = emergencyService;
	}
	
	public double getOverallRating(){
		return overallRating;
	}
	
	public void setOverallRating(double overallRating){
		this.overallRating = overallRating;
	}
	
	public String getListofHours(){
		return listedHours;
	}
	
	public void setListofHours(String listedHours){
		this.listedHours = listedHours;
	}
}

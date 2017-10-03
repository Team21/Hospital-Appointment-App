package hospital.model;

import java.util.Date;

public class EmergencyCall {
	protected int callid;
	protected Date creattime;
	protected String recording;
	protected int userid;
	protected long hospitalid;
	protected String hospitalName;
	
	
	public EmergencyCall(int callid, Date creattime, String recording, int userid, long hospitalid,
			String hospitalName) {
		super();
		this.callid = callid;
		this.creattime = creattime;
		this.recording = recording;
		this.userid = userid;
		this.hospitalid = hospitalid;
		this.hospitalName = hospitalName;
	}
	
	public int getCallid() {
		return callid;
	}
	public void setCallid(int callid) {
		this.callid = callid;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	public String getRecording() {
		return recording;
	}
	public void setRecording(String recording) {
		this.recording = recording;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public long getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(long hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	
	
}

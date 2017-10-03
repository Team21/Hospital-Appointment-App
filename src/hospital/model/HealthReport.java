package hospital.model;

import java.util.Date;

public class HealthReport {
	protected int reportid;
	protected Date servicedate;
	protected String description;
	protected int userid;
	protected long doctorid;
	
	public HealthReport(int reportid, Date servicedate, String description, int userid, long doctorid) {
		super();
		this.reportid = reportid;
		this.servicedate = servicedate;
		this.description = description;
		this.userid = userid;
		this.doctorid = doctorid;
	}
	
	public int getReportid() {
		return reportid;
	}
	
	public void setReportid(int reportid) {
		this.reportid = reportid;
	}
	
	public Date getServicedate() {
		return servicedate;
	}
	
	public void setServicedate(Date servicedate) {
		this.servicedate = servicedate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public long getDoctorid() {
		return doctorid;
	}
	
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
}

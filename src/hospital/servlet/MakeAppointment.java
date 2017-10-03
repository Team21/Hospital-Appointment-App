package hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import hospital.dal.AppointmentDao;
import hospital.dal.DoctorDao;
import hospital.dal.HospitalDao;
import hospital.model.Appointment;
import hospital.model.Doctor;
import hospital.model.Hospital;
import hospital.model.Users;

/**
 * Servlet implementation class MakeAppointment
 */
@WebServlet("/MakeAppointment")
public class MakeAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static AppointmentDao appointdao;
	protected static HospitalDao hospitaldao;
	protected static DoctorDao doctordao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
		appointdao = AppointmentDao.getInstance();
		hospitaldao = HospitalDao.getInstance();
		doctordao = DoctorDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		
		List<Doctor> doctors = new LinkedList<Doctor>();
		long hospitalid = (Long.parseLong(req.getParameter("hospitalid")));
		Hospital hospital = null;
		SimpleDateFormat sdf  =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		
		if(req.getParameter("type").equals("find")){
			try {
				hospital = hospitaldao.getHospitaByHospitalId(hospitalid);
				doctors = doctordao.getDoctorByHospitalId(hospitalid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.setAttribute("doctors", doctors);
			req.setAttribute("hospital", hospital);
		}else if(req.getParameter("type").equals("make")) {
			
			try {
				hospital = hospitaldao.getHospitaByHospitalId(hospitalid);
				doctors = doctordao.getDoctorByHospitalId(hospitalid);
				int appointmentid = 0;
				Date scheduletime = sdf.parse(req.getParameter("schedule"));
				Date create = new Date();
				Users sessionuser = (Users) req.getSession().getAttribute("loginUser");
			    int userid = sessionuser.getUserId();
			    String patientname = sessionuser.getUserName();
				String description = req.getParameter("description");
				long doctorid = (Long.parseLong(req.getParameter("doctorid")));
				String hospitalname = hospital.getHospitalName();
				Appointment appoint = new Appointment(appointmentid, scheduletime, create, userid, patientname, description, doctorid,
						hospitalid,hospitalname);
				
				appointdao.create(appoint);
				messages.put("success", "Successfully scheduled.");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.setAttribute("doctors", doctors);
			req.setAttribute("hospital", hospital);
		}
		
		req.getRequestDispatcher("/MakeAppointment.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

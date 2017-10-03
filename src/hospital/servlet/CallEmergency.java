package hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dal.EmergencyDao;
import hospital.dal.HospitalDao;
import hospital.model.EmergencyCall;
import hospital.model.Hospital;
import hospital.model.Users;

/**
 * Servlet implementation class EmergencyCall
 */
@WebServlet("/EmergencyCall")
public class CallEmergency extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static EmergencyDao emergencydao;
	protected static HospitalDao hospitaldao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallEmergency() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	emergencydao = EmergencyDao.getInstance();
    	hospitaldao = HospitalDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		try {
			Date create = new Date();
			String recording = "aaa";
			Users sessionuser = (Users) req.getSession().getAttribute("loginUser");
		    int userid = sessionuser.getUserId();
		    long hospitalid = (Long.parseLong(req.getParameter("hospitalid")));
		    Hospital hospital = hospitaldao.getHospitaByHospitalId(hospitalid);
		    String hospitalname = hospital.getHospitalName();
		    EmergencyCall emergencycall = new EmergencyCall(0, create, recording, userid, hospitalid, hospitalname);
		    emergencydao.create(emergencycall);
		    messages.put("success", "Call Successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/CallEmergency.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

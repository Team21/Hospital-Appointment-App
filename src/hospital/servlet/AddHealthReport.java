package hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dal.AppointmentDao;
import hospital.dal.HealthReportDao;
import hospital.model.Appointment;
import hospital.model.HealthReport;

/**
 * Servlet implementation class AddHealthReport
 */
@WebServlet("/AddHealthReport")
public class AddHealthReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected HealthReportDao healthdao;
    protected AppointmentDao appointmentdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHealthReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init() throws ServletException {
		healthdao = HealthReportDao.getInstance();
		appointmentdao = AppointmentDao.getInstance();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);
		
		List<Appointment> appointments = new ArrayList<Appointment>();
		int userid = (Integer.parseInt(request.getParameter("userid")));
		long doctorid = (Long.parseLong(request.getParameter("doctorid")));
		int appointmentid = (Integer.parseInt(request.getParameter("appointmentid")));
		String description = request.getParameter("description");
		Date servicedate = new Date();
		HealthReport hp = new HealthReport(1, servicedate, description, userid, doctorid);
		try {
			healthdao.create(hp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			appointmentdao.delete(appointmentid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			appointments = appointmentdao.getAppointmentbyDoctorId(doctorid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/DoctorMainPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

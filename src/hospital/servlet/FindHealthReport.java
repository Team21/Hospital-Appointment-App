package hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dal.HealthReportDao;
import hospital.dal.HospitalDao;
import hospital.dal.UsersDao;
import hospital.model.HealthReport;
import hospital.model.Hospital;
import hospital.model.Users;

/**
 * Servlet implementation class FindHospital
 */
@WebServlet("/FindHealthReport")
public class FindHealthReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected HealthReportDao healthreportdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindHealthReport() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@Override
	public void init() throws ServletException {
		healthreportdao = HealthReportDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<HealthReport> healthreports = new ArrayList<HealthReport>();
		try {
			Users sessionuser = (Users) req.getSession().getAttribute("loginUser");
		    int userid = sessionuser.getUserId();
			healthreports = healthreportdao.getHealthReportbyUserId(userid);
			System.out.println(healthreports.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("healthreports", healthreports);
        req.getRequestDispatcher("/HealthReport.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

package hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dal.HospitalDao;
import hospital.dal.UsersDao;
import hospital.model.Hospital;
import hospital.model.Users;

/**
 * Servlet implementation class FindHospital
 */
@WebServlet("/FindHospital")
public class FindHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected HospitalDao hospitaldao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindHospital() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@Override
	public void init() throws ServletException {
		hospitaldao = HospitalDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Hospital> hospitals = new ArrayList<Hospital>();

			String searchtype = req.getParameter("searchtype");

			if (searchtype.equals("HospitalId")) {

			} else if (searchtype.equals("HospitalName")) {

			} else if (searchtype.equals("State")) {
				String state = req.getParameter("searchvalue");
				hospitals = hospitaldao.getHospitaByState(state);
			} else if (searchtype.equals("City")){
				String city = req.getParameter("searchvalue");
				hospitals = hospitaldao.getHospitaByCity(city);
			}
			
			req.setAttribute("hospitals", hospitals);
	        req.getRequestDispatcher("/FindHospital.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

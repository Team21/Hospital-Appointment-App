package hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dal.AppointmentDao;
import hospital.model.Appointment;
import hospital.model.Users;

/**
 * Servlet implementation class ReviewAppointment
 */
@WebServlet("/ReviewAppointment")
public class ReviewAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected static AppointmentDao appointdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
		appointdao = AppointmentDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = new ArrayList<Appointment>();
		if(req.getParameter("type").equals("review")){
			Users user = (Users) req.getSession().getAttribute("loginUser");
			int userid = user.getUserId();
			try {
				appointments = appointdao.getAppointmentbyUserId(userid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.setAttribute("appointments", appointments);
			
		}else if(req.getParameter("type").equals("cancel")){
			int appointmentid = Integer.parseInt(req.getParameter("appointmentid"));
			try {
				appointdao.delete(appointmentid);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			Users user = (Users) req.getSession().getAttribute("loginUser");
			int userid = user.getUserId();
			try {
				appointments = appointdao.getAppointmentbyUserId(userid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			req.setAttribute("appointments", appointments);
		}

		req.getRequestDispatcher("/ReviewAppoint.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dal.UsersDao;
import hospital.model.Users;

/**
 * Servlet implementation class UserCreate
 */
@WebServlet("/UserCreate")
public class UserCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreate() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected UsersDao usersdao;
	
	@Override
	public void init() throws ServletException {
		usersdao = UsersDao.getInstance();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        //Just render the JSP.   
        request.getRequestDispatcher("/UserCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		// Retrieve and validate name.
		try {
			String userName = req.getParameter("username");
			if (userName == null || userName.trim().isEmpty()) {
				messages.put("success", "Invalid UserName");
			} else if (usersdao.checkDuplicateUser(userName)) {
				messages.put("success", "Duplicate UserName");
			} else {
				// Create the User.
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String firstname = req.getParameter("firstname");
				String lastName = req.getParameter("lastname");
				String email = req.getParameter("email");
				String phone = req.getParameter("phone");
				try {
					// Exercise: parse the input for StatusLevel.
					Users user = new Users(9999, username, password, firstname, lastName, email, phone);
					usersdao.create(user);
					messages.put("success", "Successfully created " + userName);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException(e);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
	}

}

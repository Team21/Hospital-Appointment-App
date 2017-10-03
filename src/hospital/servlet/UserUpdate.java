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
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected UsersDao userdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init() throws ServletException {
		userdao = UsersDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Users sessionuser = (Users) req.getSession().getAttribute("loginUser");
        int userid = sessionuser.getUserId();
        String username = sessionuser.getUserName();
        String password = sessionuser.getPassword();
        
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

		
        if(firstname.equals("")){
        	messages.put("success", "Please enter a firstname.");
        } else if (lastname.equals("")) {
        	messages.put("success", "Please enter a lastname.");
        } else if (email.equals("")) {
        	messages.put("success", "Please enter an email address.");
        } else if (phone.equals("")) {
        	messages.put("success", "Please enter an phone.");
        } else {
        	Users newuser = new Users(userid, username, password, firstname, lastname, email, phone);
            try {
     			userdao.update(newuser);
     			req.getSession().setAttribute("loginUser", newuser);
     	        messages.put("success", "Successfully updated " + username);
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        }
        
        req.getRequestDispatcher("/UserUpdate.jsp").forward(req, resp);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

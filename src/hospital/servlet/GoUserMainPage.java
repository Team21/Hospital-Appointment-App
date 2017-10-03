package hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dal.UsersDao;
import hospital.model.Users;

/**
 * Servlet implementation class GoUserMainPage
 */
@WebServlet("/GoUserMainPage")
public class GoUserMainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected UsersDao usersService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoUserMainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	public void init() throws ServletException {
		usersService = UsersDao.getInstance();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		
		String u=request.getParameter("name");
		String p=request.getParameter("passwd");
		
		try {
			if(usersService.checkUser(u, p)){
				Users loginUser = usersService.getBlogUserFromUserName(u);
				request.getSession().setAttribute("loginUser",loginUser);
				request.getRequestDispatcher("/UserInfo.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

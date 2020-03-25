package db;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String em=request.getParameter("email");
		String p=request.getParameter("pwd");
		session.setAttribute("benutzer", em);
		request.setAttribute("benutzer", em);
		request.setAttribute("password", p);
		RequestDispatcher d = request.getRequestDispatcher("success.jsp");
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("jpa");
		EntityManager manager = f.createEntityManager();
		
		try {
			DBManager.addUser(manager, em, p);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		d.forward(request,  response);
	}

}

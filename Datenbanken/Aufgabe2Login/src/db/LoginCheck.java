package db;

import java.io.IOException;

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
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
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
				
		EntityManagerFactory f = Persistence.createEntityManagerFactory("jpa");
        EntityManager manager=f.createEntityManager();

        RequestDispatcher d = request.getRequestDispatcher("success.jsp");
		if(!DBManager.userexists(manager, em, p)) {
			request.setAttribute("meldung", "E-Mail or Password is wrong!");
			d=request.getRequestDispatcher("index.jsp");
			response.sendRedirect("failure.jsp");
		}
		else {
		d.forward(request,  response);
		}
	}

}

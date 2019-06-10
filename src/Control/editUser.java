package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Reader;
import Service.UserService;

/**
 * Servlet implementation class editUser
 */
@WebServlet("/editUser")
public class editUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us=new UserService();
	Integer id;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id =Integer.parseInt( request.getParameter("editID"));
		ArrayList<Reader> readers = us.queryUser(id);
		request.setAttribute("readers", readers);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("Name");
		int age=Integer.valueOf(request.getParameter("Age"));	
		String tel=request.getParameter("Tel");
		us.updateUser(id, name, age, tel);
		response.sendRedirect("UserControl");
	}

}

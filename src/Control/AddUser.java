package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		UserService us=new UserService();
		String name=request.getParameter("Name");
		int age=Integer.valueOf(request.getParameter("Age"));	
		String tel=request.getParameter("Tel");
		us.insertUser(name, age, tel);
		//request.getRequestDispatcher("Index.jsp").forward(request,response);
		response.sendRedirect("UserControl"); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

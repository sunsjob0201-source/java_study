package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.MuttersDao;
import model.Mutter;

/**
 * Servlet implementation class EditMutter
 */
@WebServlet("/EditMutter")
public class EditMutter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id =
				Integer.parseInt(
						request.getParameter("id"));
		
		MuttersDao dao =
				new MuttersDao();
		
		Mutter mutter =
				dao.findById(id);
		
		request.setAttribute("mutter", mutter);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
						"WEB-INF/jsp/edit.jsp");
		
		dispatcher.forward(request, response);
	}
	
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
	        throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int id =
				Integer.parseInt(
						request.getParameter("id"));
		
		String text =
				request.getParameter("text");
		
		MuttersDao dao =
				new MuttersDao();
		
		dao.update(id, text);
		
		response.sendRedirect("Main");
		
		}
}

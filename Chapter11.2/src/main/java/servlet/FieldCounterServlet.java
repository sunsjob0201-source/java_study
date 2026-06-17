package servlet;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FieldCouterServlet
 */
@WebServlet("/FieldCounterServlet")
public class FieldCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Integer count;
   
   public void init(ServletConfig config) throws ServletException {
	   super.init(config);
	   //訪問回数を初期化
	   count = 0;
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//訪問回数を増加
		count++;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

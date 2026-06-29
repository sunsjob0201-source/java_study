package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.EjDict;
import model.EjDictLogic;

/**
 * Servlet implementation class EjDictServlet
 */
@WebServlet("/EjDictServlet")
public class EjDictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher(
				  "/WEB-INF/jsp/dictionary.jsp");
		  dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String word = request.getParameter("word");
		String maxCountStr = request.getParameter("maxCount");
	
		request.setAttribute("word", word);
		request.setAttribute("maxCount", maxCountStr);
		
		boolean hasError = false;
		
		if (word == null || word.isBlank()) {
			request.setAttribute("errorMsg", "検索する英単語を指定してください。");
			hasError = true;
		}
		
		int maxCount = 0;
		
	    if (maxCountStr == null || maxCountStr.isBlank()) {
		    request.setAttribute("errorMsg2", "最大検索件数を指定してください。");
		    hasError = true;
	    } else {
	    	try {
	    		maxCount = Integer.parseInt(maxCountStr);
	    		
	    		if (maxCount <= 0) {
	    			request.setAttribute("errorMsg2", "最大検索件数は1以上を指定してください。");
	    			hasError = true;
	    			
	        } 
	    		
	    	} catch (NumberFormatException e) {
	    		request.setAttribute("errorMsg2", "最大検索件数は数値で指定してください。");
	    		hasError = true;
	    	}
	    }
	    

	    if (!hasError) {
	    	EjDictLogic logic = new EjDictLogic();
	    	List<EjDict> ejDictList = logic.execute(word, maxCount);
	    	request.setAttribute("ejDictList", ejDictList);
	    }
	    
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/dictionary.jsp");
		dispatcher.forward(request, response);
	}
}
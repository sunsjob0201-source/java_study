package forwardServlet.java;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/ForwardServlet")
public class ForwardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     */
    public ForwardServlet() {
        super();
    }

    /**
     * GET
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
   //フォワード
//        RequestDispatcher dispatcher =
//                request.getRequestDispatcher(
//                        "/WEB-INF/jsp/forward.jsp");
//
//        dispatcher.forward(request, response);
    	 //リダイレクト
        response.sendRedirect("https://yahoo.co.jp");
    }

    /**
     * POST
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    //フォワード
//        RequestDispatcher dispatcher =
//                request.getRequestDispatcher(
//                        "/WEB-INF/jsp/forward.jsp");
//
//        dispatcher.forward(request, response);
        
     //リダイレクト
        response.sendRedirect("https://yahoo.co.jp");
    }
}
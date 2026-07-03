package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import dao.MutterDAO;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
@MultipartConfig

public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        MutterDAO dao = new MutterDAO();
        List<Mutter> mutterList = dao.findAll();
        
        getServletContext().setAttribute("mutterList", mutterList);
       

        HttpSession session = request.getSession();

        User loginUser =
                (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // 前回見た時刻を取得
        LocalDateTime lastReadTime =
                (LocalDateTime) session.getAttribute("lastReadTime");

        // JSPで使うためリクエストスコープに保存
        request.setAttribute("lastReadTime", lastReadTime);

        // 今回見た時刻をセッションスコープに保存
        session.setAttribute("lastReadTime", LocalDateTime.now());

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");

        dispatcher.forward(request, response);
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        User loginUser =
                (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String text = request.getParameter("text");
        
        Part imagePart = request.getPart("image");
        String imagePath = null;

        if (imagePart != null && imagePart.getSize() > 0) {
            String fileName = 
            		Paths.get(imagePart.getSubmittedFileName())
            		.getFileName()
            		.toString();
            
            String savedFileName =
            		System.currentTimeMillis() + "_" + fileName;

            String uploadPath =
                getServletContext().getRealPath("/upload");
            
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            imagePart.write(uploadPath + File.separator + savedFileName);

            imagePath = "upload/" + savedFileName;
        }
        
        if ((text != null && text.length() != 0) || imagePath != null) {
        	
        	Mutter mutter =
        			new Mutter(loginUser.getId(), loginUser.getName(), text);
        	
        	mutter.setImagePath(imagePath);
        	
        	PostMutterLogic postMutterLogic = new PostMutterLogic();
        	postMutterLogic.execute(mutter);
        	
        	response.sendRedirect("Main");
        	
        } else {
        	request.setAttribute(
        			"errorMsg",
        			"つぶやきまたは画像を入力してください");
        	
        	RequestDispatcher dispatcher =
        			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        	
        	dispatcher.forward(request, response);
        }
    }
}
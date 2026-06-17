package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext application = this.getServletContext();

        List<Mutter> mutterList =
                (List<Mutter>) application.getAttribute("mutterList");

        if (mutterList == null) {
            mutterList = new ArrayList<>();
            application.setAttribute("mutterList", mutterList);
        }

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

        String text = request.getParameter("text");

        ServletContext application = this.getServletContext();

        List<Mutter> mutterList =
                (List<Mutter>) application.getAttribute("mutterList");

        if (mutterList == null) {
            mutterList = new ArrayList<>();
            application.setAttribute("mutterList", mutterList);
        }

        HttpSession session = request.getSession();

        User loginUser =
                (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        if (text != null && text.length() != 0) {
            Mutter mutter =
                    new Mutter(loginUser.getName(), text);

            PostMutterLogic postMutterLogic =
                    new PostMutterLogic();

            postMutterLogic.execute(mutter, mutterList);

            response.sendRedirect("Main");
        } else {
            request.setAttribute(
                    "errorMsg",
                    "つぶやきが入力されていません");

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");

            dispatcher.forward(request, response);
        }
    }
}
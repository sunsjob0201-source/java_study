package servlet;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HumanServlet")
public class HumanServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public HumanServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // セッションスコープに保存するインスタンスの生成
        Human human = new Human("湊 雄輔", 23);

        // セッションスコープにインスタンスを保存
        request.setAttribute("human", human);

        // JSPへフォワード
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/WEB-INF/jsp/human.jsp");

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
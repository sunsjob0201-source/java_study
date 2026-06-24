package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.MuttersDao;
import model.User;

@WebServlet("/DeleteMutter")
public class DeleteMutter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        User loginUser =
                (User) request.getSession()
                        .getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String idStr =
                request.getParameter("id");

        if (idStr != null) {
            int id =
                    Integer.parseInt(idStr);

            MuttersDao dao =
                    new MuttersDao();

            dao.delete(id);
        }

        response.sendRedirect("Main");
    }
}
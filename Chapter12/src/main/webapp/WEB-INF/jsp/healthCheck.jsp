package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Health;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher =
            request.getRequestDispatcher(
                "/WEB-INF/jsp/healthCheck.jsp");

        dispatcher.forward(request, response);
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        double height =
            Double.parseDouble(
                request.getParameter("height"));

        double weight =
            Double.parseDouble(
                request.getParameter("weight"));

        double bmi =
            weight /
            Math.pow(height / 100, 2);

        String bodyType;

        if (bmi < 18.5) {
            bodyType = "やせ";
        } else if (bmi < 25) {
            bodyType = "普通";
        } else {
            bodyType = "肥満";
        }

        Health health =
            new Health(
                height,
                weight,
                bmi,
                bodyType);

        request.setAttribute(
            "health",
            health);

        RequestDispatcher dispatcher =
            request.getRequestDispatcher(
                "/WEB-INF/jsp/healthResult.jsp");

        dispatcher.forward(
            request,
            response);
    }
}
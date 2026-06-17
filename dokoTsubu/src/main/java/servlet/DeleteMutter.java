package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Mutter;
import model.User;

@WebServlet("/DeleteMutter")
public class DeleteMutter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        //ログインユーザーを取得
    	User loginUser =
    			(User) request.getSession().getAttribute("loginUser");
        // 削除する番号を取得
        String idStr = request.getParameter("id");
        
        if (idStr != null) {
            int id = Integer.parseInt(idStr);

            // アプリケーションスコープからつぶやきリストを取得
            List<Mutter> mutterList =
                (List<Mutter>) getServletContext().getAttribute("mutterList");

            // 範囲内なら削除
            if (mutterList != null) {
                mutterList.removeIf(mutter -> mutter.getId() == id &&
                		mutter.getUserName().equals(loginUser.getName()));
            }
        }

        // メイン画面に戻る
        response.sendRedirect("Main");
    }
}
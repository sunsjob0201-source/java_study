

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OlympicList")
public class OlympicList extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String season =
                request.getParameter("season");

        String year =
                request.getParameter("year");

        String city = "";

        if ("summer".equals(season)) {

            String[] years = {
                    "1948","1952","1956","1960",
                    "1964","1968","1972","1976",
                    "1980","1984","1988","1992",
                    "1996","2000","2004","2008",
                    "2012","2016","2020","2024"
            };

            String[] cities = {
                    "ロンドン","ヘルシンキ","メルボルン","ローマ",
                    "東京","メキシコシティ","ミュンヘン","モントリオール",
                    "モスクワ","ロサンゼルス","ソウル","バルセロナ",
                    "アトランタ","シドニー","アテネ","北京",
                    "ロンドン","リオデジャネイロ","東京","パリ"
            };

            for(int i = 0; i < years.length; i++) {
                if(years[i].equals(year)) {
                    city = cities[i];
                    break;
                }
            }

        } else {

            String[] years = {
                    "1948","1952","1956","1960",
                    "1964","1968","1972","1976",
                    "1980","1984","1988","1992",
                    "1994","1998","2002","2006",
                    "2010","2014","2018","2022","2026"
            };

            String[] cities = {
                    "サンモリッツ","オスロ","コルティナ・ダンペッツォ",
                    "スコーバレー","インスブルック","グルノーブル",
                    "札幌","インスブルック","レークプラシッド",
                    "サラエボ","カルガリー","アルベールビル",
                    "リレハンメル","長野","ソルトレークシティ",
                    "トリノ","バンクーバー","ソチ",
                    "平昌","北京","ミラノ・コルティナ"
            };

            for(int i = 0; i < years.length; i++) {
                if(years[i].equals(year)) {
                    city = cities[i];
                    break;
                }
            }
        }

        request.setAttribute("year", year);
        request.setAttribute("season", season);
        request.setAttribute("city", city);

        request.getRequestDispatcher(
                "/olympicCity2.jsp")
                .forward(request, response);
    }
}
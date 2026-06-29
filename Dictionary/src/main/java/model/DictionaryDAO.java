package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDAO {

    private final String JDBC_URL =
            "jdbc:postgresql://localhost:5432/dictionary";
    private final String DB_USER = "postgres";
    private final String DB_PASS = "psql";

    public List<EjDict> findByWord(String word, int maxCount) {

        List<EjDict> ejDictList = new ArrayList<>();

        String sql =
            "SELECT id, word, explanation FROM ejdict " +
            "WHERE LOWER(word) LIKE LOWER(?) " +
            "ORDER BY word " +
            "LIMIT ?";

        try {
            Class.forName("org.postgresql.Driver");

            try (
                Connection conn =
                    DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt =
                    conn.prepareStatement(sql);
            ) {

                pStmt.setString(1, word + "%");
                pStmt.setInt(2, maxCount);

                try (ResultSet rs = pStmt.executeQuery()) {

                    while (rs.next()) {

                        int id = rs.getInt("id");
                        String resultWord = rs.getString("word");
                        String explanation = rs.getString("explanation");

                        EjDict ejDict =
                                new EjDict(id, resultWord, explanation);

                        ejDictList.add(ejDict);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ejDictList;
    }
}
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MakeEjDict {
	public static void main(String[] args) {
		System.out.println("MakeEjDict開始");
		
	    String url = "jdbc:postgresql://localhost:5432/dictionary";
	    String user = "postgres";
		String password = "psql";
		
		String filePath = "data/ejdic-hand-utf8.txt";
		
		String deleteSql = "TRUNCATE TABLE ejdict RESTART IDENTITY";
		String insertSql = "INSERT INTO ejdict(word, explanation) VALUES (?, ?)";
		try(
				Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement deletePs = con.prepareStatement(deleteSql);
				PreparedStatement ps = con.prepareStatement(insertSql);
				BufferedReader br = new BufferedReader(new FileReader(filePath));
				) {
			    deletePs.executeUpdate();
			    
			    String line;
			    
			    while ((line = br.readLine()) != null) {
			    	String[] data = line.split("\t");
			    	
			    	if (data.length >= 2) {
			    		String word = data[0];
			    		String explanation = data[1];
			    		
			    		ps.setString(1, word);
			    		ps.setString(2, explanation);
			    		
			    		ps.executeUpdate();
			    	}
			    }
			    
			    System.out.println("登録が完了しました");
			    
		        } catch (Exception e) {
		        	e.printStackTrace();
		        }
	}
}

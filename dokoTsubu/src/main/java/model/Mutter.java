package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mutter implements Serializable{
	private String userName; //ユーザー名
	private String text; // つぶやき内容
	private LocalDateTime postTime; //投稿時間
    
	private static int nextId = 1;
	private int id;
	
    public Mutter() {}
    public Mutter(String userName, String text) {
    	this.id = nextId++;
    	this.userName = userName;
    	this.text = text;
    	this.postTime = LocalDateTime.now();
    }
    public int getId() {
    	return id;
    }
    public String getUserName() { return userName; }
    public String getText() { return text; }
    public LocalDateTime getPostTime() { return postTime; }
    public String getFormattedTime() {
    	if (postTime == null) {
    		return "";
    	}
    	return postTime.format(
    			DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")
    			);
    			
    }
}


package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mutter implements Serializable{
	private int id; //投稿ID
	private int userId; //ユーザーID
	private String userName; //ユーザー名
	private String text; // つぶやき内容
	private LocalDateTime postTime; //投稿時間
    
		
    public Mutter() {}
    //投稿する時用
    public Mutter(int userId, String userName, String text) {
    	this.userId = userId;
    	this.userName = userName;
    	this.text = text;
    	this.postTime = LocalDateTime.now();
    }
    
    //DBから取り出すとき用
    public Mutter(int id, int userId, String userName, String text, LocalDateTime postTime) {
    	this.id = id;
    	this.userId = userId;
    	this.userName = userName;
    	this.text = text;
    	this.postTime = postTime;
    }
    
    public int getId() { return id; }
    public int getUserId() { return userId; }
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


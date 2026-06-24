package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mutter implements Serializable{
	private int id;  //ID
	private int userId; //ユーザーID
	private String userName; //ユーザー名
	private String text;     //つぶやき内容
	private LocalDateTime postTime; //投稿時間
	
	public Mutter() {}
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	public Mutter(int userId,
            String userName,
            String text) {

        this.userId = userId;
        this.userName = userName;
        this.text = text;
    }
	public Mutter(int id, String userName, String text, LocalDateTime postTime) {
		this.id = id;
		this.userName = userName;
		this.text= text;
        this.postTime = postTime;
	}
	public Mutter(int id, int userId, String userName, String text, LocalDateTime postTime) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.text = text;
		this.postTime = postTime;
	}
	public int getId() { return id;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() { return userName;
	}
	public String getText() { return text; 
	}
    public LocalDateTime getPostTime() {
    	return postTime;
    }
    public String getFormattedPostTime() {	
    DateTimeFormatter formatter =
    			DateTimeFormatter.ofPattern(
    					"yyyy/MM/dd HH:mm");
    	
        return postTime.format(formatter);
    }	
}

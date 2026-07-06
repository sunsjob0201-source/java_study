package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mutter implements Serializable {

    private int id;                 // 投稿ID
    private int userId;             // ユーザーID
    private String userName;        // ユーザー名
    private String text;            // つぶやき内容
    private LocalDateTime postTime; // 投稿時間
    private String imagePath;       // 画像パス

    // ユーザー名と本文だけ指定するコンストラクタ
    public Mutter(String userName, String text) {
        this.userName = userName;
        this.text = text;
    }

    // 投稿時に使用するコンストラクタ
    public Mutter(int userId, String userName, String text) {
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.postTime = LocalDateTime.now();
    }

    // 画像パスは変更できるようにする
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // 投稿日時を見やすい形式で返す
    public String getFormattedTime() {
        if (postTime == null) {
            return "";
        }
        return postTime.format(
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }
}
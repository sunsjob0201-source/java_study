package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskInfo implements Serializable {
	
	private int taskId;               // タスクID
	private String taskName;          // タスク名称
	private String taskContents;      // タスク内容
	private LocalDate taskLimitdate;  // タスク期限
	private LocalDateTime taskUpdate; // タスク変更日時
	private LocalDateTime taskDelete; // タスク削除日時
	private String taskUser;          // タスク担当者
	private int taskStatus;           // タスク状況
	private String userId;            // ユーザーID
	
    //一覧表示用:taskstatusテーブルから取得するラベル
	private String taskLabel;         // タスク状況ラベル
}

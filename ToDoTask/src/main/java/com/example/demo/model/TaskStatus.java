package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskStatus {

    private int taskStatus;       // タスク状況
    private String taskLabel;     // タスク状況ラベル
    private int taskSeq;          // 表示順
    private boolean taskProgress; // 進行中かどうか
}
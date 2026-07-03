package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  // getterメソッドを生成
@Setter  // setterメソッドを生成
@NoArgsConstructor //デフォルトコンストラクタを生成
@AllArgsConstructor //すべてのフィールドを引数にもつコンストラクタを生成
public class Product {
	private String name;
	private int price;
}

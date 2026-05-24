//package studentdata;
//
//public class Student {
//        String student(String name, int age, int score) {
//        	this.name = name;
//        	this.age = age;
//        	this.score = score;
//        }
//}
//コンストラクタは戻り値なしでクラス名と同じ
//フィールドが存在しない name, age, scoreがクラスにない
//データ（フィールド）  
//＋           
//初期化（コンストラクタ）
//＋           
//振る舞い（メソッド）  
package studentdata;

public class Student {
	
	String name;
	int age;
	int score;
	
	public Student(String name, int age, int score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public String judge() {
		if (score >= 60) {
			return "合格";
		} else {
			return "不合格";
		}
	}
}
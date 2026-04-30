package IfBasic;

public class switch_practice {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		var rank = "甲";
		
		switch (rank){
			case "甲":
				System.out.println("大変良いです。");
				break;
				
			case "乙":
				System.out.println("良いです。");
				break;
				
			case "丙":
				System.out.println("がんばりましょう");
				break;
				
			default:
				System.out.println("？？？");
				break;
		}

	}

}

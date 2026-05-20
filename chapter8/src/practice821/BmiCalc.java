package practice821;

public class BmiCalc {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		var b = new StudentBmi("田中一郎", 18, 175.0, 68.5);
		
		System.out.println("名前:" + b.getName());
		System.out.println("年齢:" + b.getAge());
		System.out.println("身長:" + b.getHeight());
		System.out.println("体重:" + b.getWeight());
		System.out.println("BMI値:" + b.bmi());
	}

}

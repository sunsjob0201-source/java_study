package practice821;

public class OptimalWeight {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		var h = new StudentHealth("田中一郎", 18, 175.0, 68.5, 1);
		
		System.out.println("名前:" + h.getName());
		System.out.println("年齢:" + h.getAge());
		System.out.println("性別:" + h.getSex());
		System.out.println("身長:" + h.getHeight());
		System.out.println("体重:" + h.getWeight());
		System.out.printf("BMI値:%.2f%n", h.bmi());
		System.out.printf("適正体重:%.1f%n", h.optimalWeight());
	}

}

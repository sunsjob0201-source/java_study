package practice821;

public class StudentInfo{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		var s = new StudentData("田中一郎", 18, 175.0, 68.5);
		
		System.out.println("名前:" + s.getName());
		System.out.println("年齢:" + s.getAge());
		System.out.println("身長:" + s.getHeight());
		System.out.println("体重:" + s.getWeight());
    }
}
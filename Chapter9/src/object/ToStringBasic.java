package object;

public class ToStringBasic {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    var p1 = new Person("太郎", "山田");
    var p2 = new Person("太郎", "山田");
    p2 = p1;
    System.out.println(p1.equals(p2));
	}

}

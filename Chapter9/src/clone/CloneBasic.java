package clone;

public class CloneBasic {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    var p1 = new Person("太郎", "山田");
    var p2 = p1.clone();
    System.out.println(p1 == p2);
    System.out.println(p2);
	}

}

package chapter8;

public class AccessorBasic {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    var p = new Person();
    p.setName("山田太郎");
    p.setAge(30);
    System.out.println(p.show());
    p.setAge(-30);
	}

}

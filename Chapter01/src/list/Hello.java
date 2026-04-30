package list;

public class Hello {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] a = {3,2,5};
		int[] b = new int[3];
		b[0] = a[0];
		b[1] = a[1];
		b[2] = a[2];
		
	System.out.println("a[2] = " + a[2]);
	
	b = new int[] {3, 2, 5};
	b[2] = 10;
	a[2] = b[2];
	System.out.println("a[2] = " + a[2]);
	}
}

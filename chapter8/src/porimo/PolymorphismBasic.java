package porimo;

public class PolymorphismBasic {

	public static void main(String[] args) {
		Shape sha;
		
		sha = new Triangle(10, 50);
		System.out.println(sha.getArea());
		
		sha = new Rectangle(10, 50);
		System.out.println(sha.getArea());
	}
}

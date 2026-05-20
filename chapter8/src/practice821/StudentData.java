package practice821;

public class StudentData extends Student {
	private double height;
	private double weight;
	
	public StudentData(String name, int age, double height, double weight) {
	
		super(name, age);
		
		this.height = height;
		this.weight = weight;
	}
	
	public double getHeight() {
		return this.height;
	}

	public double getWeight() {
		return this.weight;
	}
}

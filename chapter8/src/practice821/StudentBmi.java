package practice821;

public class StudentBmi extends StudentData {

	public StudentBmi(String name, int age, double height, double weight) {
		super(name, age, height, weight);
	}
	public double bmi() {
		return 10000 * getWeight() / (getHeight() * getHeight());
	}
}

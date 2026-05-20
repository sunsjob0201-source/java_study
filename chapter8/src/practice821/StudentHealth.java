package practice821;

public class StudentHealth extends StudentBmi{
  private int sex;
  
	public StudentHealth(String name, int age, double height, double weight, int sex) {
		super(name, age, height, weight);
		this.sex = sex;
	}
	public String getSex() {
		if (sex == 1) {
			return "男性";
		}else {
			return "女性";
			}
		}
	public double optimalWeight() {
		if (sex == 1) {
			return 22 * (getHeight()  / 100) * (getHeight()  / 100);
		} else {
			return 23 * (getHeight()  / 100) * (getHeight()  / 100);
		}
	}
}

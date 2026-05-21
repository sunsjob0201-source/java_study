package practice831;

public class StudentHealth extends StudentBmi {

    private int sex;

    public StudentHealth(String name,
                         int age,
                         double height,
                         double weight,
                         int sex) {

        super(name, age, height, weight);

        this.sex = sex;
    }

    public String getSex() {

        if (sex == 1) {
            return "男性";
        } else {
            return "女性";
        }
    }

    public double optimalWeight() {

        double h = getHeight() / 100.0;

        if (sex == 1) {
            return 22 * h * h;
        } else {
            return 23 * h * h;
        }
    }

    @Override
    public String toString() {

        return super.toString()
                + " 性別="
                + getSex()
                + " 適正体重="
                + String.format("%.1f", optimalWeight())
                + "kg";
    }
}
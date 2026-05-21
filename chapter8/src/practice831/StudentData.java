package practice831;

public class StudentData extends Student {

    private double height;
    private double weight;

    public StudentData(String name, int age,
                       double height, double weight) {

        super(name, age);

        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {

        return getName()
                + "/"
                + getAge()
                + "歳/"
                + height
                + "cm/"
                + weight
                + "kg";
    }
}
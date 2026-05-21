package practice831;

public class StudentHealthInfo {

    public static void main(String[] args) {

        Student[] students = {


                new StudentHealth("前田 浩二",21,178.8,70.1, 1),

                new StudentBmi("中村 次郎",36,165.7,72.8),
                
                new Student("本田 末男", 28),

                new StudentHealth("岡村 由紀", 25,158.8, 51.3,2),

                new StudentHealth("斎藤 真理",32,155.6, 56.5, 2)
        };

        for (Student s : students) {

            System.out.println(s);
        }
    }
}
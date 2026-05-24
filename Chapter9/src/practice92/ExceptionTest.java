

























package practice92;

import java.util.Scanner;

public class ExceptionTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            try {

                System.out.print("辺A : ");
                double a = sc.nextDouble();

                System.out.print("辺B : ");
                double b = sc.nextDouble();

                System.out.print("辺C : ");
                double c = sc.nextDouble();

                Triangle t = new Triangle(a, b, c);

                System.out.println(
                        "面積 : " + t.area()
                );

                System.out.println();

            } catch (TriangleException e) {

                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}
//package practice92;
//
//public class ExceptionTest {
//
//	public static void main(String[] args) {
//		// TODO 自動生成されたメソッド・スタブ
//     int a;
//     int b;
//     int c;
//    
//     try(TriangleException()){
//    	 System.out.println("辺A : " + a);
//    	 System.out.println("辺b : " + b);
//    	 System.out.println("辺c : " + c);
//    	 System.out.println(TriangleException()) &&
//    	 if(true) {
//    		 System.out.println("面積 : ");
//    	 }
//      }
//    	  
//      }
//     }
//	}
//
//}

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
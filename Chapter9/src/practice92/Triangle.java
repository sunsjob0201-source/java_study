//package practice92;
//
//public class Triangle {
//	private int a;
//	private int b;
//	private int c;
//	
//	public Triangle(String x, String y, String z) {
//		this.x = x;
//		this.y = y;
//		this.z = z;
//		
//	try() {
//	}catch(Triangle > 0) {
//		System.out.println("辺の入力が正しくありません");
//	}catch((x >= y + z) || (y >= z + x) || (z >= x + y)) {
//		System.out.println("辺の組み合わせが正しくありません");
//	}catch(error) {
//		throw new TriangleException();
//	}
//	public double area() {
//		 double base = 10.0;   // 底辺
//	        double height = 5.0; // 高さ
//
//	        double area = base * height / 2;
//	}
//	
//	}
//	}
//}

package practice92;

public class Triangle {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c)
            throws TriangleException {

        // 辺が0以下
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleException(
                    "辺の入力が正しくありません");
        }

        // 三角形成立条件
        if (a >= b + c ||
            b >= c + a ||
            c >= a + b) {

            throw new TriangleException(
                    "辺の組み合わせが正しくありません");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    // ヘロンの公式
    public double area() {

        double s = (a + b + c) / 2;

        return Math.sqrt(
                s * (s - a) * (s - b) * (s - c)
        );
    }
}
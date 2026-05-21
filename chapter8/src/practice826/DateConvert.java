//package practice826;
//
//public class DateConvert {
//
//	public static void main(String[] args) {
//		// TODO 自動生成されたメソッド・スタブ
//    System.out.println(date() + "->" +toString());
//	}
//
//}
package practice826;

public class DateConvert {

    public static void main(String[] args) {

        JapanDate[] dates = {
                new JapanDate(1800, 5, 2),
                new JapanDate(1900, 2, 25),
                new JapanDate(1920, 10, 5),
                new JapanDate(1975, 8, 12),
                new JapanDate(2004, 6, 20),
                new JapanDate(2023, 12, 31)
        };

        for (JapanDate d : dates) {

            String seireki =
                    d.getYear() + "年"
                    + d.getMonth() + "月"
                    + d.getDay() + "日";

            System.out.printf(
                    "%-20s -> %-20s%n",
                    seireki,
                    d.toString()
            );
        }
    }
}


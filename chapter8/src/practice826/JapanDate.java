//package practice826;
//
//public class JapanDate extends WorldDate {
//  public JapanDate (int year, int month, int day) {
//	  super(year, month, day);
//	  
//  }
//  @Override
//  public String date() {
//	  if (d <= JapanDate(1868, 10, 22)) {
//		  return "表示不可";
//	  } else if (d <= JapanDate(1912, 7, 29)) {
//		  return "明治";
//	  } else if (d <= JapanDate(1926, 12, 24)) {
//		  return "大正";
//	  }else if (d <= JapanDate(1989, 1, 7)) {
//		  return "昭和";
//	  }else if (d <= JapanDate(2019, 4, 30)) {
//		  return "平成";
//	  }else {
//		  return "令和";
//	  }
//  }
//  public getNen() {
//	  if (date() == "表示不可") {
//		  return "表示不可";
//	  }else if (date() == "明治") {
//		  return this.year - 1867;
//	  }else if (date() == "大正") {
//		  return this.year - 1911;
//	  }else if (date() == "昭和") {
//		  return this.year - 1925;
//	  }else if (date() == "平成") {
//		  return this.year - 1988;
//	  }else if (date() == "令和") {
//		  return this.year - 2018;
//	  }
//  }
//  public String toString() {
//	  return "date(), + getNen(), + "年", + month, + "月", + date, + "日""
//	  
//  }
//}

package practice826;

public class JapanDate extends WorldDate {

    public JapanDate(int year, int month, int day) {
        super(year, month, day);
    }

    // 元号を返す
    public String getGengo() {

        int y = getYear();
        int m = getMonth();
        int d = getDay();

        if (y < 1868 || (y == 1868 && m < 10)
                || (y == 1868 && m == 10 && d < 23)) {

            return "表示不可";

        } else if (y < 1912 || (y == 1912 && m < 7)
                || (y == 1912 && m == 7 && d <= 29)) {

            return "明治";

        } else if (y < 1926 || (y == 1926 && m < 12)
                || (y == 1926 && m == 12 && d <= 24)) {

            return "大正";

        } else if (y < 1989 || (y == 1989 && m == 1 && d <= 7)) {

            return "昭和";

        } else if (y < 2019 || (y == 2019 && m == 4 && d <= 30)) {

            return "平成";

        } else {

            return "令和";
        }
    }

    // 元号の年数
    public int getNen() {

        String gengo = getGengo();

        if (gengo.equals("明治")) {
            return getYear() - 1867;

        } else if (gengo.equals("大正")) {
            return getYear() - 1911;

        } else if (gengo.equals("昭和")) {
            return getYear() - 1925;

        } else if (gengo.equals("平成")) {
            return getYear() - 1988;

        } else if (gengo.equals("令和")) {
            return getYear() - 2018;
        }

        return 0;
    }

    @Override
    public String toString() {

        if (getGengo().equals("表示不可")) {
            return "表示不可";
        }

        return getGengo()
                + getNen()
                + "年"
                + getMonth()
                + "月"
                + getDay()
                + "日";
    }
}

package Stream;

import java.util.stream.Stream;

public class StreamFilter {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      Stream.of(
    		  "https://www.shoeisya.co.jp/",
    		  "SEshop",
    		  "https://codezine.jp/",
    		  "https://wings.msn.to/",
    		  "WingsProject"
    		  )
      .filter(s -> s.startsWith("https://"))
      .forEach(System.out::println);
	}

}

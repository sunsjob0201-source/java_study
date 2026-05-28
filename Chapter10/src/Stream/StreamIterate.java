package Stream;

import java.util.stream.Stream;

public class StreamIterate {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      var stream = Stream.iterate(1, num -> num * 2);
      stream.limit(10).forEach(System.out::println);
	}

}


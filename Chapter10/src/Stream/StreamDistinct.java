package Stream;

import java.util.stream.Stream;

public class StreamDistinct {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    Stream.of("あか", "さかな", "あか", "こだま", "きんもくせい")
      .peek(System.out::println)
      .sorted()
      .forEach(System.out::println);
	}
}

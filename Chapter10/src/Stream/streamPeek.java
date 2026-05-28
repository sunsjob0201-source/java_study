package Stream;

import java.util.stream.Stream;

public class streamPeek {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      Stream.of("さかな", "あか", "こだま", "きんもくせい")
        .peek(System.out::println)
        .sorted()
        .forEach(System.out::println);
	}

}

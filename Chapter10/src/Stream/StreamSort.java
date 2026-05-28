package Stream;

import java.util.stream.Stream;

public class StreamSort {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      Stream.of("バラ", "あさがお", "チューリップ", "さくら")
      .sorted()
      .forEach(System.out::println);
	}

}

package Stream;

import java.util.stream.IntStream;

public class streamTake {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      IntStream.of(-2, -5, 0, 3, -1, 2)
        .takeWhile(i -> i < 0)
        .forEach(System.out::println);
	}

}

package Stream;

import java.util.stream.IntStream;

public class StreamLimit {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
     IntStream.range(1, 20)
       .skip(4)
       .limit(10)
       .forEach(System.out::println);
	}

}

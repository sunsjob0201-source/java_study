package Stream;

import java.util.stream.IntStream;

public class StreamMatch {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      System.out.println(
    		  IntStream.of(1, 10, 5, -5, 12)
    		  .allMatch(v -> v >=0)
    		  );
	}
}

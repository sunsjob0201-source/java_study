package Stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRange {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      IntStream.range(10, 20)
        .forEach(System.out::println);
	
	
	System.out.println("------------");
	Stream.iterate(10, num -> ++num)
	  .limit(10).forEach(System.out::println);

	}
}

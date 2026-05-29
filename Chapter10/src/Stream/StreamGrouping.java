package Stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGrouping {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    System.out.println(
    		Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
    		.sorted()
    		.collect(
    				Collectors.groupingBy(str -> str.length(),
    						Collectors.joining("/")
    						))
    		);
	}

}

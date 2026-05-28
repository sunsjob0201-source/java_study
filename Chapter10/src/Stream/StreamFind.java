package Stream;

import java.util.stream.Stream;

public class StreamFind {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      var str = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら", "もも")
    		  .filter(s -> s.startsWith("さ"))
    		  .findFirst();
      System.out.println(str.orElse("-"));
	}

}

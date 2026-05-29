package Stream;

import java.util.stream.Stream;

public class StreamReduce {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      System.out.println(
    		  Stream.of("バラ", "あさがお", "チューリップ", "さくら")
    		  .sorted()
    		  .reduce((result, str) -> result + "," +  str)
    		  .orElse("")
    		  );
	}

}

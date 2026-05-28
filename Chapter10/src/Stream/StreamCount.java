package Stream;

import java.util.stream.Stream;

public class StreamCount {

	public static void main(String[] args) {
    		// TODO 自動生成されたメソッド・スタブ
      System.out.println(
    		  Stream.of("バラ", "あさがお", "チューリップ", "さくら")
    		  .filter(s -> s.length() > 3)
    		  .count()
    		  );
	}

}

package Stream;

import java.util.stream.Stream;

public class StreamRedece2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      System.out.println(
    		  Stream.of("バラ", "あさがお", "チューリップ", "さくら")
    		  .sorted()
    		  .reduce("ひまわり", (result, str) -> result + "," + str)
    		  );
	}

}

package Stream;
 import java.util.stream.Stream;
 
public class StreamMap {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      Stream.of("バラ", "あさがお", "チューリップ", "さくら")
      .map(s -> s.length())
      .forEach(System.out::println);
	}

}

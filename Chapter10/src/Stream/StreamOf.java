package Stream;

 import java.util.stream.Stream;
 
public class StreamOf {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      var stream = Stream.of("first", "second", "third");
      stream.forEach(System.out::println);
	}
}

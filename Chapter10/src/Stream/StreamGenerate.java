package Stream;

import java.util.Random;
import java.util.stream.Stream;
public class StreamGenerate {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      var stream = Stream.generate(() -> {
    	  var r = new Random();
    	  return r.nextInt(100);
      });
      stream.limit(10).forEach(System.out::println);
	}

}

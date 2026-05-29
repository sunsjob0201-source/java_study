package Stream;

import java.util.stream.Stream;

public class StreamReduce3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      System.out.println(
    		  Stream.of("153", "211", "112", "350", "418", "208")
    		  .parallel()
    		  .reduce(0,
    				  (result, value) -> result + Integer.parseInt(value),
    				  (result1, result2) -> result1 + result2
    				  )
    		  );
	}

}

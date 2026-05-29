package Stream;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StreamCollectOf {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	  System.out.println(
      Stream.of("バラ", "あさがお", "チューリップ", "さくら")
      .sorted()
      .collect(
    		  Collector.of(
    				  ArrayList<String>::new,
    				  (list, str) -> list.add(str),
    				  (list1, list2) -> {
    					  list1.addAll(list2);
    					  return list1;
    				  },
    				  Collector.Characteristics.IDENTITY_FINISH
    				  )
    		  )
      );
	}

}

package Stream;

import java.util.List;

public class StreamFlat {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      var list = List.of(
    		  List.of("あいう", "かきく", "さしす"),
    		  List.of("たちつ", "なにぬ"),
    		  List.of("はひふ", "まみむ")
    		  );
      list.stream()
      .flatMap(v -> v.stream())
      .forEach(System.out::println);
	}

}

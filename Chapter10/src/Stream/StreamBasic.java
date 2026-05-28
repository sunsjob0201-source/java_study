package Stream;

import java.util.List;
public class StreamBasic {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    var list = List.of("ant", "elephant", "hamster");
    
    list.
     stream().
     filter(s -> s.length() > 3).
     map(String::toUpperCase).
     forEach(System.out::println);
	}
}
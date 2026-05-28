//package Stream;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class StreamCollectMap {
//  public static void main(String[] args) {
//	  Stream.of(
//			  new Person2("山田太郎", "tyamada@example.com"),
//			  new Person2("鈴木花子", "hsuzuki@example.com"),
//			  new Person2("山田太郎", "sinoue@example.com"),
//			  new Person2("山田太郎", "ksatou2@example.com"),
//			  new Person2("山田太郎", "yamataro@example.com")
//			  ).collect(Collectors.toMap(
//					  Person2::getName,
//					  Person2::getEmail,
//					  (s, a) -> s + "/" + a
//					  ));
//	  
//  }
//}

package Stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectMap {

	public static void main(String[] args) {

		var map = Stream.of(
				new Person2("山田太郎", "tyamada@example.com"),
				new Person2("鈴木花子", "hsuzuki@example.com"),
				new Person2("山田太郎", "sinoue@example.com"),
				new Person2("山田太郎", "ksatou2@example.com"),
				new Person2("山田太郎", "yamataro@example.com")
		).collect(Collectors.toMap(
				Person2::getName,
				Person2::getEmail,
				(s, a) -> s + "/" + a
		));

		System.out.println(map);
	}
}

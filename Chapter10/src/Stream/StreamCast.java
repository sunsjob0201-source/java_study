package Stream;

import java.util.stream.IntStream;

public class StreamCast {
 public static void main(String[] arg) {
	 IntStream.range(1, 5)
	   .asDoubleStream()
	   .forEach(System.out::println);
 }
}

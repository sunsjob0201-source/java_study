package method;

import java.util.function.Consumer;

public class MethodLambda {
  public void walkArray(String[] data, Consumer<String> output) {
	  for(var value : data) {
		  output.accept(value);
	  }
  } 
}

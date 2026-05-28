package method;

import java.util.ArrayList;
import java.util.List;

public class COllReplace {
  public static void main(String[] arg) {
	  var list = new ArrayList<String>(
		 List.of("バラ", "チューリップ", "あさがお"));
      list.replaceAll(v -> {
    	  if (v.length() < 3) {
    		  return v;
    	  } else {
    		  return v.substring(0, 3);
    	  }
      });
      System.out.println(list);
  }
}

package method;

import java.util.ArrayList;
import java.util.List;

public class CollRemove {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
     var list = new ArrayList<String>(
    		 List.of("バラ", "チューリップ", "あさがお", "ヒヤシンス"));
     list.removeIf(v -> v.length() > 4);
     System.out.println(list);
	}

}

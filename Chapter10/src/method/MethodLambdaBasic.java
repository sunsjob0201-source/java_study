package method;

public class MethodLambdaBasic {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    var data = new String[] {"春はあけぼの", "夏は夜", "秋は夕暮れ" };
    var ml = new MethodLambda();
    ml.walkArray(data, (String value) -> {
    	System.out.printf("[%s]\n", value);
    });
	}

}

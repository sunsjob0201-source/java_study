package method;

public class MethodRefUnuse {

    public void walkArray(String[] data, Output output) {
        for (var value : data) {
            output.print(value);
        }
    }

    public static void addQuote(String str) {
        System.out.printf("[%s]%n", str);
    }
}
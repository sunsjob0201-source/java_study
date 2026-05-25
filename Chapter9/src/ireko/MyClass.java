package ireko;

public class MyClass {

    private String str1 = "包括・インスタンス";
    private static String str2 = "包括・クラス";

    private static class MyHelper {
        private String str1 = "ネスト・インスタンス";
        private static final String str2 = "ネスト・クラス";

        private MyClass outer;

        public MyHelper(MyClass outer) {
            this.outer = outer;
        }

        public void show() {
            System.out.println(outer.str1);
            System.out.println(MyClass.str2);
        }
    }

    public void run() {
        var helper = new MyHelper(this);
        helper.show();

        System.out.println(helper.str1);
        System.out.println(MyHelper.str2);
    }
}
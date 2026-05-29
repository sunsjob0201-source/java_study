package thread;

public class RunnableBasic {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    var th1 = new Thread(new MyRunner());
    var th2 = new Thread(new MyRunner());
    var th3 = new Thread(new MyRunner());
    
    th1.start();
    th2.start();
    th3.start();
	}

}

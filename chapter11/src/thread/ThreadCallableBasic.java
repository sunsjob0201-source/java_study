package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ThreadCallableBasic {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    try (var exe = Executors.newSingleThreadExecutor()) {
    	var r1 = exe.submit(new ThreadCallable());
    	var r2 = exe.submit(new ThreadCallable());
    	var r3 = exe.submit(new ThreadCallable());
    	
    	try {
    		System.out.println("r1: " + r1.get());
    		System.out.println("r2: " + r2.get());
    		System.out.println("r3: " + r3.get());
    	} catch (InterruptedException | ExecutionException e) {
    		e.printStackTrace();
    	}
    }
	}

}

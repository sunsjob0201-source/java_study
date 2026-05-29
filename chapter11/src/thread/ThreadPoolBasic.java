package thread;

import java.util.concurrent.Executors;

public class ThreadPoolBasic {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    try(var es = Executors.newFixedThreadPool(10)) {
    	es.execute(new ThreadPool());
    	es.execute(new ThreadPool());
    	es.execute(new ThreadPool());
    }
	}

}

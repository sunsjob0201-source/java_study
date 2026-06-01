package schoolpractice;

public class sumscore {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
    int[] data = Student.score;
    
    int a = 0;
    int b = 0;
    int c =0;
    int d =0;
    int e =0;
    int error = 0;
    
    for (int i = 0; i < data.length; i++) {
    	
    	int score = data[i];
    	
    	if(score >= 90 && score <= 100) {
    		a++;
    	}else if(score >= 80) {
    		b++;
    	}else if(score >= 70) {
    		c++;
    	}else if(score >= 60) {
    		d++;
    	}else if(score < 60 && score >= 0) {
    		e++;
    	}else {
    		error++;
    	}
    	
    }
    System.out.println("A : " + a);
	System.out.println("B : " + b);
	System.out.println("C : " + c);
	System.out.println("D : " + d);
	System.out.println("E : " + e);
	System.out.println("エラー : " + error);
	}

}

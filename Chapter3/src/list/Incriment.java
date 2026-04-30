package list;

import java.util.Arrays;

public class Incriment {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	/*	var i = 3;
		var j = ++i;
		
		System.out.println(i);
		System.out.println(j);
		
		var m = 3;
	//	var n = m++;
		m++; //単独なら前置でも後置でも変わらない
		var n = m;
		System.out.println(m);
		System.out.println(n);
		
		int x = 5 ;
		++x;
		int y = ++x + x++;
		System.out.println(x);
		System.out.println(y);
		
		
		int a = 1, b = 2, c = 3;
		
		a += b += c;
	
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		//右から計算されていく
		/// 
		 
		
		int a = 3;
		int b = 3;
		int c = 4;
		System.out.println(a == b);
		System.out.println(a == c);
		
		int[] x = {1, 2, 3};
		int[] y = {1, 2, 3};
		int[] z = {4, 5, 6};
		// 配列は毎回newを使っている
		
		System.out.println(x == y);
		//z = x; こうすると参照型でも同じになる
		System.out.println(x == z); //参照型はオブジェクトが同じかどうか
		
		String n = "abc";
		String m = "abc";
		String o = "def";
		
		System.out.println(n == m);
		System.out.println(n == o);
		
		
		System.out.println((0.7 + 0.1) * 10); //整数と小数は扱いが別
		
		
		//条件演算子
		var age = 30;
		System.out.println(age >= 20 ? "おとな" : "こども");
		 // ?:はtrueなら１ でなければ２を返す
		
		if (age >= 20){
			System.out.println("おとな");
		} else {
			System.out.println("こども");
			
		
		var data1 = new String[] {"あ", "い", "う" };
		var data2 = new String[] {"あ", "い", "う" };
		System.out.println(data1 == data2);
		System.out.println(data1.equals(data2));
		System.out.println(Arrays.equals(data1, data2));
		*/
		var data1 = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
		};
		var data2 = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
		};
		System.out.println(Arrays.equals(data1, data2));
		System.out.println(Arrays.deepEquals(data1, data2));
		}

}

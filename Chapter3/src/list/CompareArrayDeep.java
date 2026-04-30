package list;

import java.util.Arrays;

public class CompareArrayDeep {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	
		/*var data1 = new int[][] {
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
		*/
		
		var data1 = new int[] {1, 3};
		var data2 = new int[] {1, 2, 3};
		var data3 = new int[] {1, 2, 3};
		var data4 = new int[] {1, 3, 1};
		var data5 = new int[] {1, 2, 3, 4};
		System.out.println(Arrays.compare(data1, data2));
		System.out.println(Arrays.compare(data2, data3));
		System.out.println(Arrays.compare(data3, data4));
		System.out.println(Arrays.compare(data3, data5));
		
		}

}

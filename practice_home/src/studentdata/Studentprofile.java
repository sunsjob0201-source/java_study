//package studentdata;中")
//
//public class Studentprofile extends Student{
//
//	public static void main(String[] args) {
//		// TODO 自動生成されたメソッド・スタブ
//       System.out.println("名前 : " + name);
//       System.out.println("年齢 : " + age);
//       System.out.println("点数 : " + score);
//       System.out.println(judge());
//	}
//
//}
//インスタンスを作ってない

package studentdata;                             
                                                 
public class Studentprofile {     
                                                 
	public static void main(String[] args) {        
		// TODO 自動生成されたメソッド・スタブ
		
	   Student s = new Student("田中", 20, 75);
	   
       System.out.println("名前 : " + s.name);       
       System.out.println("年齢 : " + s.age);        
       System.out.println("点数 : " + s.score);      
       System.out.println("判定 : " + s.judge());              
	} 
}
                                                 
package chapter8;

public class ChipSet {
       private int c10;
       private int c1;
       
       public Chipset(int c10, int c1) {
    	   this.c10 = c10;
    	   this.c1 = c1;
       }
       public ChipSet(int p) {
           this(p / 10, p % 10);
       }
       public ChipSet() {}
       
       public int getC10() {
    	   return c10;
       }
       public int getC1() {
    	   return c1;
       }
       
       public int change(int c10, int c1) {
    		   return c10 + c1 {
    			   if (c1 >= 10) {
    				   c10 + c1 /10;
    			   }if else (c1 < 0) {
    				   c10 - 1;
    			   }
    		   }
    	   }
    	   public int change(int p) {
    		return p /10 -> c10;
    		return p % 10 -> c1;
    	   }
    	   public int getPoints() {
    		   return c10 * 10 + c1;
    	   }
    	   public String toString() {
    		   return String.format("点数；　＋　(c10 +c1) + ("c10:" + c10 + ",c1;" + c1");
    	   }
       }
       
       


}

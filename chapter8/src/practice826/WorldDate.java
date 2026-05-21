package practice826;

public class WorldDate {
  private int year;
  private int month;
  private int day;
  
  public WorldDate (int year, int month, int day) {
	  this.year = year;
	  this.month = month;
	  this.day = day;
  }
	  public int getYear() {
    	return year;
    }
    
    public int getMonth() {
    	return month;
    }
    
    public int getDay() {
    	return day;
    }
    
    public String date() {
    	return year + "年" + month + "月" + day + "日";
    }
      
}

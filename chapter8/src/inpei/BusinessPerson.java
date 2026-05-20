package inpei;
import java.time.LocalDateTime;

public class BusinessPerson extends Person{
  public LocalDateTime birth = LocalDateTime.now();
  
  public void show() {
	  System.out.println(super.birth);
  }
}

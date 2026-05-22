package equals;

import java.util.Objects;

public class Person {
	  private String firstName;
	  private String lastName;
	  
	  public Person(String firstName, String lastName) {
		  this.firstName = firstName;
		  this.lastName = lastName;
	  }
	  @Override
	  public boolean equals(Object obj) {
		  if (this == obj) {return true;}
		  if (obj == null) {return false;}
		  if(obj instanceof Person p) {
			  return Objects.equals(this.firstName, p.firstName) &&
					  Objects.equals(this.lastName, p.lastName);
		  }
		  return false;
	  }
	}



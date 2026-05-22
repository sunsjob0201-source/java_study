package compare;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
	private String firstNameKana;
	private String lastNameKana;

	public Person(String firstNameKana, String lastNameKana) {
		this.firstNameKana = firstNameKana;
		this.lastNameKana = lastNameKana;
	}
	
	@Override
	public int compareTo(Person o) {
		if (Objects.equals(this.lastNameKana, o.lastNameKana)) {
			return Objects.compare(this.firstNameKana, o.firstNameKana,
					Comparator.nullsFirst(Comparator.naturalOrder()));
		}else {return Objects.compare(this.lastNameKana, o.lastNameKana,
				Comparator.nullsFirst(Comparator.naturalOrder()));
			
		}
	}
	@Override
	public String toString() {
		return this.lastNameKana + " " + this.firstNameKana;
	}
}

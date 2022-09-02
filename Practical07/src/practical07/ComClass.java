package practical07;

import java.util.Comparator;

public class ComClass implements Comparator<Person>{

	public int compare(Person o1, Person o2) {
		if (o1.getSalary() < o2.getSalary()) {return -1;}
		else if (o1.getSalary() > o2.getSalary()) {return 1;}
		else return 0;
	}

	
	
}

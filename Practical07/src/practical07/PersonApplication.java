package practical07;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PersonApplication {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		Scanner s = new Scanner(new File ("C:\\Users\\nikol\\OneDrive\\Desktop\\cs207\\People2.txt"));
		
		List<Person> person = new ArrayList<Person>();
	
		try {
		while (s.hasNext()) {
		    person.add(new Person(s.next(), s.next(), s.nextDouble()));
		  }
		
		for (int i = 0; i<person.size(); i++) {
			System.out.print(person.get(i).getSurname() + " ");
			System.out.print(person.get(i).getFirstname() + " ");
			System.out.println(person.get(i).getSalary());
		}
		
		System.out.println();
		
		Collections.sort(person);
		
		for (int i = 0; i<person.size(); i++) {
			System.out.print(person.get(i).getSurname() + " ");
			System.out.print(person.get(i).getFirstname() + " ");
			System.out.println(person.get(i).getSalary());
		}
		
		System.out.println();
		
		Comparator<Person> c = new ComClass();
		Collections.sort(person, c);
		
		for (int i = 0; i<person.size(); i++) {
			System.out.print(person.get(i).getSurname() + " ");
			System.out.print(person.get(i).getFirstname() + " ");
			System.out.println(person.get(i).getSalary());
		}
		
		}
		
		catch (Exception NotCorrectInputVariables){
			System.out.print("Incorrect variable input");
		}
	
	}
}

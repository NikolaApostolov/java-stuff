package practical07;

public class Person implements Comparable<Person>{
	
	public String surname;
	public String first_name;
	public double salary;
	
	public Person (String sn, String fn, double sl) {
		surname = sn;
		first_name = fn;
		salary = sl;
	}
	
	String getSurname() { return surname; }
	
	String getFirstname() { return first_name; }
	
	double getSalary() { return salary; }
	
	void setSurname( String name ) { surname = name; }
	
	void setFirstname( String name ) { first_name = name; }
	
	void setSalary( double newsal ) { salary = newsal; }
	
	public int compareTo(Person temp) {
		
		if (this.getSurname().compareTo(temp.getSurname()) == 0) {
			return this.getFirstname().compareTo(temp.getFirstname());
		}
		else return this.getSurname().compareTo(temp.getSurname());
	}

}

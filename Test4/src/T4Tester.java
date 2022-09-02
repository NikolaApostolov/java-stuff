import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class T4Tester
{
  public void test1() {

    Building b0 = new Building(8, 21.6);
    System.out.println("Council tax for building is: " + b0.getTax());
    // Output should be: 172.8 */
 
  }
  
  public void test2() {

    Flat f0 = new Flat(7, 18.5);
    System.out.println("Council tax for flat is: " + f0.getTax());
    // Output should be: 54.5 */
  }
  
  public void test3() {	   
	
	ArrayList<Building> district = new ArrayList();

    district.add(new Building(12, 15.30));
    district.add(new Flat(11, 16.5)); 
    district.add(new Building(10, 17.0));
    district.add(new Flat(9, 17.5));
    
    double totalTax = 0.0;
    
 	for (int i = 0; i < district.size(); i++) {
			Building focusBuild = district.get(i);
			totalTax = totalTax + focusBuild.getTax();
			}

    System.out.println("Total tax for district is: " + totalTax);
    // Output should be: 542.6 */
   
  }  
  
  public void test4() throws Exception{

	File temp = new File("buildings.txt");
	Scanner scan = new Scanner(temp);
	
	

	    // Output should be: 665.0
  }
}



package practical01;
import java.util.Scanner;

public abstract class Application<E> implements StackADT<E>
{
    /**
     * Constructors for objects of class ArrayStack
     */
    public Application(int capacity)
    {
       
    }
        	
    public static void main(String[] args) {
    
    StackADT<String> NewArr = new ArrayStack<String>(10);
    int set = 0;
    
    	while (set != 19) {
    		Scanner myObj = new Scanner(System.in);
    		System.out.println("You have the comands - push/pop/top/size/is_epmty/quit at your disposal. Please enter a comand: ");
    		String input = myObj.nextLine();
    
    	switch (input) {
    		case "push":  System.out.println("Enter String to be pushed: ");
                  String PopInt = myObj.nextLine();
                  NewArr.push(PopInt);
                  break;
    		case "pop":   System.out.println("The String that poped is: ");
    		      String popString = NewArr.pop();
	              System.out.println(popString);
    	          break;
    		case "top":   System.out.println("The top String is: ");
    	          String topString = NewArr.top();
    	          System.out.println(topString);
    	          break;
    		case "size":  System.out.println("The size of the array-stack is: ");
    	          int sizeString = NewArr.size();
    	          System.out.println(sizeString);
    	          break;
    		case "is_empty": System.out.println("The stack is empty - ");
    	          boolean empString = NewArr.isEmpty();
    	          System.out.println(empString);
    	          break;
    		case "quit": set = 19;
    			  break;    
    		default: System.out.println("Invalid comand. Try again: ");
             	  break;
    		}
    	}

    }     
    
}

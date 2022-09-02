package practical01;

public class ArrayStack<E> implements StackADT<E>
{
    int top;
    E[] S;
    /**
     * Constructors for objects of class ArrayStack
     */
    public ArrayStack(int capacity)
    {
        top = -1;
        S = (E[]) new Object[capacity]; 
        // Casting is used in the above as generic arrays cannot be created using new E[]
    }
    
    public ArrayStack()
    {
    	StackADT<String> NewArr = new ArrayStack<String>(6);
    }

   /** 
     @throws FullStackException
   */
   public void push(E element){
     if (top == S.length-1)
        throw new FullStackException("Stack is full, so cannot push on to stack");
     top++;
     S[top] = element;
   }

   /**
     @throws EmptyStackException
   */
   public E pop(){
     E element;
     if (isEmpty())
        throw new EmptyStackException("Stack is empty, so cannot pop from stack");
     element = S[top];
     top--;
     return element;
   }
    
   /**
     @throws EmptyStackException
   */
   public E top(){
	   E element;
	     if (isEmpty())
	        throw new EmptyStackException("Stack is empty, so cannot top from stack");
	     element = S[top];
	     return element;
   }

   public int size(){
      int arrSize;
      arrSize = top+1;
      return arrSize;
   }

   public boolean isEmpty(){
      if (top == -1)
    	  return true;
      else 
    	  return false;
   }  
}

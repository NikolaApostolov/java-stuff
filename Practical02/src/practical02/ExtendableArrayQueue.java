package practical02;

/**
 * This class is for completion in Practical 3ii
*/
public class ExtendableArrayQueue<E> implements QueueADT<E>
{
   protected E[] Q; // Q will refer to the array
   protected int f; // front - array index of element at front of queue
   protected int r; // rear - array index of where next element added will be placed 
   protected int N;  // array capacity

   /**
    * Constructor for objects of class ExtendableArrayQueue.
    * In practical 3ii no change need be made to this constructor.
    * With this constructor a queue can initially hold up to 
    * 3 (i.e.N-1) items when using the approach described in lectures.
    */
   
   public ExtendableArrayQueue()
   {
       N=4;
       Q = (E[]) new Object[N]; 
       f=0;
       r=0;
   }
   
   // Complete the method bodies below and add any further methods if 
   // appropriate. Many of the method bodies can be the same as in Q3i
   
   public void updateQueue() {

	   
	   N = N+1;
	   E[] NewQ = (E[]) new Object[N];
	   for (int i = 0; i < N-1; i++) {
		   	NewQ[i] = Q[i];
	   }
	   r = size();
	   Q = NewQ;
   }
   
   public int modNum (int Num) {
	   if (Num >= N) {
		   Num = Num - N;
		   return Num;
	   }
	   else return Num;
   }
   
   public void enqueue(E element){
	   if (	size() == N-1) {
		    updateQueue();
		    Q[r] = element;
	   		r = modNum(r+1);
	   }
	   else {
		    Q[r] = element;
	   		r = modNum(r+1);
	   }
   }
   
   /**
     @throws EmptyQueueException
   */
   public E dequeue(){
	   if (isEmpty()) {
		   throw new EmptyQueueException("The Queue is empty.");
	   }
	   else {
		    E e = Q[f];
	   		f = modNum(f+1);
	   		return e;
	   }
   }
   
   /**
     @throws EmptyQueueException
   */
   public E front(){
	   if (isEmpty()) {
		   throw new EmptyQueueException("The Queue is empty.");
	   }
	   else {
		    return Q[f];
	   }
   }

   public int size(){
	   return modNum(N - f + r);
   }

   public boolean isEmpty(){
	   return (f == r);
   }  
}

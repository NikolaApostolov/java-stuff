package testproject;

public class Tests {

	
	// Use we use 'static' for all methods to keep things simple, so we can call those methods main

		static void Assert (boolean res) // We use this to test our results - don't delete or modify!
		{
		 if(!res)	{
			 System.out.print("Something went wrong.");
		 	 System.exit(0);
		 }
		}
		
	    static double [] mult(double a, double [] V) { // multiplying scalar and vector
	    	double [] result = new double[V.length];
	    	for (int i = 0; i < V.length; i++) {
	    		double num = V[i] * a;
	    		result [i] = num;
	    	}
	    	
	    	return result;
	    }
	    static double [] add(double a, double [] V) { // adding scalar and vector
	    	double [] result = new double[V.length];
	    	for (int i = 0; i < V.length; i++) {
	    		double num = V[i] + a;
	    		result [i] = num;
	    	}
	    	
	    	return result;
	    }
	    static double [] sub(double a, double [] V) {  // subtracting a scalar from vector        	    
	    	double [] result = new double[V.length];
	    	for (int i = 0; i < V.length; i++) {
	    		double num = V[i] - a;
	    		result [i] = num;
	    	}
	    	
	    	return result;
	    }
	    
	    static double [] add(double [] U, double [] V) { // adding two vectors
	    	double [] result = new double[V.length];
	    	for (int i = 0; i < V.length; i++) {
	    		double num = U[i] + V[i];
	    		result [i] = num;
	    	}
	    	
	    	return result;
	    }
	    static double [] sub(double [] V, double [] U) { // subtracting vector from vector 
	    	double [] result = new double[V.length];
	    	for (int i = 0; i < V.length; i++) {
	    		double num = V[i] - U[i];
	    		result [i] = num;
	    	}
	    	
	    	return result;
	    }
	    static double dot(double [] U, double [] V) { // dot product of two vectors 
	    	double result = 0;
	    	for (int i = 0; i < V.length; i++) {
	    		double num = U[i] * V[i];
	    		result = result + num;
	    	}
	    	
	    	return result;
	    }
	    
	    static void PrintVector(double X[]){  
	       	
	        for(int i = 0; i < X.length; i++) {
	    		System.out.print(X[i]);
	    		System.out.print(' ');
	        }
	    	    
	    }
	   
	    static class Perceptron {   

			double W [];
		    public Perceptron(double [] Wi){ 
		    	W = Wi; 
		    }   
	   
		   double output(double [] X){  // The prediction that the Perceptron makes.
		
		   	double activation = dot(W, X);  
		       if (activation  >= 0)
		           return 1;     
		       else
		           return 0;
		   }
		
		   public void Train(double X[], int label) {  
		
		        double prediction = output(X);  
		        double error = label - prediction;
		       
				System.out.print("training on ");
				PrintVector(X);
				System.out.print(" label = ");
				System.out.print(label);
				System.out.print(" prediction = ");
				System.out.print(prediction);
				System.out.print(" error = ");
				System.out.print(error);
		
		        W = add(W, mult(error, X)); 
		
				System.out.print(" updated weights = ");
				PrintVector(W);
				System.out.println("");        
		   }
	}
	  
	   public static void main(String[] args)  {  

	       Perceptron P = new Perceptron(new double[]{0,0,0,0}); 
	       for (int epoch = 0; epoch < 11; epoch++) { 
	    	   System.out.print("epoch ");	
	    	   System.out.println(epoch);
			   P.Train(new double[]{1,0,0,1}, 0);   
			   P.Train(new double[]{0,1,0,1}, 1);  
			   P.Train(new double[]{0,0,1,1}, 1);  
			   P.Train(new double[]{0,0,0,1}, 1);  
			   P.Train(new double[]{0,1,1,1}, 0);
	       }	   
		   System.out.print("Finished ok.");
		   	
    	
	}

		
		
	}



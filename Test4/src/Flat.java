
public class Flat extends Building {
	
	public Flat (int windowAmount, double chargeAmount) {
		  super(windowAmount, chargeAmount);
		  
	  }
	
	public double getTax() {
		  double tax = super.getTax() - 75;
		  return tax;
	  }
}

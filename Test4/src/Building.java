public class Building
{
  private int windows;
  private double charge;
  
  public Building (int windowAmount, double chargeAmount) {
	  windows = windowAmount;
	  charge = chargeAmount;
  }
  
  public double getTax() {
	  double tax = 0.0;
	  tax = windows*charge;
	  return tax;
  }
  
  
  
}


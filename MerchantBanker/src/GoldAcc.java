public class GoldAcc extends SaveAcc {

	private double minBal;
	
	public GoldAcc(int acc, double bal, int rate, double minB) {
		super(acc, bal, rate);
		minBal = minB;
	}
	
	public void setMinBalance(double minB) {
		minBal = minB;
	}
	
	public double getMinBalance() {
		return minBal;
	}
	
	public boolean withdraw(double amount) {
		double operation = super.getBalance() - amount;
		
		if (minBal > operation ) {
			return false;
		} else 
			super.withdraw(amount);
			return true;
	}

}



import java.util.ArrayList;

public class MerchantBank {
	
	private ArrayList<BasicAccount> accounts;
	
	public MerchantBank() {
		
		accounts = new ArrayList();
		
	}
	
	public void openAccount(int number, char type) {
		
		if (type == 'K') {
			KidsAcc newAcc = new KidsAcc(number, 0.0, 1);
			accounts.add(newAcc);
		}
		if (type == 'B') {
			BasicAccount newAcc = new BasicAccount(number, 0.0);
			accounts.add(newAcc);
		}
		if (type == 'S') {
			SaveAcc newAcc = new SaveAcc(number, 0.0, 3);
			accounts.add(newAcc);
		}
		
	}
	
	private BasicAccount findAcc(int num) {
		for (int i = 0; i < accounts.size(); i++) {
			BasicAccount focusAcc = accounts.get(i);
			if(focusAcc.getAccNumber() == num) {
				return focusAcc;
			}
		}
		return null;
	}
	
	public boolean deposit(int number, double amount) {
		BasicAccount acc = findAcc(number);
		if (acc == null) {
			return false;
		}
		
		acc.deposit(amount);
		
		return true;
	}
	
	public boolean withdraw(int number, double amount) {
		BasicAccount acc = findAcc(number);
		if (acc == null) {
			return false;
		}
		
		return acc.withdraw(amount);
		
	}
	
	public double balance(int number) {
		BasicAccount acc = findAcc(number);
		if (acc == null) {
			return -1.0;
		}
		
		return acc.getBalance();
	}		

	public double totalAssets() {
        double balance = 0.0;
		
		for (int i = 0; i < accounts.size(); i++) {
			BasicAccount focusAcc = accounts.get(i);
			balance = balance + focusAcc.getBalance();
			}
		
		return balance;
	}

}

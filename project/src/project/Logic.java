package project;

public class Logic {
	private double Balance;
	private String transactions[] = new String[5];
	private int a=0,b=0,c=0,maxIndex=0;
	public int getB() {
		return b;
	}
	public int getMaxIndex() {
		return maxIndex;
	}
	public Logic(double intialBalance) {
		if (intialBalance>0.0) {
			Balance = intialBalance;
		}
		
	}
	public void Deposit( double amount) {
		Balance = Balance + amount;
	}
	public void Withdraw(double amount) {
		Balance -= amount;
	}
	public double getBalance() {
		return Balance;
	}
	
 public boolean validate(double amount){
	 if (amount > 0 && amount < Balance){
		 return true;
	 }else return false;
	 
 }
 public boolean stringChecker(String input)
 {	
	 
	 if(input.matches("-?\\d+(\\.\\d+)?"))
			 return true;
		 
	 else return false;
 }
 public void saveTransactions(String amount){
		if(a<=4){
			transactions[a]=amount;
			b=a;
			maxIndex=a;
			a++;
		} else {
			c=0;
			while(c<4){
				transactions[c]=transactions[c+1];
				c++;
			}
			transactions[c]=amount;
			a--;
			b=a;
		}
	}
 public String previous(){
		if (b > 0 && b <= maxIndex){
			--b;
		}
		return transactions[b];
	}
 public String next(){
		if (b >= 0 && b < maxIndex){
			++b;
		}
		return transactions[b];
	}
}

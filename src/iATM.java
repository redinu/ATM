
public interface iATM {
	
	public double deposit(long accountNo , int pin, double amount );
	public double withdraw(long accountNo,int pin, double amount);
	public double checkBalance(long accountNo,int pin);
	//public double showTransaction();
	

}

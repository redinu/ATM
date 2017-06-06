import java.util.Date;

public abstract class Receipt {
	
	public abstract void printReceipt(Date date, User user,Account account, ATM atm, String transactionType );

}

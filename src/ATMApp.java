import java.util.Date;
import java.util.Scanner;

public class ATMApp {
	
	

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		ATM atm = new ATM();
		
		String transactionType;
		
		
		System.out.println("Welcome! Please enter your account number");
		long accNo = scn.nextLong();
		System.out.println("Enter your PIN number");
		int pin = scn.nextInt();
		
		scn.nextLine();
		
		Account account = atm.getAccount(accNo, pin);
		
		if(account!=null){
		
		System.out.println("Do you want to withdraw, deposit or check balance?");
		String entry = scn.nextLine();
		
		if(entry.equalsIgnoreCase("withdraw")){
			transactionType = "withdrawal";
			System.out.println("Enter the amount you want to withdraw");
			double amount = scn.nextDouble();
			atm.withdraw(account.getAccountNumber(), account.getPin() , amount);
			atm.printReceipt(new Date(), atm.user, account, atm, transactionType);
			
		}else if( entry.equalsIgnoreCase("deposit")){
			transactionType = "deposit";
			System.out.println("Enter the amount you want to deposit");
			double amount = scn.nextDouble();
		    atm.deposit(account.getAccountNumber(), account.getPin(), amount);
		    atm.printReceipt(new Date(), atm.user, account, atm, transactionType);
		}else{
			System.out.println("Account Balance: " + account.getBalance());
		}

	}
		System.out.println("Good Bye");
	} 
}

import java.util.Date;
import java.util.Scanner;

public class ATM extends Receipt implements iATM{
	
	Scanner scn = new Scanner(System.in);
	Account account = new Account();
	User user = new User();
	String transactionType;
	String transactionAmount;
	
	
	
	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public Account getAccount(long accountNo, int pin){
		
			
			if(accountNo == 1000112345 ){
				if(pin == 1234){
					
					
					user.setFirstName("Rachel");
					user.setLastName("Green");
					account.setAccountNumber(1000112345);
					account.setPin(1234);
					account.setUser(user);
					account.setBalance(5000);
					
					
				}else{
					do {
						int counter = 1;
						if(counter < 3){
							System.out.println("You entered wrong PIN.Try Again.");
							pin = scn.nextInt();

						} else {
							System.out.println("Sorry your account is locked.");
						}
					}while(pin !=1234);
					
					if (pin == 1234){
						
						User user = new User();
						user.setFirstName("Rachel");
						user.setLastName("Green");
						account.setAccountNumber(1000112345);
						account.setPin(1234);
						account.setUser(user);
						account.setBalance(5000);
						
						
					}
				}
			}else if (accountNo == 1000112346){
				if(pin == 9089){
					
					User user = new User();
					user.setFirstName("Jack");
					user.setLastName("Andrew");
					account.setAccountNumber(1000112346);
					account.setPin(9089);
					account.setUser(user);
					account.setBalance(10000);
					
					
				}else{
					do{
						int counter = 1;
						if(counter < 3){
							System.out.println("You entered wrong PIN.Try Again.");
							pin = scn.nextInt();

						} else {
							System.out.println("Sorry your account is locked.");
						}
					}while(pin !=9089);
					
					if(pin == 9089){
						
						User user = new User();
						user.setFirstName("Jack");
						user.setLastName("Andrew");
						account.setAccountNumber(1000112346);
						account.setPin(9089);
						account.setUser(user);
						account.setBalance(10000);
						
						
					}
				}
			}else{
					System.out.println("Incorrect Account Number.");
					
				}
			
				return account;
			}
	   

	@Override
	public double deposit( long accountNo,int pin, double amount) {
		
		Account account = getAccount(accountNo, pin);
		
	    account.setBalance( account.getBalance() + amount);
		double newBalance = account.getBalance();
		 
		return newBalance;
	}

	@Override
	public double withdraw(long accountNo,int pin, double amount) {
		
		Account account = getAccount(accountNo, pin);
		
		 
		if(account.getBalance() > amount){
			account.setBalance( account.getBalance() - amount);
		} else {
			do {
				System.out.println("you don't have enough balance. Enter less amount");
				amount = scn.nextDouble();
			    } while(amount > account.getBalance());
			
			if (account.getBalance() >= amount){
				account.setBalance( account.getBalance() - amount);
			}
		
		}
		double newBalance = account.getBalance();
		 
		return newBalance;
	}

	@Override
	public double checkBalance(long accountNo,int pin) {
		
		account = getAccount(accountNo, pin);
		
		return account.getBalance();
	}

//	@Override
//	public double showTransaction() {
//		
//		
//		return ;
//	}
	
	public void printReceipt(Date date, User user,Account account, ATM atm ){
		
		System.out.println("+--------------------------------------+");
		System.out.println("|      Chase Bank ATM Receipt           |");
		System.out.println("|      Wednesday, December 2, 2015     |");
		System.out.println("|      ATM Location # 123              |");
		System.out.println("|                                      |");
		System.out.println("|                                      |");
		System.out.println("|      Account Number:      " + account.getAccountNumber() + "    |");
		System.out.println("|      Customer:     " + account.getUser().getFirstName() + account.getUser().getLastName()+ "     |");
		System.out.println("|      Transaction Type:    " + atm.getTransactionType() + "    |");
		System.out.println("|      Transaction Amount:  " + atm.getTransactionAmount()+ "    |");
		System.out.println("|      Account Balance:   " + atm.checkBalance(account.getAccountNumber(), account.getPin()) + "    |");
		System.out.println("|                                      |");
		System.out.println("|      Thank you for banking with us   |");
		System.out.println("|            Have a coffee day         |");
		System.out.println("|                                      |");
		System.out.println("+--------------------------------------+");
		
	}
}

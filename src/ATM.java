import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ATM extends Receipt implements iATM{
	
	Scanner scn = new Scanner(System.in);
	Account account = new Account();
	User user = new User();
	String transactionType;
	Double transactionAmount;
	boolean balanceCheck = false;
	
	
	
	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public Double getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(Double transactionAmount) {
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
					int counter = 1;
					do {
						if(counter < 3){
							System.out.println("You entered wrong PIN.Try Again.");
							pin = scn.nextInt();
							counter++;

						} else {
							System.out.println("Sorry your account is locked.");
							break;
						}
					}while(pin !=1234);
					
					if (pin == 1234){
						
						User user = new User();
						user.setFirstName("Rachel");
						user.setLastName("Green");
						account.setAccountNumber(1000112345);
						account.setPin(1234);
						account.setUser(user);
						account.setBalance(5000.00);
					}else{
						 account = null;
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
					account.setBalance(10000.00);
					
					
				}else{
					int counter = 1;
					do{
						if(counter < 3){
							System.out.println("You entered wrong PIN.Try Again.");
							pin = scn.nextInt();
							counter++;
						} else {
							System.out.println("Sorry your account is locked.");
							break;
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
						
					}else{
						account = null;
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
		transactionAmount = amount;
		
	    account.setBalance( account.getBalance() + amount);
		double newBalance = account.getBalance();
		 
		return newBalance;
	}

	@Override
	public double withdraw(long accountNo,int pin, double amount) {
		
		Account account = getAccount(accountNo, pin);
		transactionAmount = amount;
		 
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
		
		balanceCheck = true;
		
		Account account = getAccount(accountNo, pin);
		
		return account.getBalance();
	}

//	@Override
//	public double showTransaction() {
//		
//		
//		return getTransactionAmount();
//	}
	
	public void printReceipt(Date date, User user,Account account, ATM atm, String transactionType ){
		
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
		
		
		
		if(!balanceCheck){
			
		
		System.out.println("+---------------------------------------------+");
		System.out.println("|      Chase Bank ATM Receipt                 |");
		System.out.println("|          " + formatter.format(new Date()) + "                        |");
		System.out.println("|      ATM Location # 123                     |");
		System.out.println("|                                             |");
		System.out.println("|                                             |");
		System.out.println("|      Account Number:   " + account.getAccountNumber() + "          |");
		System.out.println("|      Customer:     " + account.getUser().getFirstName() + " " + account.getUser().getLastName()+ "              |");
		
		if(transactionType.equalsIgnoreCase("withdrawal")){
			System.out.println("|      Transaction Type:    " + transactionType + "        |");
		}else{
			System.out.println("|      Transaction Type:    " + transactionType + "           |");	
		}
		System.out.println("|      Transaction Amount:  " + getTransactionAmount()+ "             |");
		
		if(transactionType.equalsIgnoreCase("withdrawal")){
		System.out.println("|      Account Balance:   " + (checkBalance(account.getAccountNumber(), account.getPin())-getTransactionAmount()) + "              |");
		} else {
			System.out.println("|      Account Balance:   " + (checkBalance(account.getAccountNumber(), account.getPin())+getTransactionAmount()) + "              |");	
		}
		
		System.out.println("|                                             |");
		System.out.println("|      Thank you for banking with us          |");
		System.out.println("|            Have a nice day                  |");
		System.out.println("|                                             |");
		System.out.println("+---------------------------------------------+");
		
		}else{
			System.out.println("+--------------------------------------+");
			System.out.println("|      Chase Bank ATM Receipt          |");
			System.out.println("|      Wednesday, December 2, 2015     |");
			System.out.println("|      ATM Location # 123              |");
			System.out.println("|                                      |");
			System.out.println("|                                      |");
			System.out.println("|      Account Number:      " + account.getAccountNumber() + " |");
			System.out.println("|      Customer:     " + account.getUser().getFirstName() + account.getUser().getLastName()+ "        |");
			System.out.println("|      Account Balance:   " + checkBalance(account.getAccountNumber(), account.getPin()) + "      |");
			System.out.println("|                                      |");
			System.out.println("|      Thank you for banking with us   |");
			System.out.println("|            Have a nice day           |");
			System.out.println("|                                      |");
			System.out.println("+--------------------------------------+");
		
		}
		
	}
}

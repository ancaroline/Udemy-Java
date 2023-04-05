// UPCASTING E DOWNCASTING
/*
- UPCASTING:
	Casting da subclasse para superclasse -> subindo da sub para super
	Uso comum: polimorfismo

- DOWNCASTING:
	Casting da superclasse para subclasse 
	'-> é como se eu tivesse um objeto do tipo super e quisesse atribuir esse objeto para uma variável do tipo sub
	Palavra instanceof
	Uso comum: métodos que recebem parâmetros genéricos (ex: Equals)
*/

// EXEMPLO

*/
// Generalização
package entities;
public class Account {
	private Integer number;
	private String holder;
	protected Double balance;  // PARA QUE O BALANCE SEJA ACESSADO PELA SUBCLASSE SEM SER PUBLIC.

	private Account() {
	}

	private Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}

	public void deposit(double amount) {
		balance += amount;
	}
}

// Especialização - extensão
package entities;
public class BusinessAccount extends Account {

	private Double loanLimit;

	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;

	public void loan(double amount) {
		if (amount <= loanLimit) {
			balance += amount - 10.0;
		}
		
	}
}

// Especialização
package entities;
public class SavingsAccount extends Account {

	private Double interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public void updateBalance() {
		balance += balance * interestRate;
	}
}

// Program
package application;
import entities.Account;
import entities.BusinessAccount;
import.entities.SavingsAccount;

public class Program {
	public static void main(String[] args) {
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		// UPCASTING
		// Pegar uma variável do tipo BusinessAccount e atribuí-lo para uma variável do tipo Account
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.1);

		// DOWNCASTING
		// Converter um objeto da super para a sub
		BusinessAccount acc4 = acc2; // ISTO É ERRADO
		BusinessAccount acc4 = (BusinessAccount)acc2; // ISTO É CERTO
		acc4.loan(100.0);

		BusinessAccount acc5 = (BusinessAccount)acc3; // ISTO É ERRADO, POIS acc3 é SavingsAccount E NÃO BusinessAccount.
		// Testando se acc3 é do tipo BusinessAccount
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Loan");
		}

		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
	}
}
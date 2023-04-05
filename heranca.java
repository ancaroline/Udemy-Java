// HERANÇA
/* Tipo de associação que permite que uma classe herde todos dados e
comportamento de outra.

Vantagens:
	Reuso
	Polimorfismo

Sintaxe
	class A extends B


Exemplo: Suponha um negócio de banco que possui uma conta comum e uma conta para empresas.
Sendo que a conta para empresa possui todos membros da conta comum, mais um limite de empréstimo
e uma operação de realizar empréstimo.

Account
	- number: Integer
	- holder: String
	- balance: Double

	+ withdraw(amount: Double): void
	+ deposit(amount: Double): void

Business Account
	- number: Integer
	- holder: String
	- balance: Double
	- loanLimit: Double

	+ withdraw(amount: Double): void
	+ deposit(amount: Double): void
	+ loan(amount: Double): void


Busines Account irá herdar de Account, então irá especificar somente o que ela não tem em comum.
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

// MODIFICADOR DE ACESSO PROTECTED


// CLASSES ABSTRATAS
/* 	São classes que não podem ser instanciadas.
	É uma forma de garantir herança total: 
		somente subclasses não abstratas podem ser instanciadas, 
		mas nunca a superclasse abstrata.

// EXEMPLO
Suponha que em um negócio relacionado a banco, apenas contas
poupança e contas para empresas são permitidas. Não existe conta comum.

Para garantir que contas comuns não possam ser instanciadas,
basta acrescentarmos a palavra "abstract" na declaração da classe.
*/
public abstract class Account {

}

// não poderei instanciar a classe Account
// QUESTIONAMENTO
/*
	Se a classe Account não pode ser instanciada, por que simplesmente
	não criar somente SavingsAccount e BusinessAccount?

	Resposta:
		- Reuso
		- Polimorfismo: a superclasse genérica nos permite tratar de forma
		fácil e uniforme todos os tipos de conta, inclusive com polimorfismo
		se for o caso (como fizemos nos últimos exercícios). Por exemplo,
		você pode colocar todos tipos de contas em uma mesma coleção.
	
	Demo:
		Suponha que você queira:
			Totalizar o saldo de todas as contas.
			Depositar 10.00 em todas as contas.
*/
// Refatorando o exercício de fixação - polimorfismo - para exemplificar
package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		List<Account> list = new ArrayList<>();
		list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
		list.add(new BusinessAccount(1002, "Maria", 1000.00, 0.01));
		list.add(new SavingsAccount(1003, "João", 1500.00, 0.01));
		list.add(new BusinessAccount(1004, "Arthur", 800.00, 0.01));

		// totalizar o saldo dessas contas
		double sum = 0.0;
		for (Account acc : list) {
			sum += acc.getBalance();
		}

		System.out.printf("Total balance: %.2f%n", sum);

		// depositar o valor de 10.00 a cada conta
		for (Account acc : list) {
			acc.deposit(10.0);
		}
		// imprimir o saldo de cada conta
		for (Account acc : list) {
			System.out.printf("Updated balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
		}

	}
}

/*
CLASSES E MÉTODOS FINAL

Palavra chave: final
Classe: evita que a classe seja herdada.

	public final class SavingsAccount {
	}

Método: evita que o método sob seja sobreposto.

	@Override
	public final void Withdraw(double amount) {
		Balance -= amount;
	}
*/
// Exemplo
package entities;
public class SavingsAccountPlus extends SavingsAccount {

	@Override
	public final void Withdraw(double amount) {
		Balance -= amount + 2.0;
	}
}

/* Para quê utilizar?

	- Segurança: dependendo das regras do negócio, às vezes é desejável
	garantir que uma classe não seja herdada, ou que um método não seja
	sobreposto.
		Geralmente convém acrescentar final em métodos sobrepostos, pois
		sobreposições múltiplas podem ser uma porta de entrada para
		inconsistências.

	- Performance: atributos de tipo de uma classe final são analisados de
	forma mais rápida em tempo de execução.
		Exemplo: String
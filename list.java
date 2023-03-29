// LISTAS - PARTE 1
/* É uma estrutura de dados:
	- Homogênea
	- Ordenada
	- Inicia vazia e seus elementos são alocados sob demanda
	- Cada elemento ocupa um nó da lista

Tipo (interface): List  -> Interface é um tipo que define apenas a especificação das operações
Não é possível instanciar uma interface.
Para instanciar um tipo List será necessário uma classe que implemente a interface:
		-> Classes que implementam: ArrayList, LinkedList

Vantagens: 
	Tamanho variável
	Facilidade para se realizar inserções e deleções
Desvantagens:
	Acesso sequencial aos elementos -> porém, dependendo da implementação da lista, a navegação é otimizada


DEMO:
	- Tamanho da lista: 
			size()
	- Inserir elemento na lista: 
			add(obj), add(int, obj)
	- Remover elementos da lista: 
			remove(obj), remove(int, obj)
	- Encontrar posição de elemento:
			indexOf(obj), lastIndexOf(obj)
	- Filtrar lista com base em predicado:
			List<Integer> result = list.stream().filter(x -> x > 4).collect(Collectors.toList());
	- Encontrar primeira ocorrência com base em predicado:
			Integer result = list.stream().filter(x -> x > 4).findFirst().orElse(null);

*/

// Declarando uma lista de números inteiros
package application;

import java.util.List;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>;

		// Adicionar elementos na lista
		list.add("Maria");
		list.add("Alex");
		list.add("Ana");
		list.add("Marcio");
		list.add("Paulo");
		list.add("Paula");
		list.add("Teresa");
		// Como inserir um novo elemento na posição dois
		list.add(2, "Marco");

		// Como saber o tamanho da lista
		System.out.println(list.size());

		// Como remover um elemento da lista
		list.remove("Ana")
		list.remove(1)

		// Testando a lista
		for (String x : list) {  // para cada string x pertencente a list
			System.out.println(x);
			// Resultado:
			// Maria
			// Marco
			// Marcio
			// Paulo
			// Paula
			// Teresa
		}

		// podemos remover elementos que atendem a um predicado
		list.removeIf(x -> x.charAt(0) == 'M');  // remover todo o string x, tal que, x.char na posição 0 seja igual a M.

		// Testando a lista
		for (String x : list) {  // para cada string x pertencente a list
			System.out.println(x);
			// Resultado:
			// Paulo
			// Paula
			// Teresa
		} 

		// Encontrar a posição de um elemento
		System.out.println("Index of Paulo: " + list.indexOf("Paulo"));
		System.out.println("Index of Carlos: " + list.indexOf("Carlos")); // Retornará -1, pois não será encontrado.

		// Manter na lista apenas elementos que começam com a Letra P
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'P').collect(Collectors.toList());
		// é preciso converter o stream para lista, por isso chamaremos o collect

		// Testando a lista result
		for (String x : result) {
			System.out.println(x);
			// Resultado:
			// Paulo
			// Paula
		}

		// Como encontrar um elemento da lista que atenda um certo predicado
		String name = list.stream().filter(x -> x.charAt(0) == 'T').findFirst().orElse(null);
		// se o elemento não existir, irá retornar nulo.
		System.out.println(name);
}
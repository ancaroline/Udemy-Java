// ARRAYS
/* Vetor é o nome dado a arranjos unidimensionais.
Arranjo (array) é uma estrutura de dados:
	- Homogênea
	- Ordenada
	- Alocada de uma vez só, em um bloco contíguo de memória

Vantagens:
	- Acesso imediato aos elementos pela sua posição
Desvantagens:
	- Tamanho fixo
	- Dificuldade para se realizar inserções e deleções
*/

// Exemplo 1:
/* Fazer um programa para ler um número inteiro N e a altura de N pessoas.
Armazene as N alturas em um vetor. Em seguida, mostrar a altura média dessas pessoas. */

package application;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		double[] vect = new double[n]; // Os colchetes indicam que estou declarando um vetor. 
		// A variável vai receber a instanciação do vetor. Como? Recebendo "new" + o tipo do elemento + o tamanho do vetor

		for (int i=0; i<n; i++) {
			vect[i] = sc.nextDouble();  // pois na primeira vez que entrar no laço, o i valerá 0
			// então, o vect no valor 0 receberá o primeiro valor do vetor e assim por diante.
		}

		// Calcular a soma de todos os elementos no vetor
		double sum = 0.0;
		for (int i=0; i<n; i++) {
			sum += vect[i];
		}

		// Calcular a médoa
		double avg = sum / n;

		System.out.println("AVERAGE HEIGHT: " + avg);
		// Para limitar as casas decimais
		System.out.printf("AVERAGE HEIGHT: %.2f%n", avg);

		sc.close();
	}
}

// Vetor cujo objetos são do tipo classe
// Exemplo 2
/* Fazer um programa para ler um número inteiro N e os dados (nome e preço) de N Produtos.
Armazene os N produtos em um vetor. Em seguida, mostrar o preço médio dos produtos.
*/

package application;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Product[] vect = new Product[n]; // tipo do vetor é Product

		for (int i=0; i<n; i++) {
			sc.nextLine(); // pois, foi dado um nextInt no começo e a quebra de linha ficou pendente
			String name = sc.nextLine();
			double price = sc.nextDouble();

			vect[i] = new Product(name, price);  // instanciar um novo produto
		}

		// Calcular a soma de todos os elementos
		double sum = 0.0;
		for (int i=0; i<n; i++) {
			sum += vect[i].getPrice();  // acessando o vetor na posição i somando apenas o preço. 
		}

		// Calculando a média
		double avg = sum / n;
		System.out.printf("AVERAGE PRICE: %.2f%n", avg);

		sc.close();
	}
}

// Classe
package entities;

public class Product {

	private String name;
	private double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}


// Poderia não utilizar a variável n no laço for:
// vect.lenght
// OBS: a variável n é mantida.
// Exemplo: 

		int n = sc.nextInt();
		Product[] vect = new Product[n];


		for (int i=0; i<vect.length; i++) {
			sc.nextLine();
			String name = sc.nextLine();
			double price = sc.nextDouble();

			vect[i] = new Product(name, price);
		}

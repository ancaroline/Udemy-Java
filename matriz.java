// MATRIZES
/*
	- Vantagens: Acesso imediato aos elementos pela sua posição.
	- Desvantagens: Tamanho fixo; Dificuldade para se realizar inserções e deleções;
*/
// Exercício
/*Fazer um programa para ler um número inteiro N e uma matriz de ordem N contendo números inteiros.
Em seguida, mostrar a diagonal principal e a quantidade de valores negativos da matriz. */

package application;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		// criando matriz
		int[][] mat = new int[n][n];

		// percorrendo a matriz
		for (int i=0; i<n; i++) {
			// percorrendo as colunas
			for (int j=0; j<n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}

		System.out.println("Main diagonal:");
		for (int i=0; i<n; i++) {
			System.out.print(mat[i][i] + " ");
		}
		System.out.println();

		// contando os números negativos
		int count = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (mat[i][j] < 0) {
					count++;
				}
			}
		}
		System.out.println("Negative numbers: " + count);

		sc.close();
	}
}

// Propriedade length
/*
for (int i=0; i<mat.length; i++) {
	// percorrendo as colunas
	for (int j=0; j<mat[i].length; j++) {
		mat[i][j] = sc.nextInt();
		}
	}

Sempre que tiver a quantidade de linhas, eu posso trocar pelo nomedovetor.length
Quantidade de colunas: nomedovetor[i].length 
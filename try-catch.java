// ESTRUTURA TRY-CATCH
/*
	- Bloco try:
		Contém o código que representa a execução normal do trecho de código que
		PODE acarretar em uma exceção.
	- Bloco catch:
		Contém o código a ser executado caso uma exceção ocorra.
		Deve ser especificado o tipo da exceção a ser tratada (upcasting é permitido).

Sintaxe:
	
	try {
	
	}
	catch (ExceptionType e) {
	
	}
	catch (ExceptionType e) {
	
	}
*/
// EXEMPLO
package application;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position.");
		}
		catch (InputMismatchException e) {
			System.out.println("Input error.");
		}
		System.out.println("End of program");

		sc.close();
	}
}
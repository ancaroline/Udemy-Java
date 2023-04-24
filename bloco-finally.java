// BLOCO FINALLY
/* É um bloco que contém código a ser executado independentemente de ter ocorrido ou não
uma exceção.
Exemplo: fechar um arquivo, conexão de banco de dados ou outro recurso específico ao final
do processamento.

Sintaxe:
	try {
	
	}
	catch () {
	
	}
	finally {
	
	}
*/
// EXEMPLO
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		File file = new File("C:\\temp\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.NextLine());
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error opening file: " + e.getMessage());
		}
		finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
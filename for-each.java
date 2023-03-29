// LAÇO FOR EACH
/* Sintaxe opcional e simplificada para percorrer coleções

Sintaxe:

for (Tipo apelido : coleção) {
	<comando 1>
	<comando 2>
}

O for vai percorrer chamando cada coleção pelo apelido.
*/

package application;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		String[] vect = new String[] {"Maria", "Bob", "Alex"};

		for (int i=0; i<vect.length; i++) {
			System.out.println(vect[i]);
			// Resultado:
			// Maria
			// Bob
			// Alex
		}

		// Utilizando FOR EACH
		for (String obj : vect) {  // -> para cada objeto 'obj' contido em vect, faça:
			System.out.println(obj);
			// Resultado:
			// Maria
			// Bob
			// Alex

		}

	}
}
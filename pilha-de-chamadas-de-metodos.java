// PILHA DE CHAMADAS DE MÉTODOS

package application;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		
		method1();
		System.out.println("End of program");

	}

	public static void method1() {
		System.out.println("**METHOD1 START**");
		method2();
		System.out.println("**METHOD1 END**");
	}

	public static void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("**METHOD2 START**");

		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position.");
			e.printStackTrace();  // vai imprimir na tela o rastreamento do stack [não é preciso colocar]
		}
		catch (InputMismatchException e) {
			System.out.println("Input error.");
		}
		
		sc.close();
		System.out.println("**METHOD2 END**");
	}
}

// Exemplo de funcionamento normal:
/*
Console:
**METHOD1 START**
**METHOD2 START**
Alex Maria Bob
2
Bob
**METHOD2 END**
**METHOD1 END**
End of program
*/

// Exemplo de funcionamento com except:
// Sem o e.printStackTrace();
/*
Console:
**METHOD1 START**
**METHOD2 START**
Alex Maria Bob
5
Invalid position.
**METHOD2 END**
**METHOD1 END**
End of program
*/

// Exemplo de funcionamento com except:
// COM o e.printStackTrace();
/*
Console:
**METHOD1 START**
**METHOD2 START**
Alex Maria Bob
5
Invalid position.
java.lang.ArrayIndexOutOfBoundsException: 5
	at application.Program.method2(Program.java:29)
	at application.Program.method1(Program.java:18)
	at application.Program.main(Program.java:11)

**METHOD2 END**
**METHOD1 END**
End of program
*/
package model.exceptions;

// Qual a diferença entre Exception e RuntimeException?
/* RuntimeException é um tipo de exceção que o compilador não obriga você a tratar,
 * porém com Exception, o compilador vai obrigar o tratamento.
 */
public class DomainException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}

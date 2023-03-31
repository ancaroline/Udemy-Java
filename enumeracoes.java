// ENUMERAÇÕES
/* Serve para representar vários tipos que possuem um conjunto de constantes relacionadas, por exemplo:
	- Ciclo de vida de um pedido [PendingPayment - Processing - Shipped - Delivered]
		Esse ciclo pode ser representado por uma enumeração ou tipo enumerado.

	É um tipo especial que serve para especificar de forma literal um conjunto de constantes
	relacionadas.

	Palavra chave: enum

	Vantagem: melhor semântica, código mais legível e auxiliado pelo compilador.
*/

package entities.enums;
public enum OrderStatus {
	PENDING_PAYMENT,
	PROCESSING,
	SHIPPED,
	DELIVERED;
}

package entities;
import java.util.Date;
import entities.enums.OrderStatus;
public class Order {
	private Integer id;
	private Date moment;
	private OrderStatus status;

	(...)
}

// EXEMPLO DE PROGRAMA

package application;

import java.util.Date;
import entities.Order;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) {
		Order order = new Order(1000, new Date(), OrderStatus.PENDING_PAYMENT);

		OrderStatus os1 = OrderStatus.DELIVERED;
		OrderStatus os2 = OrderStatus.valueof("DELIVERED");
	}
}

// É PRECISO CRIAR O TIPO ENUM. AO INVÉS DE CRIAR O ARQUIVO CLASSE, CRIE O ARQUIVO COM NOME ENUM.
package entities.enums;

public enum OrderStatus {

	PENDING_PAYMENT,
	PROCESSING,
	SHIPPED,
	DELIVERED;
}

// AGORA SERÁ NECESÁRIO CRIAR A CLASSE PEDIDO.
// EM UM PACOTE DIFERENTE
package entities;
public class Order {
	private Integer id;
	private Date moment;
	private OrderStatus status;

	public Order() {

	}

	public Order(Integer id, Date moment, OrderStatus status) {
		this. id = id;
		this.moment = moment;
		this.status = status;
	}

	public Integer id getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status.
	}
}

// CONVERSÃO DE STRING PARA ENUM
OrderStatus os1 = OrderStatus.DELIVERED;
OrderStatus os2 = OrderStatus.valueof("DELIVERED"); // valueof irá converter para enumm

// NOTAÇÃO UML
/*
	PENDING_PAYMENT: int = 0
É possível colocar um esteriótipo para cada tipo enumerado, exemplo:
	<<enum constant>> PENDING_PAYMENT: int = 0
*/
// Criando exceções personalizadas
// Problema exemplo
/* Fazer um programa para ler os dados de uma reserva de hotel (número do quarto,
data de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em dias.
Em seguida, ler novas datas de entrada e saída, atualizar a reserva e mostrar novamente
a reserva com os dados atualizados. O programa não deve aceitar dados inválidos para a
reserva, conforme as seguintes regras:
 - Alterações de reserva só podem ocorrer para datas futuras
 - A data de saída deve ser maior que a data de entrada

 Reservation
 - roomNumber : Integer
 - checkin : Date
 - checkout : Date
 + duration() : Integer
 + updateDates(checkin : Date, checkout : Date) : void


 Solução 1 (muito ruim) - lógica de validação no programa principal
 Solução 2 (ruim) - método retornando string
 Solução 3 (boa) - tratamento de exceções
 */

// SOLUÇÃO 1 - MUITO RUIM
// program
package application;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Program {
	public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc,nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            // cria uma data de agora
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates.");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }
        sc.close();
	}
}

// reservation
package model.entities;

import java.util.Date;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

    // para conseguir converter a data para dd/mm/yyyy
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    // a diferença entre duas datas
    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime(); // milissegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILISECONDS); // converte o miliseconds para dias.
    }

    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut
    }

    @Override
    public String toString() {
        return "Room "
            + roomNumber
            + ", check-in: "
            + sdf.format(checkIn)
            + ", check-out: "
            + sdf.format(checkOut)
            + ", "
            + duration()
            + "nights";
    }

}
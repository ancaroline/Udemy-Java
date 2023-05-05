//  Solução 2 (ruim) - método retornando string

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

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
            	System.out.println("Error in reservation: " + error);
            }
            else {
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

    public String updateDates(Date checkIn, Date checkOut){
    	Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Reservation dates for update must be future dates.";
        }
        if (!checkOut.after(checkIn)) {
            return "Check-out date must be after check-in date.";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut
        return null;
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
package reservas_java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        reservas reserva1 = new reservas("Rodrigo Pinto", "pintinhoamarelinho@gmail.com", "969696969", 1, "20:00", "16/11/2024", "4", "16/10/2024");
        reservas reserva2 = new reservas("José Preto", "torradaqueimada@gmail.com", "969696969", 2, "22:00", "10/11/2024", "3", "20/10/2024");
        reservas reserva3 = new reservas("Gaybriel Tola", "gaybizindeles2006@gmail.com", "969696969", 3, "22:00", "10/11/2024", "3", "20/10/2024");

        reservas[] arrayReservas = {reserva1, reserva2, reserva3}; 
        Scanner myObj = new Scanner(System.in);

        System.out.println("Qual reserva deseja verificar:");
        int reservasConfirm = myObj.nextInt();



        if (reservasConfirm == 1) {
        	arrayReservas[0].listReservas();
        }
        if (reservasConfirm == 2) {
        	arrayReservas[1].listReservas();
        }
        if (reservasConfirm == 3) {
        	arrayReservas[2].listReservas();
        }
         
        myObj.close(); 
    }
}

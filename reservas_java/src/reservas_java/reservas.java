package reservas_java;

public class reservas {
    String user_name;
    String user_email;
    String user_tel;
    int reservation_id;
    String reservation_hora;
    String reservation_data;
    String reservation_people;
    String reservation_create;

    public reservas(String user_name, String user_email, String user_tel, int reservation_id, 
                    String reservation_hora, String reservation_data, String reservation_people, 
                    String reservation_create) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_tel = user_tel;
        this.reservation_id = reservation_id;
        this.reservation_hora = reservation_hora;
        this.reservation_data = reservation_data;
        this.reservation_people = reservation_people;
        this.reservation_create = reservation_create;
    }

    public void listReservas() {
        System.out.println("Reservas:\nId de reserva: " + reservation_id + 
                           ";\nNumero de pessoas: " + reservation_people + 
                           ";\nData da reserva: " + reservation_data + 
                           ";\nReserva feita no dia: " + reservation_create + ";");
                           
    }
    
    public void infCliente() {
    	System.out.println("Reservas:\nId de reserva: " + reservation_id + 
                ";\nNumero de pessoas: " + reservation_people + 
                ";\nData da reserva: " + reservation_data + 
                ";\nReserva feita no dia: " + reservation_create + ";");
    }
    
}

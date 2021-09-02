package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Data de saída (dd/MM/yyyy): ");
		Date dataSaida = sdf.parse(sc.next());
		
		if(!dataSaida.after(dataEntrada)) {
			System.out.println("Erro de reserva: Data de saída deve ser posterior a data de entrada! ");
		}
		else {
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
		
		    System.out.println();
		    System.out.println("Entre com a atualização da reserva: ");
		    System.out.print("Data de entrada (dd/MM/yyyy): ");
		    dataEntrada = sdf.parse(sc.next());
		    System.out.print("Data de saída (dd/MM/yyyy): ");
		    dataSaida = sdf.parse(sc.next());
		
		    
		    String erro = reserva.dataAtualizada(dataEntrada, dataSaida);
		    if(erro != null) {
		    	System.out.println("Erro na reserva: " + erro);
		    }
		    else {
			    System.out.println("Reserva: " + reserva);
		    }
		    
		    
		}  
		
		
		sc.close();
	}

}

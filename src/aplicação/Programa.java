package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.exceções.DominioExcecao;

public class Programa {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de saída (dd/MM/yyyy): ");
			Date dataSaida = sdf.parse(sc.next());
			
			
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
		
		    System.out.println();
		    System.out.println("Entre com a atualização da reserva: ");
		    System.out.print("Data de entrada (dd/MM/yyyy): ");
		    dataEntrada = sdf.parse(sc.next());
		    System.out.print("Data de saída (dd/MM/yyyy): ");
		    dataSaida = sdf.parse(sc.next());
		
		    
		    reserva.dataAtualizada(dataEntrada, dataSaida);
		    System.out.println("Reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("O formato da data é invalido!");
		}
		catch(DominioExcecao e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e){
			System.out.println("Erro inesperado! ");
		}
		sc.close();
	}

}

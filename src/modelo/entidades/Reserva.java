package modelo.entidades;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.exceções.DominioExcecao;

public class Reserva {

	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida) throws DominioExcecao {
		if(!saida.after(entrada)) {
	    	throw new DominioExcecao("Data de saída deve ser posterior a data de entrada! ");
		}
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long diferenca = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		
	}
	
	public void dataAtualizada(Date entrada, Date saida) throws DominioExcecao {
		
		Date agora = new Date();
	    if(entrada.before(agora) || saida.before(agora)) {
	    	throw new DominioExcecao("As datas a serem atualizadas devem ser datas futuras!");
	    }
	    if(!saida.after(entrada)) {
	    	throw new DominioExcecao("Data de saída deve ser posterior a data de entrada! ");
		}
		this.entrada = entrada;
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		return "Quarto"
				+numeroQuarto
				+", Data de entrada: "
				+sdf.format(entrada)
				+", Data de saída: "
				+sdf.format(saida)
				+", "
				+duracao()
				+" noites. ";
	}
	
}

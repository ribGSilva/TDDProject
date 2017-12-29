package br.indra.domain.types;

public class Duracao {

	private Data data;
	private Hora hora;
	private QuantidadeDeHoras quantidadeDeHoras;

	private Duracao() {
	}

	private Duracao(Data data, Hora hora, QuantidadeDeHoras quantidadeDeHoras) {
		this.data = data;
		this.hora = hora;
		this.quantidadeDeHoras = quantidadeDeHoras;
	}

	public static Duracao nova(Data data, Hora hora, QuantidadeDeHoras quantidadeDeHoras) {
		return new Duracao(data, hora, quantidadeDeHoras);
	}

	@Override
	public String toString() {
		return "Duracao [data=" + data + ", hora=" + hora + ", quantidadeDeHoras=" + quantidadeDeHoras + "]";
	}

}

package br.indra.domain.types;

public class QuantidadeDeHoras{
	
	private Integer quantidade = Integer.parseInt("0");
	private QuantidadeDeHoras() {
	}
	private QuantidadeDeHoras(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public static QuantidadeDeHoras nova(Integer quantidade) {
		return new QuantidadeDeHoras(quantidade);
	}
	@Override
	public String toString() {
		return "QuantidadeDeHoras [quantidade=" + quantidade + "]";
	}

}

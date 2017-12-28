package br.indra.domain.types;

public class QuantidadeDeEspectadores{
	private Integer quantidade = Integer.parseInt("0");
	private QuantidadeDeEspectadores() {
	}
	private QuantidadeDeEspectadores(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public static QuantidadeDeEspectadores nova(Integer quantidade) {
		return new QuantidadeDeEspectadores(quantidade);
	}
}

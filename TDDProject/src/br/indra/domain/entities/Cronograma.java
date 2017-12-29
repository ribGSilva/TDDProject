package br.indra.domain.entities;

import br.indra.domain.types.Data;
import br.indra.domain.types.Duracao;
import br.indra.domain.types.Hora;
import br.indra.domain.types.QuantidadeDeEspectadores;

public class Cronograma {

	private Data data;
	private Hora hora;
	private Duracao duracao;
	private Palestrante palestrante;
	private QuantidadeDeEspectadores quantidadeEspectadores;

	private Boolean ativo;

	public Cronograma(Data data, Hora hora, Duracao duracao, Palestrante palestrante,
			QuantidadeDeEspectadores quantidadeEspectadores) {
		super();
		this.data = data;
		this.hora = hora;
		this.duracao = duracao;
		this.palestrante = palestrante;
		this.quantidadeEspectadores = quantidadeEspectadores;
		this.ativo = Boolean.TRUE;
	}

	public Cronograma cancele() {
		this.ativo = Boolean.FALSE;
		return this;
	}

	public Boolean isAtivo() {
		return this.ativo;
	}

	public Palestrante getPalestrante() {
		return this.palestrante;
	}

	public Data getData() {
		return this.data;
	}

	public Hora getHora() {
		return this.hora;
	}

	public Cronograma altere(Palestrante palestrante, Data data, Hora hora, QuantidadeDeEspectadores quantidade) {
		this.palestrante = palestrante;
		this.data = data;
		this.hora = hora;
		this.quantidadeEspectadores = quantidade;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((palestrante == null) ? 0 : palestrante.hashCode());
		result = prime * result + ((quantidadeEspectadores == null) ? 0 : quantidadeEspectadores.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cronograma other = (Cronograma) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (palestrante == null) {
			if (other.palestrante != null)
				return false;
		} else if (!palestrante.equals(other.palestrante))
			return false;
		if (quantidadeEspectadores == null) {
			if (other.quantidadeEspectadores != null)
				return false;
		} else if (!quantidadeEspectadores.equals(other.quantidadeEspectadores))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cronograma [data=" + data + ", hora=" + hora + ", duracao=" + duracao + ", palestrante=" + palestrante
				+ ", quantidadeEspectadores=" + quantidadeEspectadores + ", ativo=" + ativo + "]";
	}

	private Cronograma() {
	}

}

package br.indra.vo;

import br.indra.domain.entities.Palestrante;
import br.indra.domain.types.Data;
import br.indra.domain.types.Hora;
import br.indra.domain.types.QuantidadeDeEspectadores;

public class AlteracaoDeCronogramaParaVO {

	private Data data;
	private Hora hora;
	private Palestrante palestrante;
	private QuantidadeDeEspectadores quantidadeDeEspectadores;

	public AlteracaoDeCronogramaParaVO(Data data, Hora hora, Palestrante palestrante, QuantidadeDeEspectadores quantidadeDeEspectadores) {
		this.data = data;
		this.hora = hora;
		this.palestrante = palestrante;
		this.quantidadeDeEspectadores = quantidadeDeEspectadores;
	}

	public Data getData() {
		return this.data;
	}

	public Hora getHora() {
		return this.hora;
	}

	public Palestrante getPalestrante() {
		return this.palestrante;
	}
	
	public QuantidadeDeEspectadores getQuantidadeDeEspectadores() {
		return this.quantidadeDeEspectadores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((palestrante == null) ? 0 : palestrante.hashCode());
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
		AlteracaoDeCronogramaParaVO other = (AlteracaoDeCronogramaParaVO) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
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
		return true;
	}

	@Override
	public String toString() {
		return "AlteracaoDeCronogramaParaVO [data=" + data + ", hora=" + hora + ", palestrante=" + palestrante + "]";
	}
	
	

}

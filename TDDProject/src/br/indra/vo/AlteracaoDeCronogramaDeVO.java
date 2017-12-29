package br.indra.vo;

import br.indra.domain.entities.Palestrante;
import br.indra.domain.types.Data;
import br.indra.domain.types.Hora;
import br.indra.exceptions.SemDadosMinimosParaConstrucao;

public class AlteracaoDeCronogramaDeVO {

	private Palestrante palestrante;
	private Hora hora;
	private Data data;

	private AlteracaoDeCronogramaDeVO() {
	}

	public static AlteracaoDeCronogramaDeVO builder() {
		return new AlteracaoDeCronogramaDeVO();
	}
	
	public AlteracaoDeCronogramaDeVO paraPalestrante(Palestrante palestrante)
	{
		this.palestrante = palestrante;
		return this;
	}
	
	public Palestrante getPalestrante() {
		return palestrante;
	}

	public Hora getHora() {
		return hora;
	}

	public Data getData() {
		return data;
	}

	@Override
	public String toString() {
		return "AlteracaoDeCronogramaDeVO [palestrante=" + palestrante + ", hora=" + hora + ", data=" + data + "]";
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
		AlteracaoDeCronogramaDeVO other = (AlteracaoDeCronogramaDeVO) obj;
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

	public AlteracaoDeCronogramaDeVO naData(Data data) {
		this.data = data;
		return this;
	}

	public AlteracaoDeCronogramaDeVO naHora(Hora hora) {
		this.hora = hora;
		return this;
	}

	public AlteracaoDeCronogramaDeVO build() throws SemDadosMinimosParaConstrucao {
		if ( this.data==null
				||this.hora==null
				||this.palestrante==null){
				throw new SemDadosMinimosParaConstrucao("NAAAOOOO");
		}
		return this;
	}

}

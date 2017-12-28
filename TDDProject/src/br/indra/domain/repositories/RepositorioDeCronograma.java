package br.indra.domain.repositories;

import java.util.ArrayList;
import java.util.List;

import br.indra.domain.entities.Cronograma;
import br.indra.domain.entities.Palestrante;
import br.indra.domain.types.Data;
import br.indra.domain.types.Hora;

public class RepositorioDeCronograma {
	List<Cronograma> cronogramas;

	public RepositorioDeCronograma() {
		cronogramas = new ArrayList<Cronograma>();
	}

	public List<Cronograma> todos() {
		return cronogramas;
	}

	public Boolean salvar(Cronograma cronograma) {
		return cronogramas.add(cronograma);
	}

	public Cronograma busquePor(Palestrante palestrante, Data data, Hora hora) {
		Cronograma retorno = null;
		for (Cronograma cronograma : cronogramas) {
			if ( palestrante.equals(cronograma.getPalestrante())
					&& data.equals(cronograma.getData())
					&& hora.equals(cronograma.getHora())
					)
				retorno = cronograma;
		}
		return retorno;		
	}

}

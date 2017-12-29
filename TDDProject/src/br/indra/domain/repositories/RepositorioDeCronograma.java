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
		return this.cronogramas;
	}
	
	public List<Cronograma> todosAtivos() {
		List<Cronograma> cronogramas = new ArrayList<Cronograma>();
		for (Cronograma cronograma : this.cronogramas) {
			if (cronograma.isAtivo()) {
				cronogramas.add(cronograma);
			}
		}
		return cronogramas;
	}

	public Boolean salvar(Cronograma cronograma) {
		return cronogramas.add(cronograma);
	}

	public Cronograma busquePor(Palestrante palestrante, Data data, Hora hora) {
		Cronograma retorno = null;
		for (Cronograma cronograma : cronogramas) {
			if (palestrante.equals(cronograma.getPalestrante()) && data.equals(cronograma.getData())
					&& hora.equals(cronograma.getHora())
					&& cronograma.isAtivo()) {
				retorno = cronograma;
				break;
			}
		}
		return retorno;
	}

	public List<Cronograma> busquePor(Data data) {
		List<Cronograma> cronogramas = new ArrayList<Cronograma>();
		for (Cronograma cronograma : this.cronogramas) {
			if (data.equals(cronograma.getData())
					&& cronograma.isAtivo()) {
				cronogramas.add(cronograma);
			}
		}
		return cronogramas;
	}
}

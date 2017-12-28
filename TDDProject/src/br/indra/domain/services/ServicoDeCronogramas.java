package br.indra.domain.services;

import java.util.List;

import br.indra.domain.entities.Cronograma;
import br.indra.domain.entities.Palestrante;
import br.indra.domain.repositories.RepositorioDeCronograma;
import br.indra.domain.types.Data;
import br.indra.domain.types.Hora;

public class ServicoDeCronogramas {

	RepositorioDeCronograma repositorio = new RepositorioDeCronograma();
	
	static ServicoDeCronogramas instancia = null;
	
	private ServicoDeCronogramas() {
	}
	
	public static synchronized ServicoDeCronogramas getInstance(){
		if ( instancia == null )
			instancia = new ServicoDeCronogramas();
		
		return instancia;
	}
	
	public void alterar(Cronograma novoCronograma) {
		repositorio.salvar(novoCronograma);
	}

	public Boolean adicionar(Cronograma cronograma) throws NullPointerException{
		System.out.println("Salvou o cronograma: "+cronograma);
		return repositorio.salvar(cronograma);
	}

	public void cancelar(List<Cronograma> cronogramas) {
		for (Cronograma cronograma : cronogramas) {
			cronograma.cancele();
			this.alterar(cronograma);		
		}
	}

	public List<Cronograma> busqueTodos() {
		return repositorio.todos();
	}

	public void cancelar(Cronograma cronograma) {
		cronograma.cancele();
		this.alterar(cronograma);		
	}

	public Cronograma busquePorPalestranteDataEHora(Palestrante palestrante, Data data, Hora hora) {
		return repositorio.busquePor(palestrante, data, hora);
	}

}

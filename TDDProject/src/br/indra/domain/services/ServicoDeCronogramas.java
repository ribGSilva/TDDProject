package br.indra.domain.services;

import java.util.List;

import br.indra.domain.entities.Cronograma;
import br.indra.domain.entities.Palestrante;
import br.indra.domain.repositories.RepositorioDeCronograma;
import br.indra.domain.types.Data;
import br.indra.domain.types.Hora;
import br.indra.log.Log;
import br.indra.vo.AlteracaoDeCronogramaVO;

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
	public void alterar(AlteracaoDeCronogramaVO cronograma) {
		Cronograma cronogramaEncontrado = ServicoDeCronogramas.getInstance()
				.busquePorPalestranteDataEHora(
						cronograma.getAlteracaoDeCronogramaDeVO().getPalestrante(), 
						cronograma.getAlteracaoDeCronogramaDeVO().getData(), 
						cronograma.getAlteracaoDeCronogramaDeVO().getHora());

		if (cronogramaEncontrado.altere(
				cronograma.getAlteracaoDeCronogramaParaVO().getPalestrante(),
				cronograma.getAlteracaoDeCronogramaParaVO().getData(),
				cronograma.getAlteracaoDeCronogramaParaVO().getHora(),
				cronograma.getAlteracaoDeCronogramaParaVO().getQuantidadeDeEspectadores()) == null){
			Log.log("Achou nada");
		}

		Log.log("Cronograma alterado: "+cronogramaEncontrado);
	}

	public Boolean adicionar(Cronograma cronograma) throws NullPointerException{
		Log.log("Salvou o cronograma: "+cronograma);
		return repositorio.salvar(cronograma);
	}

	public void cancelar(List<Cronograma> cronogramas) {
		for (Cronograma cronograma : cronogramas) {
			cancelar(cronograma);
			Log.log("Cancelando: "+cronograma);
		}
	}

	public List<Cronograma> busqueTodos() {
		return repositorio.todosAtivos();
	}

	public void cancelar(Cronograma cronograma) {
		cronograma.cancele();
	}

	public Cronograma busquePorPalestranteDataEHora(Palestrante palestrante, Data data, Hora hora) {
		return repositorio.busquePor(palestrante, data, hora);
	}

	public List<Cronograma> busquePorData(Data data) {
		return repositorio.busquePor(data);
	}
}

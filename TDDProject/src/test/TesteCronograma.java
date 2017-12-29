package test;

import java.util.List;

import br.indra.domain.entities.Cronograma;
import br.indra.domain.entities.Palestrante;
import br.indra.domain.factories.FabricaDeCronograma;
import br.indra.domain.factories.FabricaDePalestrante;
import br.indra.domain.services.ServicoDeCronogramas;
import br.indra.domain.types.Data;
import br.indra.domain.types.Duracao;
import br.indra.domain.types.Hora;
import br.indra.domain.types.QuantidadeDeEspectadores;
import br.indra.domain.types.QuantidadeDeHoras;
import br.indra.exceptions.SemDadosMinimosParaConstrucao;
import br.indra.log.Log;
import br.indra.vo.AlteracaoDeCronogramaDeVO;
import br.indra.vo.AlteracaoDeCronogramaParaVO;
import br.indra.vo.AlteracaoDeCronogramaVO;

public class TesteCronograma {

	public static void main(String[] args) {
		testeAdicionarCronograma();
		testeAdicionarCronograma();
		testeAdicionarCronograma();
		testeAdicionarCronograma();
		testeVisualizarTodosOsCronogramas();
		testeAlterarCronograma();
		testeCancelarCronogramaPorData();
		testeVisualizarTodosOsCronogramas();
		testeCancelarCronogramaPorPalestrante();
		testeCancelarCronogramaPorPalestranteDataEHora();
	}

	private static void testeVisualizarTodosOsCronogramas() {
		ServicoDeCronogramas servicoDeCronogramas = ServicoDeCronogramas.getInstance();

		List<Cronograma> busqueTodos = servicoDeCronogramas.busqueTodos();

		if (busqueTodos == null) {
			Log.log("Objeto Nulo");
		} else if (busqueTodos.isEmpty()) {
			Log.log("Objeto Vazio");
		} else {
			for (Cronograma cronograma : busqueTodos) {
				System.out.println(cronograma);
			}
		}
	}

	private static void testeAdicionarCronograma() {
		Data data = Data.nova("28/12/2017");
		Hora hora = Hora.nova("09:00");
		Duracao duracao = Duracao.nova(data, hora, QuantidadeDeHoras.nova(10));
		QuantidadeDeEspectadores quantidadeDeEspectadores = QuantidadeDeEspectadores.nova(10);

		Cronograma cronograma = FabricaDeCronograma.crie(data, hora, duracao,
				FabricaDePalestrante.crie("Joseh Antonio"), quantidadeDeEspectadores);
		Boolean adicionar = ServicoDeCronogramas.getInstance().adicionar(cronograma);

		if (adicionar == null)
			Log.log("Deu NULL ao adicionar Cronograma!");
		if (adicionar.equals(Boolean.FALSE))
			Log.log("Deu FALSo e nao inseriu o Cronograma!");

	}

	private static void testeAlterarCronograma() {

		try {
			AlteracaoDeCronogramaVO alteracaoDeCronograma = 
			
			AlteracaoDeCronogramaVO.nova().de(

					AlteracaoDeCronogramaDeVO.builder().paraPalestrante(FabricaDePalestrante.crie("Joseh Antonio"))
							.naData(Data.nova("28/12/2017")).naHora(Hora.nova("09:00")).build()
			).para(
					new AlteracaoDeCronogramaParaVO(Data.nova("78/12/2017"), Hora.nova("19:00"),
							FabricaDePalestrante.crie("Joseh Maria"), QuantidadeDeEspectadores.nova(100)));

			ServicoDeCronogramas.getInstance().alterar(alteracaoDeCronograma);

		} catch (SemDadosMinimosParaConstrucao e) {
			Log.log(SemDadosMinimosParaConstrucao.class, "[ERROR]: "+e.getMessage());
			e.printStackTrace();
			Log.log("***********");
		} catch (Exception ex) {
			Log.log("Deu Problema Feio! Em tempo de Execução");
		}

	}

	private static void testeCancelarCronogramaPorData() {
		List<Cronograma> cronogramas = ServicoDeCronogramas.getInstance().busquePorData(Data.nova("78/12/2017"));
		ServicoDeCronogramas.getInstance().cancelar(cronogramas);
		if (cronogramas.size() != 1)
			Log.log("Não cancelou o que deveria");
		else
			Log.log("Cancelado: " + cronogramas);
	}

	private static void testeCancelarCronogramaPorPalestrante() {
		// List<Cronograma> cronogramas =
		// ServicoDeCronogramas.busquePorPalestrante(Palestrante);
		// ServicoDeCronogramas.cancelar(cronogramas);
	}

	private static void testeCancelarCronogramaPorPalestranteDataEHora() {
		// Cronograma cronograma =
		// ServicoDeCronogramas.busquePorPalestranteDataEHora(Palestrante, Data,
		// Hora);
		// ServicoDeCronogramas.cancelar(cronograma);
	}

	private static void testeCancelarTODOSCronogramas() {
		// List<Cronograma> cronogramas = ServicoDeCronogramas.busqueTodos();
		// ServicoDeCronogramas.cancelar(cronogramas);
	}

}

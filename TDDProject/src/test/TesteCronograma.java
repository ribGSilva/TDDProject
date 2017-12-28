package test;

import java.util.Calendar;
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

public class TesteCronograma {

	public static void main(String[] args) {
		testeAdicionarCronograma();
		testeAdicionarCronograma();
		testeAdicionarCronograma();
		testeAdicionarCronograma();
		testeVisualizarTodosOsCronogramas();
		testeAlterarCronograma();
		testeCancelarCronogramaPorData();
		testeCancelarCronogramaPorPalestrante();
		testeCancelarCronogramaPorPalestranteDataEHora();
	}

	private static void testeVisualizarTodosOsCronogramas() {
		ServicoDeCronogramas servicoDeCronogramas = ServicoDeCronogramas.getInstance();
		List<Cronograma> busqueTodos = servicoDeCronogramas.busqueTodos();

		if (busqueTodos == null) {
			System.out.println("Objeto Nulo");
		}
		if (busqueTodos.isEmpty()) {
			System.out.println("Objeto Vazio");
		}
	}

	private static void testeAdicionarCronograma() {
		Data data = Data.nova("28/12/2017");
		Hora hora = Hora.nova("09:00");
		Duracao duracao = Duracao.nova(data, hora, QuantidadeDeHoras.nova(10));
		QuantidadeDeEspectadores quantidadeDeEspectadores = QuantidadeDeEspectadores.nova(10);

		Cronograma cronograma = FabricaDeCronograma.crie(data, hora, duracao,
				FabricaDePalestrante.crie("Joseh Antonio"), quantidadeDeEspectadores);
		ServicoDeCronogramas servicoDeCronogramas = ServicoDeCronogramas.getInstance();
		Boolean adicionar = servicoDeCronogramas.adicionar(cronograma);

		if (adicionar == null)
			System.out.println("Deu NULL ao adicionar Cronograma!");
		if (adicionar.equals(Boolean.FALSE))
			System.out.println("Deu FALSo e nao inseriu o Cronograma!");

	}

	private static void testeAlterarCronograma() {
		Data data = Data.nova("28/12/2017");
		Hora hora = Hora.nova("09:00");
		Palestrante palestrante = FabricaDePalestrante.crie("Joseh Antonio");

		Cronograma cronogramaEncontrado = ServicoDeCronogramas.getInstance().busquePorPalestranteDataEHora(palestrante,
				data, hora);

		if (cronogramaEncontrado == null)
			System.out.println("Achou nada");
		else
			cronogramaEncontrado.altere(FabricaDePalestrante.crie("José Antonio"), Data.nova("29/01/2017"),
					Hora.nova("00:00"), QuantidadeDeEspectadores.nova(50000));

		System.out.println("Cronograma alterado: "+cronogramaEncontrado);
		ServicoDeCronogramas.getInstance().alterar(cronogramaEncontrado);

	}

	private static void testeCancelarCronogramaPorData() {
		// List<Cronograma> cronogramas =
		// ServicoDeCronogramas.busquePorData(DataDoCronograma);
		// ServicoDeCronogramas.cancelar(cronogramas);
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

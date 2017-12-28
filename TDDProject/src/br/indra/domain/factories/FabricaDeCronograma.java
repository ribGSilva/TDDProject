package br.indra.domain.factories;

import br.indra.domain.entities.Cronograma;
import br.indra.domain.entities.Palestrante;
import br.indra.domain.types.Data;
import br.indra.domain.types.Duracao;
import br.indra.domain.types.Hora;
import br.indra.domain.types.QuantidadeDeEspectadores;

public class FabricaDeCronograma {

	private FabricaDeCronograma() {
	}
	
	public static Cronograma crie(Data data, Hora hora, Duracao duracao, 
			Palestrante palestrante,
			QuantidadeDeEspectadores quantidadeEspectadores) {
		return new Cronograma(data, hora, duracao, palestrante, quantidadeEspectadores);
	}

}

package br.indra.domain.factories;

import br.indra.domain.entities.Palestrante;

public class FabricaDePalestrante {

	public static Palestrante crie(String nome) {
		return new Palestrante(nome);
	}

}

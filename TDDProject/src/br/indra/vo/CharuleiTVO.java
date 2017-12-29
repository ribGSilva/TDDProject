package br.indra.vo;

import br.indra.domain.entities.Cronograma;

public class CharuleiTVO {

	private Cronograma cronograma;

	public CharuleiTVO(Cronograma cronograma) {
		this.cronograma = cronograma;
	}

	public Cronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}
	
	
}

package br.indra.vo;

public class AlteracaoDeCronogramaVO {

	private AlteracaoDeCronogramaParaVO alteracaoDeCronogramaParaVO;
	private AlteracaoDeCronogramaDeVO alteracaoDeCronogramaDeVO;

	private AlteracaoDeCronogramaVO() {
	}
	
	public static AlteracaoDeCronogramaVO nova(){
		return new AlteracaoDeCronogramaVO();
	}
	
	public AlteracaoDeCronogramaVO de(AlteracaoDeCronogramaDeVO de){
		this.alteracaoDeCronogramaDeVO = de;
		return this;
	}
	public AlteracaoDeCronogramaVO para(AlteracaoDeCronogramaParaVO para){
		this.alteracaoDeCronogramaParaVO = para;
		return this;
	}

	public AlteracaoDeCronogramaParaVO getAlteracaoDeCronogramaParaVO() {
		return alteracaoDeCronogramaParaVO;
	}

	public AlteracaoDeCronogramaDeVO getAlteracaoDeCronogramaDeVO() {
		return alteracaoDeCronogramaDeVO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alteracaoDeCronogramaDeVO == null) ? 0 : alteracaoDeCronogramaDeVO.hashCode());
		result = prime * result + ((alteracaoDeCronogramaParaVO == null) ? 0 : alteracaoDeCronogramaParaVO.hashCode());
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
		AlteracaoDeCronogramaVO other = (AlteracaoDeCronogramaVO) obj;
		if (alteracaoDeCronogramaDeVO == null) {
			if (other.alteracaoDeCronogramaDeVO != null)
				return false;
		} else if (!alteracaoDeCronogramaDeVO.equals(other.alteracaoDeCronogramaDeVO))
			return false;
		if (alteracaoDeCronogramaParaVO == null) {
			if (other.alteracaoDeCronogramaParaVO != null)
				return false;
		} else if (!alteracaoDeCronogramaParaVO.equals(other.alteracaoDeCronogramaParaVO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlteracaoDeCronogramaVO [alteracaoDeCronogramaParaVO=" + alteracaoDeCronogramaParaVO
				+ ", alteracaoDeCronogramaDeVO=" + alteracaoDeCronogramaDeVO + "]";
	}
	
	

}

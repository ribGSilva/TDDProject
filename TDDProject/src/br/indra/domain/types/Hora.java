package br.indra.domain.types;

public class Hora {

	private String hora;

	private Hora() {
	}

	private Hora(String hora) {
		this.hora = hora;
	}

	public static Hora nova(String hora) {
		return new Hora(hora);
	}

	@Override
	public String toString() {
		return "Hora [hora=" + hora + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
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
		Hora other = (Hora) obj;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		return true;
	}
	
}

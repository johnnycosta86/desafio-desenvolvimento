package br.com.cresol.desafio.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author johnny
 *
 */
@Embeddable
public class ParcelaEmprestimoID implements Serializable {
	private static final long serialVersionUID = 4268282428246839519L;
	
	private Long numeroContrato;
	private Integer numeroParcela;
	
	/**
	 * Metodo hashcode
	 * 
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroContrato == null) ? 0 : numeroContrato.hashCode());
		result = prime * result + ((numeroParcela == null) ? 0 : numeroParcela.hashCode());
		return result;
	}
	
	/**
	 * Metodo equals
	 * 
	 * @param obj
	 * @return the boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParcelaEmprestimoID other = (ParcelaEmprestimoID) obj;
		if (numeroContrato == null) {
			if (other.numeroContrato != null)
				return false;
		} else if (!numeroContrato.equals(other.numeroContrato))
			return false;
		if (numeroParcela == null) {
			if (other.numeroParcela != null)
				return false;
		} else if (!numeroParcela.equals(other.numeroParcela))
			return false;
		return true;
	}
	/**
	 * @return the numeroContrato
	 */
	public Long getNumeroContrato() {
		return numeroContrato;
	}
	/**
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(Long numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	/**
	 * @return the numeroParcela
	 */
	public Integer getNumeroParcela() {
		return numeroParcela;
	}
	/**
	 * @param numeroParcela the numeroParcela to set
	 */
	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
}

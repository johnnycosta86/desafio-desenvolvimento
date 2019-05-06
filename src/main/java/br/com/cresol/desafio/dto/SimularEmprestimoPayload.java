package br.com.cresol.desafio.dto;

import java.math.BigDecimal;

/**
 * @author johnny
 *
 */
public class SimularEmprestimoPayload {
	private String nome;
	private String cpf;
	private String email;
	private BigDecimal valorContrato;
	private Integer quantidadeParcelas;
	
	/**
	 * Metodo ToString
	 * @return the string
	 */
	@Override
	public String toString() {
		return " nome["+nome+"] cpf["+cpf+"] email["+email+"] valorContrato["+valorContrato+"] quantidadeParcelas["+quantidadeParcelas+"] ";
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the valorContrato
	 */
	public BigDecimal getValorContrato() {
		return valorContrato;
	}
	/**
	 * @param valorContrato the valorContrato to set
	 */
	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}
	/**
	 * @return the quantidadeParcelas
	 */
	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	/**
	 * @param quantidadeParcelas the quantidadeParcelas to set
	 */
	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	
	
}
package br.com.cresol.desafio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author johnny
 *
 */
@Entity
@Table(name = "emprestimos")
public class ContratarEmprestimo {
	
	@Id
	private Long numeroContrato;
	private String dataContratacao;
	private BigDecimal iofContrato;
	private BigDecimal valorContrato;
	private Integer quantidadeParcelas;
	private BigDecimal taxaJurosEmprestimo;
	
	/**
	 * Metodo parser SimularEmprestimoPayload para ContratarEmprestimo
	 * 
	 * @param payload
	 * @return the ContratarEmprestimo
	 */
	public static ContratarEmprestimo get(final SimulacaoEmprestimo payload) {
		final ContratarEmprestimo emprestimo = new ContratarEmprestimo();
		
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
		final LocalDate dataLimite = LocalDate.parse(payload.getDataValidadeSimulacao(), formatter);
		
		if(LocalDate.now().isAfter(dataLimite)) {
			throw new RuntimeException("Simulacao nao valida. Tempo excedido.");
		}
		
		emprestimo.setNumeroContrato(payload.getNumeroContrato());
		emprestimo.setDataContratacao(LocalDate.now().format(formatter));
		emprestimo.setQuantidadeParcelas(payload.getQuantidadeParcelas());
		emprestimo.setValorContrato(payload.getValorContrato());
		emprestimo.setTaxaJurosEmprestimo(payload.getTaxaJurosEmprestimo());
		emprestimo.setIofContrato(BigDecimal.ONE);
		
		return emprestimo;
	}
	
	/**
	 * Metodo ToString
	 * @return the string
	 */
	@Override
	public String toString() {
		return " numeroContrato["+numeroContrato+"], valorContrato["+valorContrato+"], dataContratacao["+dataContratacao+"],"
				+ " taxaJurosEmprestimo["+taxaJurosEmprestimo+"], quantidadeParcelas["+quantidadeParcelas+"], iofContrato["+iofContrato+"] ";
	}
	
	/**
	 * @return the dataContratacao
	 */
	public String getDataContratacao() {
		return dataContratacao;
	}
	/**
	 * @param dataContratacao the dataContratacao to set
	 */
	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	/**
	 * @return the iofContrato
	 */
	public BigDecimal getIofContrato() {
		return iofContrato;
	}
	/**
	 * @param iofContrato the iofContrato to set
	 */
	public void setIofContrato(BigDecimal iofContrato) {
		this.iofContrato = iofContrato;
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

	/**
	 * @return the taxaJurosEmprestimo
	 */
	public BigDecimal getTaxaJurosEmprestimo() {
		return taxaJurosEmprestimo;
	}

	/**
	 * @param taxaJurosEmprestimo the taxaJurosEmprestimo to set
	 */
	public void setTaxaJurosEmprestimo(BigDecimal taxaJurosEmprestimo) {
		this.taxaJurosEmprestimo = taxaJurosEmprestimo;
	}
	
	
}

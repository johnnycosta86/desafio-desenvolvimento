package br.com.cresol.desafio.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author johnny
 *
 */
@Entity
@Table(name = "simulacoes")
public class SimulacaoEmprestimo {
	
	@Id
	private Long numeroContrato;
	
	@Basic
	private String dataSimulacao;
	
	@Basic
	private String dataValidadeSimulacao;
	private BigDecimal valorParcela;
	private BigDecimal valorContrato;
	private Integer quantidadeParcelas;
	private BigDecimal taxaJurosEmprestimo;
    private String cpf;
	
    /**
	 * Metodo parser SimularEmprestimoPayload para SimulacaoEmprestimo
	 * 
	 * @param the payload
	 * @param the sequence
	 * @return the SimulacaoEmprestimo
	 */
	
	public static SimulacaoEmprestimo get(final SimularEmprestimoPayload payload, final Long sequence) {
		
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		final DateTimeFormatter formatSequence = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		final Long id = Long.valueOf(LocalDate.now().format(formatSequence) + String.format("%06d", sequence.longValue()));
		
		final SimulacaoEmprestimo simulacao = new SimulacaoEmprestimo();
		
		
		//	R4 - Quantidade Maxima de Parcelas
		if(payload.getQuantidadeParcelas() > 24) {
			throw new RuntimeException("Quantidade Maxima de 24 Parcelas");
		}
		
		final BigDecimal quantidadeParcelas = BigDecimal.valueOf(payload.getQuantidadeParcelas());
		
		BigDecimal taxaJurosEmprestimo = BigDecimal.ZERO;
		
		//		R3 - Taxa de Juros
		if(payload.getQuantidadeParcelas() > 12) {
			taxaJurosEmprestimo = BigDecimal.valueOf(0.05);
		}
		else {
			if(payload.getValorContrato().compareTo(BigDecimal.valueOf(1000.00)) <= 0) {
				taxaJurosEmprestimo = BigDecimal.valueOf(0.018);
			}
			else {
				taxaJurosEmprestimo = BigDecimal.valueOf(0.030);
			}
			
		}
		
		//	R2 = Valor da Parcela
		final BigDecimal valorParcela = payload.getValorContrato().multiply(
												BigDecimal.ONE.add((quantidadeParcelas.multiply(taxaJurosEmprestimo))))
												.divide(quantidadeParcelas, 2, RoundingMode.HALF_UP);
		
		simulacao.setNumeroContrato(id);
		simulacao.setDataSimulacao(LocalDate.now().format(formatter));
		simulacao.setDataValidadeSimulacao(LocalDate.now().plusDays(30).format(formatter));
		simulacao.setValorParcela(valorParcela);
		simulacao.setValorContrato(payload.getValorContrato());
		simulacao.setTaxaJurosEmprestimo(taxaJurosEmprestimo);
		simulacao.setQuantidadeParcelas(quantidadeParcelas.intValue());
		simulacao.setCpf(payload.getCpf());
		
		return simulacao;
	}
	
	/**
	 * Metodo ToString
	 * @return the string
	 */
	@Override
	public String toString() {
		return  " numeroContrato["+numeroContrato+"], valorContrato["+valorContrato+"], dataSimulacao["+dataSimulacao+"] dataValidadeSimulacao["+dataValidadeSimulacao+"], valorParcela["+valorParcela+"], " +
				"  quantidadeParcelas["+quantidadeParcelas+"], taxaJurosEmprestimo["+taxaJurosEmprestimo+"], cpf["+cpf+"] ";
	}
	
	/**
	 * @return the dataSimulacao
	 */
	public String getDataSimulacao() {
		return dataSimulacao;
	}
	/**
	 * @param dataSimulacao the dataSimulacao to set
	 */
	public void setDataSimulacao(String dataSimulacao) {
		this.dataSimulacao = dataSimulacao;
	}
	/**
	 * @return the dataValidadeSimulacao
	 */
	public String getDataValidadeSimulacao() {
		return dataValidadeSimulacao;
	}
	/**
	 * @param dataValidadeSimulacao the dataValidadeSimulacao to set
	 */
	public void setDataValidadeSimulacao(String dataValidadeSimulacao) {
		this.dataValidadeSimulacao = dataValidadeSimulacao;
	}
	/**
	 * @return the valorParcela
	 */
	public BigDecimal getValorParcela() {
		return valorParcela;
	}
	/**
	 * @param valorParcela the valorParcela to set
	 */
	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
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
	
}

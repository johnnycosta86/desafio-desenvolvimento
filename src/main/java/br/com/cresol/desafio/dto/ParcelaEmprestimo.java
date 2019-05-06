package br.com.cresol.desafio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author johnny
 *
 */
@Entity
@Table(name = "parcelas")
public class ParcelaEmprestimo {
	@EmbeddedId
	private ParcelaEmprestimoID id;
	
	private BigDecimal valorParcela;
	private String dataVencimento;
	
	/**
	 * Metodo parser SimulacaoEmprestimo para List<ParcelaEmprestimo>
	 * 
	 * @param payload
	 * @return the List<ParcelaEmprestimo>
	 */
	public static List<ParcelaEmprestimo> get(final SimulacaoEmprestimo payload) {
		final List<ParcelaEmprestimo> parcelas = new ArrayList<>();
		
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for(int i = 0; i < payload.getQuantidadeParcelas(); i++) {
			final ParcelaEmprestimo parcela = new ParcelaEmprestimo();
			
			ParcelaEmprestimoID idParcela = new ParcelaEmprestimoID();
			idParcela.setNumeroContrato(payload.getNumeroContrato());
			idParcela.setNumeroParcela(i+1);
			
			parcela.setId(idParcela);
			parcela.setValorParcela(payload.getValorParcela());
			parcela.setDataVencimento(LocalDate.now().plusMonths(i+1).format(formatter));
			
			parcelas.add(parcela);
		}
		
		return parcelas;
	}
	
	/**
	 * Metodo ToString
	 * @return the string
	 */
	@Override
	public String toString() {
		return " numeroContrato["+id.getNumeroContrato()+"] numeroParcela["+id.getNumeroParcela()+"] valorParcela["+valorParcela+"] dataVencimento["+dataVencimento+"] ";
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
	 * @return the dataVencimento
	 */
	public String getDataVencimento() {
		return dataVencimento;
	}
	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	/**
	 * @return the id
	 */
	public ParcelaEmprestimoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ParcelaEmprestimoID id) {
		this.id = id;
	}
}

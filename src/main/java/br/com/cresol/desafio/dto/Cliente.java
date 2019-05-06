package br.com.cresol.desafio.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author johnny
 *
 */
@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	private Long cpf; 
	private String nome;
	private String email;
	
	/**
	 * Metodo parser SimularEmprestimoPayload para Cliente
	 * 
	 * @param payload
	 * @return the Cliente
	 */
	public static Cliente get(final SimularEmprestimoPayload payload) {
		final Cliente cliente = new Cliente();
		cliente.setCpf(Long.valueOf(payload.getCpf()));
		cliente.setEmail(payload.getEmail());
		cliente.setNome(payload.getNome());
		
		return cliente;
	}
	
	/**
	 * Metodo ToString
	 * @return the string
	 */
	@Override
	public String toString() {
		return " cpf["+cpf+"] nome["+nome+"] email["+email+"]";
	}
	
	/**
	 * @return the cpf
	 */
	public Long getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
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
}

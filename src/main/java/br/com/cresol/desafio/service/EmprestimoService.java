package br.com.cresol.desafio.service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cresol.desafio.dto.Cliente;
import br.com.cresol.desafio.dto.ContratarEmprestimo;
import br.com.cresol.desafio.dto.ParcelaEmprestimo;
import br.com.cresol.desafio.dto.SimulacaoEmprestimo;
import br.com.cresol.desafio.dto.SimularEmprestimoPayload;
import br.com.cresol.desafio.repository.ClienteRepository;
import br.com.cresol.desafio.repository.EmprestimoRepository;
import br.com.cresol.desafio.repository.ParcelaRepository;
import br.com.cresol.desafio.repository.SimulacaoEmprestimoRepository;

@Service
public class EmprestimoService {

	 @Autowired
	 private ClienteRepository clienteRepository;
	 
	 @Autowired
	 private SimulacaoEmprestimoRepository simulacaoRepository;
	 
	 @Autowired
	 private EmprestimoRepository emprestimoRepository;
	 
	 @Autowired
	 private ParcelaRepository parcelaRepository;
	 
	 @PersistenceContext
	 private EntityManager entityManager;

	 /**
	  * Cria e salva simulacao de emprestimo.
	  *
	  * @return SimulacaoEmprestimo the SimulacaoEmprestimo 
	  */
	 public SimulacaoEmprestimo simular(SimularEmprestimoPayload payload) {
		 final SimulacaoEmprestimo simulacaoEmprestimo = SimulacaoEmprestimo.get(payload, sequence());
		 final Cliente cliente = Cliente.get(payload);
				 		 		  
		 clienteRepository.save(cliente);
		 
		 simulacaoRepository.save(simulacaoEmprestimo);
		 
		 return simulacaoEmprestimo;
	 }
	 
	 /**
	  * Retorna Sequence.
	  *
	  * @return sequence the sequence 
	  */
	 private Long sequence() {
	     final Query query = entityManager.createNativeQuery("SELECT nextval('serial');");

	     return ((BigInteger)query.getSingleResult()).longValue();

	 }
		
	 /**
	  * Contrata Emprestimo.
	  *
	  * @param payload the payload 
	  */
	 public ContratarEmprestimo contratar(SimulacaoEmprestimo payload) {
		 final ContratarEmprestimo emprestimo = ContratarEmprestimo.get(payload);
		 final List<ParcelaEmprestimo> parcelas = ParcelaEmprestimo.get(payload);
		 
		 emprestimoRepository.save(emprestimo);
		 
		 parcelas.stream().forEach(parcela -> salvarParcela(parcela));
		 
		 return emprestimo;
	 }
	 
	 /**
	  * Salva Parcela.
	  *
	  * @param parcela the parcela 
	  */
	 public void salvarParcela(final ParcelaEmprestimo parcela) {
		 parcelaRepository.save(parcela);
	 }

	 /**
	  * Deleta Simulacao.
	  *
	  * @param numeroContrato the numeroContrato 
	  */
	 public void deletarSimulacao(final Long numeroContrato) {
		 simulacaoRepository.delete(numeroContrato);
	 }
}

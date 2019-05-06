package br.com.cresol.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cresol.desafio.dto.ContratarEmprestimo;

/**
 * @author johnny
 *
 */
public interface EmprestimoRepository extends CrudRepository<ContratarEmprestimo, Long> {
}
package br.com.cresol.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cresol.desafio.dto.ParcelaEmprestimo;

/**
 * @author johnny
 *
 */
public interface ParcelaRepository extends CrudRepository<ParcelaEmprestimo, Long> {
}
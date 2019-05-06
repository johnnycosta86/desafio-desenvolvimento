package br.com.cresol.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cresol.desafio.dto.Cliente;

/**
 * @author johnny
 *
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
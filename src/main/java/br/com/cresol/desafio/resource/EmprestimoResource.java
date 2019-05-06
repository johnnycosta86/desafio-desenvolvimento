package br.com.cresol.desafio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cresol.desafio.dto.SimulacaoEmprestimo;
import br.com.cresol.desafio.dto.SimularEmprestimoPayload;
import br.com.cresol.desafio.service.EmprestimoService;

/**
 * @author johnny
 *
 */
@RestController
public class EmprestimoResource {

    @Autowired
    private EmprestimoService service;
  
    /**
     * Simular Emprestimo.
     *
     * @param payload the payload
     * @return the payload
     */
    @PostMapping(value = "/emprestimo/simular")
    public ResponseEntity<?> simular(@RequestBody SimularEmprestimoPayload payload) {    	
    	return new ResponseEntity<>(this.service.simular(payload), HttpStatus.OK);
    }
    
    /**
     * Contratar Emprestimo
     *
     * @param payload the payload
     * @return the payload
     */
    @PostMapping(value = "/emprestimo/contratar")
    public ResponseEntity<?> contratar(@RequestBody SimulacaoEmprestimo payload) {    	
    	return new ResponseEntity<>(this.service.contratar(payload), HttpStatus.OK);
    }
    
    /**
     * Delete task.
     *
     * @param id the task id
     * @return the task
     */
    @DeleteMapping(value = "/emprestimo/simular/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) { 
    	this.service.deletarSimulacao(Long.valueOf(id));
    	
        return new ResponseEntity<>("Simulacao " + id + " deletado com sucesso", HttpStatus.OK);
    }
}

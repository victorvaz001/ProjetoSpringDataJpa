package projeto.spring.data.aula.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.spring.data.aula.model.Telefone;

@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long> {

	
}

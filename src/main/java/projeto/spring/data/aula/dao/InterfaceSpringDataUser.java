package projeto.spring.data.aula.dao;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projeto.spring.data.aula.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long>{
	
	//busca o nome um ou varios usuarios onde contem o nome passado por parametro
	@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%") //JPQL
	@Transactional(readOnly = true) //metodo somente leitura
	public List<UsuarioSpringData> buscaPorNome (String nome);
	
	//busca somente um nome  que for passado no parametro, obs: passar o nome completo
	
	 //caso tiver um usuario consultando um ojbeto e outro querendo atualizar os mesmos registros, será bloqueado(controla)
	@Lock(LockModeType.READ)
	@Transactional(readOnly = true) //metodo somente leitura
	@Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
	public UsuarioSpringData buscaPornomeParam(@Param("paramnome") String paramnome);
	
	
	
	
	default <S extends UsuarioSpringData> S saveAtual(S entity) {
		//Processa qualquer coisa
		
		return save(entity);
	}
	
	
	//deleta um usuario passando por parametro
	
	@Modifying//modicação no bando de dados
	@Transactional//estartando uma transação
	@Query("delete from UsuarioSpringData u where u.nome = ?1")
	public void deletePorNome(String nome);
	
	//Atualizar usuario, setando email onde nome for igual que for recebido por prametro
	
	@Modifying
	@Transactional
	@Query("update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
	public void updateEmailPornome(String email, String nome);
	
	
	
	
}

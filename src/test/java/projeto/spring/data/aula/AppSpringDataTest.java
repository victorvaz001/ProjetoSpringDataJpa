package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.dao.InterfaceTelefone;
import projeto.spring.data.aula.model.Telefone;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired // injeção dedados, Spring
	private InterfaceSpringDataUser interfaceSpringDataUser; 
	
	@Autowired
	private InterfaceTelefone interfaceTelefone; 
	
	
	@Test
	public void testInsert() {

		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setNome("Egidio Alex");
		usuarioSpringData.setEmail("nivea_rock@yahoo.com.br");
		usuarioSpringData.setIdade(33);
		usuarioSpringData.setLogin("Egidio Alex santos");
		usuarioSpringData.setSenha("555666");

		interfaceSpringDataUser.save(usuarioSpringData);

		System.out.println("Usuarios cadastrados -> " + interfaceSpringDataUser.count());

	}

	@Test
	public void testeConsulta() {

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);

		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getId());
		
		for (Telefone telefone : usuarioSpringData.get().getTelefones()) {
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
			System.out.println(telefone.getId());
			System.out.println(telefone.getUsuario().getNome());
			System.out.println("----------------------------------");
		}

	}

	@Test
	public void testeConsultaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();

		for (UsuarioSpringData usuarioSpringData : lista) {

			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("---------------------------------------------------------");
		}

	}

	@Test
	public void testeUpdate() {

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(7L);

		UsuarioSpringData data = usuarioSpringData.get();

		data.setEmail("alexsilva@bol.com");

		interfaceSpringDataUser.save(data);
	}

	@Test
	public void testeDelete() {

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(5L);

		interfaceSpringDataUser.delete(usuarioSpringData.get());
	}

	@Test
	public void testeConsultaNome() {

		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Alex");

		for (UsuarioSpringData usuarioSpringData : list) {

			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("---------------------------------------------------------");
		}
	}

	@Test
	public void testeConsultaNomeParam() {

		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPornomeParam("Fernando Souza Santos Spring Data");

		System.out.println(usuarioSpringData.getEmail());
		System.out.println(usuarioSpringData.getNome());
		System.out.println(usuarioSpringData.getLogin());
		System.out.println(usuarioSpringData.getIdade());
		System.out.println(usuarioSpringData.getSenha());
		System.out.println(usuarioSpringData.getId());
		System.out.println("---------------------------------------------------------");

	}
	
	//deleta um ou varios usuarios, passado por parametro 
	@Test
	public void testeDeletePorNome() {
		interfaceSpringDataUser.deletePorNome("Alex Silva");
		System.out.println("Usuario deletado com sucesso!");
		
	}
	
	@Test
	public void testeEmailPorNome() {
		
		interfaceSpringDataUser.updateEmailPornome("fernando@uol.com.br", "Fernando Souza Santos Spring Data");
		System.out.println("Usuario atualizado com sucesso!");
		
	}

	
	@Test
	public void testeInsertTelefone() {
		
		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(2L);
		
		Telefone telefone = new Telefone();
		telefone.setTipo("Celular");
		telefone.setNumero("(31) 99585-9965");
		telefone.setUsuario(usuario.get());
		
		interfaceTelefone.save(telefone);
		
	}
}

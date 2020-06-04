# Projeto Spring Data JPA<br>

## Objetivo
* Projeto criado para utilização do framework Spring Data JPA, para facilitar o trabalho com persistência de dados<br>
  
## Tecnologias

* Java 1.8<br>
* Spring Data<br>
* JPA<br>
* Hibernate<br>
* JUnit<br>

## Classes
* UsuarioSpringData<br> 
* Telefone<br>
* AppSpringDataTest<br>

## Interfaces
* InterfaceSpringDataUser<br>
* InterfaceTelefone<br>


## Oservações:<br>

* Projeto configurado para criar tabelas automaticas com Hibernate<br>
* Utilização da interface CrudRepository do Spring Data <br>

## Testes<br>

* Criar um banco de dados com o Postgres, caso queire utilizar outro banco, basta mudar no arquivo (spring-config.xml)<br>
  Colocar as dependencias necessarias para outro banco de dados no arquivo, pom.xml<br>
* Executar os testes na classe AppSpringDataTest, executando os metodos com JUnit

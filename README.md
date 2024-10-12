<h2> Car System - CRUD de Carros com Spring Boot </h2>
Este projeto é um sistema CRUD de carros desenvolvido utilizando Java 17 com Spring Boot, aplicando os princípios de Domain-Driven Design (DDD) e Arquitetura Hexagonal. O projeto tem como objetivo ser um ponto de partida para sistemas mais complexos, permitindo fácil expansão e manutenção futura.

### Tecnologias Utilizadas:

Java 17
Spring Boot
Spring Data JPA
SQL Server (Driver JDBC para conexão com o banco de dados)
Maven (Para gerenciamento de dependências)
Lombok (Para reduzir o código boilerplate)
Spring Boot DevTools (Para facilitar o desenvolvimento)



### Arquitetura

O projeto segue a arquitetura hexagonal, também conhecida como Arquitetura de Portas e Adaptadores, separando o código em três camadas principais:

* Domínio (Domain Layer): Contém as entidades, objetos de valor e as interfaces dos repositórios. Essa camada representa as regras de negócio puras e não depende de frameworks ou tecnologias externas.

* Aplicação (Application Layer): Implementa os casos de uso do sistema, coordenando as regras de negócio do domínio com as entradas e saídas da aplicação.

* Adaptadores (Adapters Layer):
Entradas (Input): Implementações das APIs REST que expõem os serviços ao usuário.
Saídas (Output): Implementações dos repositórios utilizando Spring Data JPA para persistência no banco de dados SQL Server.


### Funcionalidades
Criar Carro: Adicionar um novo carro ao sistema com informações como marca, modelo e ano.
Listar Carros: Consultar todos os carros cadastrados no sistema.
Atualizar Carro: Editar as informações de um carro existente.
Deletar Carro: Remover um carro do sistema.


### Estrutura do Projeto
domain: Contém as entidades, repositórios e regras de negócio.
application: Casos de uso que orquestram a lógica do sistema.
adapters: Adaptadores para interação com APIs REST e persistência no banco de dados.
config: Configurações do Spring Boot e do sistema.

### Como Executar o Projeto

#### Pré-requisitos:
* Java 17 instalado
* Maven instalado
* Um banco de dados SQL Server disponível

CRUD-REST API

Projeto simples para CRUD de usuários (*estudantes no caso deste app, com as características: nome e idade*).

Tecnologias Utilizadas:
Java, Spring Framework, JPA (Java Persistence API), Hibernate, PostgreSQL

Configuração:
Pré-requisitos -> Java JDK 17+ e PostgreSQL 16.1

Configuração do Banco de Dados:
Instale o PostgreSQL e inicie o servidor;
Crie um banco de dados chamado 'crud-rest';
Atualize as configurações de conexão no arquivo application.properties com as credenciais do seu banco de dados.


GET: http://localhost:8080/estudantes --> Obter todos os usuários.
GET: http://localhost:8080/estudantes/1 --> Obter usuário de id 1, por exemplo.

POST: http://localhost:8080/estudantes
{
"nome":"Teste",
"idade":18
}
--> Insere o estudante com o nome "Teste" e sua idade. 

PUT: http://localhost:8080/estudantes/1 --> 
{
"nome":"João Guioto",
"idade":23
}
--> Atualiza os dados do estudante com o id selecionado (1) 

DELETE: http://localhost:8080/estudantes/2 --> Exclui um estudante existente.

A API conta com um tratamento de exceções para cada um dos métodos, caso o ID selecionado não exista.

Licença: 
Este projeto está sob a licença MIT, http://www.opensource.org/licenses/mit-license.php

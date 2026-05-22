# 📚 Sistema de Cursos Comunitários (API REST)

API desenvolvida em **Java com Spring Boot** para gerenciamento de um sistema de cursos comunitários, incluindo alunos, professores, cursos, matrículas e perfil socioeconômico.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation (Jakarta Validation)
- PostgreSQL
- Swagger / OpenAPI
- Maven

---

## 📌 Objetivo do sistema

O sistema permite:

- Cadastro de alunos
- Cadastro de professores
- Cadastro de cursos
- Matrícula de alunos em cursos
- Controle de status de matrícula
- Registro de perfil social dos alunos (dados socioeconômicos)

---

## 🧱 Modelo de domínio

### Principais entidades

- Aluno
- Professor
- Curso
- Matrícula
- PerfilSocial

---

## 🔗 Relacionamentos

- Aluno **1:1** PerfilSocial  
- Professor **1:N** Curso  
- Aluno **N:N** Curso (via entidade Matricula)  
- Curso **N:N** Aluno (via entidade Matricula)

---

## 📊 Estrutura do projeto
org.serratec.Trabindividual
│
├── domain # Entidades JPA
├── dto # Objetos de requisição e resposta
├── service # Regras de negócio
├── repository # Acesso ao banco de dados
├── mappers # Conversão Entity ↔ DTO
├── enums # Enumerações
├── exception # Tratamento de exceções
└── controller # Endpoints REST

---

## ⚙️ Configuração do banco de dados

Configure no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/TrabalhoIndividual
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

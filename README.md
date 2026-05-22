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

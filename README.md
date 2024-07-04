# AuthService-JWT

Este projeto é um serviço de autenticação e autorização usando Spring Boot e JWT (JSON Web Token). Ele fornece funcionalidades para registrar, autenticar usuários e validar tokens JWT através de uma API RESTful.


## Funcionalidades

- **Registro de Usuário:** Registre novos usuários com detalhes como nome, email, senha e telefone.
- **Autenticação de Usuário:** Autentique usuários existentes e gere tokens JWT para acesso seguro.
- **Proteção de Endpoints:** Proteja endpoints da API, exigindo tokens JWT válidos para acesso.
- **Validação de Tokens JWT:** Valide tokens JWT para autorizar acesso a recursos protegidos.

## Tecnologias Utilizadas

- **Spring Boot:** Framework para construção do microserviço.
- **Spring Data JPA:** Para interações com o banco de dados.
- **Spring Security:** Para autenticação e autorização.
- **JWT:** Para geração e validação de tokens.
- **H2 Database:** Banco de dados em memória para desenvolvimento e testes.
- **Maven:** Para gerenciamento de dependências e construção do projeto.

## Começando

### Pré-requisitos

- Java 21 ou superior
- Maven

## Endpoints da API

### Registrar um Usuário

**POST** `/api/auth/signup`

#### Corpo da Requisição:
```json
{
  "username": "testuser",
  "email": "testuser@example.com",
  "password": "password123",
  "phone": "1234567890"
}
```
#### Resposta de Sucesso:
```json
{
  "success": true,
  "message": "User registered successfully"
}
```

### Autenticar um Usuário

**POST** `/api/auth/signin`

#### Corpo da Requisição:
```json
{
  "email": "testuser@example.com",
  "password": "password123"
}
```
#### Resposta de Sucesso:
```json
{
  "accessToken": "jwt_token",
  "tokenType": "Bearer"
}
```
### Endpoint Protegido
**GET** `/api/test/`

#### Cabeçalhos:
  Authorization: Bearer {jwt_token}
  
#### Resposta de Sucesso:
```json
{
  "message": "Test Successful"
}
```

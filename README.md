
# Projeto Integrador API

Este documento descreve a API do Projeto Integrador, que fornece operações relacionadas a usuários.



## Stack utilizada



**Back-end:** Quarkus

**Banco de Dados:** PostgreSQL

## Colaboradores

- [Breno Ryan de Oliveira Lima](https://github.com/brenoRyan77)
- [Luan Lucas Barbosa de Oliveira](https://github.com/LuanBarb0sa)
- [Igor Galdino Beltrão do Nascimento]()
- [Gustavo Antônio Lopes Nóbrega]()
## Documentação da API

## Endpoints

### Listar Usuários

Retorna a lista de usuários cadastrados.

**Endpoint:** `/api/usuario`

- Método: GET
- Tags: Usuário
- Respostas:
  - 200: Requisição bem-sucedida. Retorna a lista de usuários.

### Cadastrar Usuário

Cadastra um novo usuário.

**Endpoint:** `/api/usuario`

- Método: POST
- Tags: Usuário
- Corpo da Requisição:
  - Tipo de mídia: application/json
  - Esquema: UsuarioDTO (consulte a descrição do esquema abaixo)
- Respostas:
  - 200: Requisição bem-sucedida. O usuário foi cadastrado com sucesso.

### Obter Usuário por CPF

Retorna as informações do usuário com o CPF especificado.

**Endpoint:** `/api/usuario/{cpf}`

- Método: GET
- Tags: Usuário
- Parâmetros:
  - cpf (obrigatório): CPF do usuário
- Respostas:
  - 200: Requisição bem-sucedida. Retorna as informações do usuário.

### Obter Usuário por ID

Retorna as informações do usuário com o ID especificado.

**Endpoint:** `/api/usuario/{id}`

- Método: GET
- Tags: Usuário
- Parâmetros:
  - id (obrigatório): ID do usuário
- Respostas:
  - 200: Requisição bem-sucedida. Retorna as informações do usuário.

### Atualizar Usuário

Atualiza as informações do usuário com o ID especificado.

**Endpoint:** `/api/usuario/{id}`

- Método: PUT
- Tags: Usuário
- Parâmetros:
  - id (obrigatório): ID do usuário
- Corpo da Requisição:
  - Tipo de mídia: application/json
  - Esquema: UsuarioDTO (consulte a descrição do esquema abaixo)
- Respostas:
  - 200: Requisição bem-sucedida. As informações do usuário foram atualizadas com sucesso.

### Excluir Usuário

Exclui o usuário com o ID especificado.

**Endpoint:** `/api/usuario/{id}`

- Método: DELETE
- Tags: Usuário
- Parâmetros:
  - id (obrigatório): ID do usuário
- Respostas:
  - 200: Requisição bem-sucedida. O usuário foi excluído com sucesso.

## Esquemas de Dados

### UsuarioDTO

O esquema de dados "UsuarioDTO" representa os atributos de um usuário.

Propriedades:

- nome:
  - Tipo: string
  - Tamanho máximo: 100 caracteres
  - Tamanho mínimo: 3 caracteres
  - Padrão: "^[\\p{L}\\s]+$" (somente letras e espaços)
- sobrenome:
  - Tipo: string
  - Tamanho máximo: 100 caracteres
  - Tamanho mínimo: 3 caracteres
  - Padrão: "^[\\p{L}\\s]+$" (somente letras e espaços)
- email:
  - Tipo: string
  - Padrão: \S (qualquer caractere não vazio)
- cpf:
  - Tipo: string
  - Tamanho máximo: 14 caracteres
  - Padrão: "^[0-9]+$" (somente dígitos numéricos)
- rg:
  - Tipo: string
  - Tamanho máximo: 9 caracteres
  - Padrão: "^[0-9]+$" (somente dígitos numéricos)
- telefone:
  - Tipo: string
  - Padrão: "^[0-9]+$" (somente dígitos numéricos)

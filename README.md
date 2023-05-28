
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

#### Retorna todos os usuários

```http
  GET /api/usuario
```

#### Retorna um usuário

```http
  GET /api/usuario/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do usuário que você quer buscar |

#### Retorna um usuário

```http
  GET /api/usuario/${cpf}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cpf`      | `String` | **Obrigatório**. O CPF do usuário que você quer buscar |

#### Cadastra um usuário

```http
  POST /api/usuario
```

| Corpo da requisição   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **Obrigatório**.
| `sobrenome`      | `String` | **Obrigatório**.
| `email`      | `String` | **Obrigatório**.
| `cpf`      | `String` | **Obrigatório**.
| `rg`      | `String` | **Obrigatório**.
| `telefone`      | `String` | **Obrigatório**.

#### Altera um usuário

```http
  PUT /api/usuario/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do usuário que você quer alterar |

| Corpo da requisição   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **Obrigatório**.
| `sobrenome`      | `String` | **Obrigatório**.
| `email`      | `String` | **Obrigatório**.
| `cpf`      | `String` | **Obrigatório**.
| `rg`      | `String` | **Obrigatório**.
| `telefone`      | `String` | **Obrigatório**.

#### Deleta um usuário

```http
  DELETE /api/usuario/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do usuário que você quer deletar |

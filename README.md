# 💻 API REST com Spring Boot 3 — Publicação na Nuvem com Railway

Este projeto é uma aplicação Java baseada em Spring Boot 3, desenvolvida como parte da atividade _"Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway"_ da DIO. A aplicação simula uma estrutura bancária básica com cadastro de usuários, contas, cartões, funcionalidades e notícias.

## 🚀 Tecnologias utilizadas

- Java 17 (ou superior)
- Spring Boot 3
- Spring Data JPA
- PostgreSQL (produção) / H2 (desenvolvimento)
- OpenAPI/Swagger
- Railway (deploy)
- Gradle

## 📦 Funcionalidades da API

A API permite:

- Criar um novo usuário
- Buscar usuário por ID
- Cadastro automático de conta, cartão, funcionalidades e notícias vinculadas a um usuário

### Exemplo de Requisição `POST /users`

```json
{
  "name": "Maria Silva",
  "account": {
    "number": "123456",
    "agency": "0001",
    "balance": 1000.00,
    "limit": 500.00
  },
  "card": {
    "number": "9876543210",
    "limit": 1200.00
  },
  "features": [
    {
      "icon": "pix",
      "description": "Transferências via Pix"
    }
  ],
  "news": [
    {
      "icon": "cashback",
      "description": "Receba 5% de volta nas compras com cartão"
    }
  ]
}

```

## 🔐 Tratamento de Erros
A aplicação possui tratamento global de exceções:

  - `IllegalArgumentException`: erro de regra de negócio (HTTP 422)

  - `NoSuchElementException`: recurso não encontrado (HTTP 404)

  - Outros erros não previstos: erro interno do servidor (HTTP 500)

## 🗂️ Estrutura de Pastas

```
src
└── main
    └── java
        └── dio.api
            ├── App.java
            ├── controller
            │   ├── UserController.java
            │   └── exception
            ├── domain
            │   ├── model
            │   └── repository
            └── service
                ├── UserService.java
                └── impl
```

## ⚙️ Perfis de Ambiente

  - Desenvolvimento usa banco H2 em memória com console ativado (`/h2-console`)
  - Produção usa PostgreSQL com variáveis de ambiente via Railway

 ```yaml
# application.yaml (desenvolvimento)
spring:
  datasource:
    url: jdbc:h2:mem:bjcn2025
  h2:
    console:
      enabled: true

# application.yaml (produção)
spring:
  datasource:
    url: jdbc:postgresql://${PGHOST}:${PGPORT}/${PGDATABASE}
```

## 🌍 Documentação da API

Acesse a documentação Swagger gerada automaticamente:
```bash
/swagger-ui.html
```

## ☁️ Deploy com Railway
O deploy foi feito de forma automatizada com GitHub + Railway, utilizando variáveis de ambiente para a configuração do banco PostgreSQL na nuvem.

## ▶️ Como executar localmente

1. Clone o repositório:

```bash
git clone https://github.com/higorv10/dio-api.git
cd dio-api
```

2. Execute com o Gradle:

```bash
./gradlew bootRun
```

3. Acesse o Swagger:

```bash
http://localhost:8080/swagger-ui.html
```

## 📄 Licença
Projeto desenvolvido para fins educacionais na DIO. Sem licença comercial.



    

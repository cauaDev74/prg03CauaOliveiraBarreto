# PRG03 — Programação Orientada a Objetos

Repositório da disciplina de **Programação Orientada a Objetos** (ADS — IFBA),
reunindo os conceitos vistos em aula aplicados a um projeto único: o back-end
de um **e-commerce de autopeças**, construído em **Java** com **Spring Boot**.

Cada atividade da disciplina é entregue numa branch própria, com PR revisado
e testes JUnit cobrindo o que foi implementado — então o histórico de commits
e PRs deste repositório é, na prática, o histórico de aprendizado da matéria.

## Sobre o projeto

O domínio é o de uma loja de autopeças vendendo online: usuários se cadastram,
autenticam, montam pedidos com itens de um catálogo de produtos. É um projeto
real (pensado para um negócio da família), usado aqui como base prática pra
aplicar cada conceito de POO — classes e objetos, relacionamentos, herança,
polimorfismo — conforme a disciplina avança.

## Stack

- **Java** — linguagem principal
- **Spring Boot** — framework de back-end (em construção ao longo da matéria)
- **JUnit 5** — testes unitários
- **Maven** — build e dependências
- **Git/GitHub** — uma branch `feature/atividade-XX-nome` por atividade, com PR para `main`

## Estrutura

```
src/main/java/br/com/ifba/prg03cauaoliveirabarreto/
├── entity/        # Classes do domínio (Usuario, Cliente, Admin, Pedido, ItemPedido, Produto...)
├── interfaces/     # Contratos (ex.: Autenticavel)
├── service/         # Regras de negócio que operam sobre o domínio
├── validar/        # Validações de dados de entrada
└── view/           # Telas (Swing)

src/test/java/...    # Testes JUnit, espelhando o pacote de cada classe testada
```

## Convenção de entrega

1. Branch `feature/atividade-XX-nome-da-atividade` a partir da `main`
2. Implementação + testes
3. Print da suíte completa passando, salvo em `ATIVIDADE XX - NOME/`
4. Pull Request para `main`, com descrição do que foi feito e por quê
5. Revisão do diff → merge → delete da branch

## Notas de design

**Por que `Usuario` tem dois construtores?** Um vazio (construção incremental
via setters — útil em cadastros feitos em etapas, ou em testes que montam o
objeto aos poucos) e um com os 5 campos obrigatórios (quando os dados já
chegam prontos de uma vez — como `Cliente`/`Admin` montando o `Usuario`
herdado num único passo, via `super(...)`). Sobrecarga sem motivo é só código
duplicado — essa aqui resolve dois cenários reais e distintos.

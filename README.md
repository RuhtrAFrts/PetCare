# 🐾 PetCare Hub — Sistema de Gestão para Pet Shop

## 📌 Objetivo

Transformar o gerenciamento de serviços de pet shop em um backlog ágil e rastreável no GitHub, com mapeamento de personas, User Stories e critérios de aceitação.

O projeto também contempla a implementação gradual das funcionalidades propostas, utilizando Java e Spring Boot.

## 👥 Perfis de Usuário (Personas)

1. **Tutor (Cliente):** Busca agendar banhos/consultas e acompanhar o histórico do seu animal de estimação.
2. **Atendente (Recepção):** Organiza a agenda do estabelecimento, confirma consultas e notifica os tutores.
3. **Profissional (Vet/Tosador):** Executa os serviços, altera o status do atendimento e registra diagnósticos/prontuários.

## 🚀 Backlog do Produto (User Stories)

O repositório conta com **8 User Stories** cadastradas no [GitHub Issues](../../issues) e organizadas no quadro Kanban:

- **US01:** Cadastro de Cliente e Pet (Alta Prioridade)
- **US02:** Agendamento de Serviços (Alta Prioridade)
- **US03:** Histórico de Atendimentos do Pet (Média Prioridade)
- **US04:** Visualização e Filtro da Agenda (Alta Prioridade)
- **US05:** Reagendamento e Cancelamento (Média Prioridade)
- **US06:** Registro de Prontuário Veterinário (Média Prioridade)
- **US07:** Atualização de Status do Banho/Tosa (Alta Prioridade)
- **US08:** Notificação de Retirada (Baixa Prioridade)

## 📋 Quadro de Acompanhamento

Acompanhe o andamento das tarefas na aba **Projects** do repositório ou pelo quadro Kanban do GitHub.

---

## 💻 Implementação — US01: Cadastro de Cliente e Pet

Foi implementada a funcionalidade de cadastro de tutor e pet, utilizando arquitetura em camadas e o padrão MVC.

### Organização do projeto

```text
src/main/java/br/com/petcare/
├── controller/   # recebe as requisições HTTP
├── dto/          # dados de entrada e saída
├── exception/    # exceções e tratamento de erros
├── model/        # entidades Tutor e Pet
├── repository/   # acesso ao banco de dados
├── service/      # regras e fluxo do cadastro
└── PetCareApplication.java
```

### Fluxo da funcionalidade

```text
Requisição HTTP
      |
      v
TutorPetController
      |
      v
CadastroTutorPetService
      |                  |
      v                  v
TutorRepository      PetRepository
      |                  |
      +--------+---------+
               v
            Banco H2
```

O Controller recebe os dados
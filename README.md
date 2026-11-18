# PetCare — Cadastro de Tutor e Pet

Projeto prático da Aula 09 — Arquitetura em Camadas e MVC.

## O que foi desenvolvido

Foi escolhida a User Story **US01 — Cadastro de Cliente e Pet**. A API recebe os dados de um tutor e de seu animal, verifica se o CPF já está cadastrado e, se estiver tudo certo, salva os dois registros relacionados.

## Organização do projeto

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

## Fluxo da funcionalidade

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

O Controller recebe os dados e chama o Service. A regra para impedir CPF repetido fica no Service. Os Repositories fazem a comunicação com o banco. Assim, o Controller não concentra a lógica de negócio.

## Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 (banco em memória)
- JUnit e Mockito para o teste unitário

## Como executar

É necessário ter Java 17 ou superior e Maven instalado.

1. Abra esta pasta no VS Code ou IntelliJ.
2. No terminal, dentro da pasta do projeto, execute:

   ```bash
   mvn spring-boot:run
   ```

3. A API ficará disponível em `http://localhost:8080`.

## Como testar o cadastro

Envie uma requisição `POST` para:

`http://localhost:8080/api/cadastros/tutor-pet`

Com o corpo JSON:

```json
{
  "nomeTutor": "Ana Souza",
  "cpf": "12345678901",
  "telefone": "34999999999",
  "nomePet": "Rex",
  "especie": "Cachorro",
  "raca": "SRD",
  "idade": 3
}
```

Se o cadastro for realizado, a API retorna HTTP 201 com os identificadores do tutor e do pet. Se o CPF já existir, retorna HTTP 409 com uma mensagem de erro.

## Teste automatizado

Foi criado um teste unitário para conferir o caso de CPF duplicado. Ele verifica se a exceção é lançada e se nenhum dos dois registros é salvo.

Para executar os testes:

```bash
mvn test
```

## Relação com a atividade

A entrega contém a User Story escolhida, o fluxo Controller → Service → Repository, a estrutura de pastas, a implementação da funcionalidade, um teste unitário e este README com o diagrama da arquitetura.

**Observação:** os commits e a Pull Request devem ser registrados no GitHub pelo integrante que possui acesso de escrita ao repositório. Os nomes de commits e a descrição sugerida da PR podem ser preparados a partir das etapas do desenvolvimento, mas não devem ser apresentados como ações já realizadas.

<div align="center">

# 🤖 Discord To-Do List Bot
### Um bot de Discord em **Java + Spring Boot** para gerenciar tarefas pessoais

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge)
![JDA](https://img.shields.io/badge/JDA-Discord_API-blue?style=for-the-badge)
![H2 Database](https://img.shields.io/badge/Database-H2-lightgrey?style=for-the-badge)

</div>

---

## 📌 Sobre o Projeto

Este bot permite gerenciar uma **lista de tarefas diretamente pelo Discord**, usando comandos simples.  
Desenvolvido para demonstrar conceitos essenciais como:

- ✔️ CRUD completo  
- ✔️ Injeção de Dependência  
- ✔️ Eventos com JDA  
- ✔️ Persistência com Spring Data JPA  

Ideal como projeto de estudo ou base para bots mais complexos.

---

## 🚀 Funcionalidades

- **Adicionar tarefas (`!add`)**
- **Listar tarefas (`!list`)**
- **Marcar como concluída (`!done`)**
- **Remover tarefas (`!remove`)**

O bot armazena tudo no banco H2 e identifica cada tarefa pelo **ID do usuário no Discord**.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Função |
|-----------|--------|
| **Java 21** | Linguagem principal |
| **Spring Boot 3** | Configuração automática + Injeção de dependência |
| **Spring Data JPA** | Acesso ao banco e abstração de repositórios |
| **H2 Database** | Banco em memória |
| **JDA** | Conexão com o Discord |
| **Lombok** | Reduz código boilerplate |

---

## ⚙️ Como Rodar o Projeto

### 1️⃣ Pré-requisitos
- JDK 21 instalado  
- Maven  
- Um bot criado no [Discord Developer Portal](https://discord.com/developers/applications)

### 2️⃣ Instalação e Clone
Clone o repositório para sua máquina:

```bash
git clone [https://github.com/raoni-silla/BotDiscordToDoList.git](https://github.com/raoni-silla/BotDiscordToDoList.git)
cd BotDiscordToDoList
```

### 3️⃣ Configuração do Token

Crie manualmente o arquivo `application.properties` dentro da pasta `src/main/resources/`:

**Arquivo:** `src/main/resources/application.properties`

```properties
spring.application.name=BotDiscordToDoList
spring.h2.console.enabled=true

# Token do seu bot do Discord
discord.token=COLE_SEU_TOKEN_AQUI
```

### 4️⃣ Ativar INTENTS no Discord
No portal do desenvolvedor, na aba **Bot** > **Privileged Gateway Intents**, ative:
- [x] **MESSAGE CONTENT INTENT**

### 5️⃣ Executar o projeto

Pelo terminal:
```bash
./mvnw spring-boot:run
```

Ou execute a classe principal na sua IDE:
`BotDiscordToDoListApplication`

---

## 🎮 Comandos Disponíveis

| Comando | Exemplo | Função |
| :--- | :--- | :--- |
| `!add <texto>` | `!add Comprar Leite` | Adiciona uma nova tarefa |
| `!list` | `!list` | Lista tarefas pendentes e concluídas |
| `!done <id>` | `!done 1` | Marca a tarefa como concluída |
| `!remove <id>` | `!remove 1` | Remove a tarefa pelo ID |

---

## 🧩 Arquitetura do Projeto

- **BotListener (Controller/Event Listener)**: Responsável por escutar e tratar os eventos vindos do Discord.
- **TaskService (Service)**: Onde ficam as regras de negócio: validações, lógica e manipulação das tarefas.
- **TaskRepository (Repository)**: Interface JPA usada para acessar o banco de dados.
- **Task (Model)**: Entidade que representa a tabela no banco.

---

## 🛣️ Roadmap / Melhorias Futuras

- [ ] Implementar testes unitários com JUnit e Mockito
- [ ] Migrar do banco H2 para PostgreSQL ou MySQL
- [ ] Melhorar visual usando Discord Embeds
- [ ] Novas validações e tratamento de erros

---

<div align="center">

### 👨‍💻 Desenvolvido por **Raoni Silla**

⭐ Se este projeto te ajudou, considere deixar uma estrela! ⭐

</div>

# **EcoConnect - Plataforma de Conscientização e Engajamento Sustentável**

## **Descrição do Projeto**
O EcoConnect é uma aplicação desenvolvida para incentivar práticas sustentáveis por meio de conteúdo educacional, interações dinâmicas e ferramentas de gamificação. A plataforma permite que usuários explorem dicas de economia, forneçam feedback, interajam com conteúdos educativos e participem de quizzes.

## **Funcionalidades Principais**
- **Gerenciamento de Usuários**: Cadastro, autenticação e gestão de usuários com segurança.
- **Conteúdo Educativo**: Dicas diárias de economia de energia e artigos sobre sustentabilidade.
- **Interações e Feedbacks**: Registro de interações e envio de feedback sobre conteúdos.
- **Quiz Sustentável**: Sistema de quizzes com pontuações para engajar os usuários.
- **Histórico e Relatórios**: Acompanhamento de interações e atividades realizadas.

## **Integrantes do Grupo**
- **Nicola Monte Cravo Garofalo**: Desenvolvedor do código-fonte.
- **Willyam Santos Sousa**: Desenvolvedor do código-fonte.    
- **Igor Akira Bortolini Tateishi**: Responsável pela documentação do projeto.

## **Links Relevantes**
- **Proposta Tecnológica**: [Video com código](link aqui)
- **Pitch do Projeto**: [Pitch](link aqui)

## **Problema**
Hoje, muitas pessoas desejam adotar práticas sustentáveis, mas enfrentam barreiras como falta de conhecimento, soluções complexas ou falta de motivação. O EcoConnect foi projetado para simplificar esse processo, tornando o aprendizado sustentável mais acessível e engajador.

## **Solução**
A plataforma EcoConnect utiliza uma abordagem interativa para transformar a educação ambiental em uma experiência intuitiva e motivadora, com funcionalidades gamificadas e conteúdos relevantes.

## **Público-Alvo**
- Consumidores interessados em práticas sustentáveis.
- Jovens adultos preocupados com o impacto ambiental.
- Pequenos negócios buscando melhorar sua pegada ambiental.

## **Tecnologias Utilizadas**
- **Backend**: Spring Boot
- **Banco de Dados**: H2 (em memória)
- **Documentação**: Swagger

## **Como Configurar e Rodar o Projeto**
1. **Pré-requisitos**:
   - Java 17 instalado.
   - Ferramenta de build Gradle instalada.

2. **Passos**:
   1. Clone o repositório:
      ```bash
      git clone <url-do-repositorio>
      ```
   2. Rode o projeto:
      ```bash
      ./gradlew bootRun
      ```
   3. Acesse o console do H2:
      - URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
      - Configuração:
        - **JDBC URL**: `jdbc:h2:mem:testdb`
        - **User**: `sa`
        - **Password**: vazio.

   4. Acesse a documentação Swagger:
      - URL: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## **Listagem de Endpoints**

### **Usuários (`/usuarios`)**
- **GET** `/usuarios`: Lista todos os usuários.
- **GET** `/usuarios/{id}`: Detalha um usuário específico.
- **POST** `/usuarios`: Cria um novo usuário.
- **PUT** `/usuarios/{id}`: Atualiza um usuário existente.
- **DELETE** `/usuarios/{id}`: Remove um usuário.

### **Conteúdos (`/conteudos`)**
- **GET** `/conteudos`: Lista todos os conteúdos.
- **GET** `/conteudos/{id}`: Detalha um conteúdo específico.
- **POST** `/conteudos`: Cria um novo conteúdo.
- **PUT** `/conteudos/{id}`: Atualiza um conteúdo existente.
- **DELETE** `/conteudos/{id}`: Remove um conteúdo.

### **Dicas de Economia (`/dicas-economia`)**
- **GET** `/dicas-economia`: Lista todas as dicas.
- **GET** `/dicas-economia/{id}`: Detalha uma dica específica.
- **POST** `/dicas-economia`: Cria uma nova dica.
- **PUT** `/dicas-economia/{id}`: Atualiza uma dica existente.
- **DELETE** `/dicas-economia/{id}`: Remove uma dica.

### **Feedbacks (`/feedbacks`)**
- **GET** `/feedbacks`: Lista todos os feedbacks.
- **GET** `/feedbacks/{id}`: Detalha um feedback específico.
- **POST** `/feedbacks`: Cria um novo feedback.
- **PUT** `/feedbacks/{id}`: Atualiza um feedback existente.
- **DELETE** `/feedbacks/{id}`: Remove um feedback.

### **Interações (`/interacoes`)**
- **GET** `/interacoes`: Lista todas as interações.
- **GET** `/interacoes/{id}`: Detalha uma interação específica.
- **POST** `/interacoes`: Cria uma nova interação.
- **PUT** `/interacoes/{id}`: Atualiza uma interação existente.
- **DELETE** `/interacoes/{id}`: Remove uma interação.

### **Pontuações de Quiz (`/pontuacoes-quiz`)**
- **GET** `/pontuacoes-quiz`: Lista todas as pontuações.
- **GET** `/pontuacoes-quiz/{id}`: Detalha uma pontuação específica.
- **POST** `/pontuacoes-quiz`: Cria uma nova pontuação.
- **PUT** `/pontuacoes-quiz/{id}`: Atualiza uma pontuação existente.
- **DELETE** `/pontuacoes-quiz/{id}`: Remove uma pontuação.

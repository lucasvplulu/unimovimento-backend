<h1 align="center"> UNIMOVIMENTO BACKEND </h1>
<h2 align="center"> 💻 Sistema para Gerenciamento e Administração do Uni Movimento 💻</h2>

<h3 align="center">***********🔧 INSTRUÇÕES 🔧***********</h3>
<h4 align="center">🏗️ Em Construção...🏗️</h4>

### Versão do projeto
1.0.0

### Links Úteis
- Repositório backend: https://github.com/unimovsistemas/unimovimento-backend
- Repositório frontend: https://github.com/unimovsistemas/unimovimento-frontend
- Discovery: https://miro.com/app/board/uXjVOhGfNZ0=/

### Requisitos para Desenvolvimento e Execução
- Java 11 (LTS) - https://www.azul.com/downloads/?version=java-11-lts&package=jdk
- PostgresSql (versão mínima recomendada: 15) - https://www.postgresql.org/download/
- Maven (versão mínima recomendada: 3.8.6) - https://www.youtube.com/watch?v=-ucX5w8Zm8s
- Git (versão mínima recomendada: 2.39.1) - https://www.youtube.com/watch?v=Ljo4Xu84y9A&list=PLNuUvBZGBA8nDTr8QRMgoT_l3XNt_BbWj&index=2
- IDE de sua preferência (recomendado Intellij IDEA Community Edition) - https://www.jetbrains.com/idea/download/?source=google&medium=cpc&campaign=9736964299&term=intellij%20idea&content=602143185523&gclid=Cj0KCQiAic6eBhCoARIsANlox86bXnCCLjaBQgU9heCAFmp_toxT2AZ729YLNWpKPm34X8a6YGBZylgaAiGWEALw_wcB#section=windows
- Configurar variáveis de ambiente para Java e Maven.

### Orientações para Desenvolvimento
- Clonar o repositório para sua máquina, de preferência pelo link SSH. Veja mais: https://docs.github.com/en/authentication/connecting-to-github-with-ssh
- Não commitar diretamente na branch main.
- Criar branch para cada demanda que irá atuar, seguindo sempre a nomenclatura **feature/unimovXX** em caso de implementações, onde XX deverá ser substituído pelo número da tarefa (ex: feature/unimov01). Em casos de correação de erros, seguir a nomenclatura **bugfix/unimovXX**, onde XX deverá ser substituído pelo número da tarefa (Ex: bugfix/unimov02). As tarefas serão criadas na ferramenta Jira.
- Todos os merges para a branch main serão mediantes a aprovação de PullRequest. Portanto, todo PullRequest deverá possuir um Reviewer que irá realizar o Code Review.
- Seguir as boas práticas de desenvolvimento baseadas no CleanCode, Padrões de Projeto e Arquitetura Limpa.
- Todas as classes deverão ser criadas dentro de seu contexto de domínio. Por exemplo, a Pessoa é um domínio do nosso negócio, portanto, tudo o que pertencer a Pessoa deve estar dentro do pacote Pessoa, isto é, entidade, controladores, serviços e repositórios, bem como suas composições (endereço, contato, documentos, etc).
- Toda entidade que precisa ser criada/alterada no banco de dados para representar a classe deverá respeitar o versionamento dos scripts de migração gerenciado pelo Flyway disponível em ***./src/main/resources/db/migration***.
- Nunca altere os scripts de migração já existentes, pois problemas de scripts anteriores podem ser corrigidos criando novos scripts de migração, como por exemplo, renomear uma entidade ou alterar o tipo de uma coluna. Alterar um script de migração já existente poderá comprometer a base de dados em produção.
- Não commite arquivos de propriedades/configurações (Ex: application.properties, pom.xml, system.properties, etc), exceto se fizer parte da implementação que você está trabalhando.
- Você pode adicionar novas recomendações aqui que podem ser úteis ao longo do desenvolvimento para outros devs.

### Execução

Orientações para execução do programa:
- Abrir terminal no diretório principal do projeto e executar o comando maven: mvn clean generate-sources para realizar download das dependências do projeto.
- Verificar no PostgreSQL se existe um database com o nome ***postgres***. Caso contrário, você deve criá-lo com este nome.
- Acessar o arquivo ***./src/main/resources/application-dev.properties*** e inserir o usuário e senha do seu database.
- Se for rodar em produção (ex: deploy Heroku), você deve acessar ***./src/main/resources/application.properties*** e alterar o valor da chave ***spring.profiles.active*** para **prod**.
- Executar programa através da classe AppApplication disponível em ***./src/main/java/com/unimovimento/app***.
- Ao executar a aplicação, se tudo ocorrer bem, o schema **unimovimento** deverá ter sido criado no database **postgres** e ao acessar o endereço **localhost:8001** no navegador deverá abrir uma página com mensagem ***Whitelabel Error Page***.

OBS: Se a porta 8001 já estiver sendo utilizada em seu ambiente local, você deve acessar o arquivo ***application-dev.properties*** e alterar a propriedade **server.port** para uma outra porta disponível. **Não commite essa alteração!**
### Tecnologias utilizadas

- Maven: 3.8.6 -> https://maven.apache.org/download.cgi

- JDK: 11.0.0 -> https://jdk.java.net/archive/

- Spring 2.7.3 -> https://start.spring.io/

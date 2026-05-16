
---

# 📺 FeiTv
> Simulalação de streaming de filmes feito em **JAVA** e **POSTGRES SQL**

Este projeto é uma **simulalação de streaming de filmes**, feito em **JAVA**, com **um banco de dados feito em POSTGRES SQL**.
Permite **cadastro e login de usuários**, **menu interativo de filmes separado por genêro**, **criação de gerenciamento de listas de filmes e uma lista padrão de favoritos**, além de **avaliação de filme**.
**O único uso de IA foi para criar o INSERT de filmes para o banco de dados**

---

## 📦 Instalação e Execução

### 🔹 1. Clonar o repositório

```bash
git clone https://github.com/LucasLeiteFernandes/FeiTv
```

### 🔹 2. Configurar o banco de dados
- Clicar com o botão direito do mouse em Server
- Na aba 'General' dar um nome ao server
- Na aba 'Connection' 
-  -> 'Host name/address': localhost
-  -> 'Port': 5432
-  -> 'Username': postgres
-  -> 'Password': 4Lh3i0s$
- Na databse 'Postgres' clicar com o botão direito em 'Schemas' -> botão direito em 'Tables' -> 'Query Tool'
- Na Query Tool colar todo o conteudo do aquivo bdFeitv.sql

### 🔹 3. Execução do programa
- Abrir a pasta FeiTv no Apache NetBeans
- Abrir o pacote feitv
- Abrir o arquivo FeiTv.java e executar com 'shift + f6'

---
## 🧠 Estrutura do Projeto MVC
```
FeiTv/
├── Source Packages
  ├── controller      # Pacote de classes de controle de interação com o banco de dados
  ├── dao             # Pacote de classes de interação com o banco de dados
  ├── feitv           # Pacote da classe com metodo Main
  ├── model           # Pacote de classes com os tipos de dados
  ├── view            # Pacote de classes de JForm que crião as interfaces
├── Test Packages
├── Libraries         # Contem o JDK e o postgressql.jar
```
---
### 🔸 Estrutura do banco de dados
```
├── Tables
  ├── tbusuarios      # tabela de usuarios
    ├── email           # chararater varying
    ├── nome            # chararater varying
    ├── senha           # chararater varying
  ├── tbfilmes        #  tabela de filmes
    ├── titulo          # chararater varying
    ├── descricao       # chararater varying
    ├── genero          # chararater varying
    ├── horas           # integer
    ├── minutos         # integer
    ├── segundos        # integer
    ├── avaliacoes      # double precision
    ├── nAvaliacoes     # integer
  ├── tblistas         # tabela com nome e email do dono de uma lista
    ├── email           # chararater varying
    ├── nome            # chararater varying
  ├── tbfavoritos      # tabela com nome do filme e email
    ├── email           # chararater varying
    ├── filme           # chararater varying
  ├── tb+email+nome    # tabela criada para cada lista criada por um usuario
    ├── filme           # chararater varying
```

---
### 🔸 🧩 Login e cadastro
Ao executar o programa a primeira pagina a aparecer vai ser a de login que contem as caixas de texto para inserir email e senha, e os botão de entrar e cadastrar.
A pagina de cadastro contem as caixas de texto para nome, email e senha.
Ao logar, um metodo do controleLogin é executado para criar um ArrayList<Filme>
que será passado como parametro à pagina home junto ao usuario logado.

---

### 🔸 🧩 Pagina Home
No cabeçalho da pagina temos:
- O nome do programa
- Uma barra de pequisa(Não sensitiva)
- Uma label com o nome do usuario
- Os botões 'Criar Lista' e 'Ver Listas'
Abaixo temos 4 linhas de 6 filmes dos generos:
- Terror
- Ficção
- Romance
- Musical
Os pôsteres dos filmes são gerados pelo metodo 'iniciar()' eles possui:
- um contador para cada genero de filme
- a instancia de um GroupLayout
- for(int i = 0; i < filmes.size(); i++): instancia uma variavel lbl_poster do tipo JLabel e copia o genero do filmes.get(i) para uma String, cada String passa por if para cada genero, que contem os parametros que serao passados para o metodo criarPoster(int gap, Color cor, Color backgroundColor , JLabel lbl_poster, javax.swing.GroupLayout layout, int i, int j, String font) os parametros sao usados para personalizar o poster de acordo com genero do filme
- Ao clicar em um poster será redirecionado à pagina reprodução

---

### 🔸 🧩 Pagina reprodução
Pagina que simula o layout de Streamings como YouTube, a pagina contem:
- Informações do fime:
  - Titulo
  - Descrição
  - Tempo
  - Nota
- Botões:
  - Availar: cria uma janela com um textField para inserir uma nota de 0 - 5 e um botão 'ENVIAR'
  - Favoritar: adiciona o filme a lista padrão: favoritos
  - Adicionar a lista de reprodução: cria uma janela mostrando todas as listas do usuario, adiciona o filme ao clicar na lista com o botão direito do mouse
  - botões não funcionais apenas para simulação

---

### 🔸 🧩 Pagina de Listas
Contem o mesmo cabeçalho da pagina home, e os metodos de criacao de postor bem semelhante aos da pagina home


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
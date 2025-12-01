<h1 align="center">📱 School — Aplicativo de Cadastro e Gestão de Usuários</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Linguagem-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" />
  <img src="https://img.shields.io/badge/Desenvolvimento-Concluído-brightgreen?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Arquitetura-MVVM-blue?style=for-the-badge" />
</p>

---

## 👥 Autores

| Nome                              | RA       |
|-----------------------------------|----------|
| **Jullya Mendonça Brandão Nigro** | 2402577  |
| **Humberto Lisboa**               | 2402662  |
| **Paulo Henrique**                | 2402602  |
| **Gustavo Meirelles**             | 2403079  |
| **Melissa Moura**                 | 2403008  |

---

---

# 📥 Como Instalar e Rodar

## 1️⃣ Clonar o repositório
```bash
git clone https://github.com/Impacta-Jullya-Nigro/School.git
```

## 2️⃣ Abrir o projeto no Android Studio

- Abra o Android Studio.
- Clique em File > Open.
- Selecione a pasta School que você clonou.
- Aguarde o Android Studio sincronizar o Gradle.

## 3️⃣ Rodar o aplicativo

- Conecte um emulador ou celular físico (com modo desenvolvedor ativado).
- No topo do Android Studio, escolha o dispositivo onde quer rodar.
- Clique no botão ▶ Run para compilar e executar o app.

---

## 📌 Descrição do Aplicativo

O **School** é um aplicativo Android desenvolvido em **Kotlin**, focado no cadastro, edição, listagem e exclusão de usuários.  
Ele realiza comunicação com uma API externa, permitindo operações completas de **CRUD** através de uma interface simples, clara e funcional.

---

# 🖼️ Prints das Telas


<p align="center">
  <img src="https://github.com/Impacta-Jullya-Nigro/School/raw/82648751334dc376e2f67cabae5eab28c465e01d/app/src/main/res/drawable/fotoforms.png" width="250" height="500"/>
  <img src="https://github.com/Impacta-Jullya-Nigro/School/raw/main/app/src/main/res/drawable/fotocadastros.png" width="250" height="500"/>
  <img src="https://raw.githubusercontent.com/Impacta-Jullya-Nigro/School/82648751334dc376e2f67cabae5eab28c465e01d/app/src/main/res/drawable/fotologin.png" width="250" height="500"/>
</p>


---

# 🛠️ Tecnologias Utilizadas

### 📱 **Front-End / Mobile**
- Kotlin
- Android Studio
- XML Layouts  
  - ConstraintLayout  
  - LinearLayout  
  - RecyclerView  

### 🔌 **Comunicação com API e Endpoints**
- Retrofit + GsonConverter
```bash
  https://viacep.com.br/ws/{cep}/json/
```

---

## 🟢 Create — Criar Escola

- O usuário preenche um formulário com os dados da nova escola (nome, endereço, etc.) e clica no botão **Salvar**.
- O Fragmento do formulário coleta os dados e envia para o **ViewModel**.
- O ViewModel repassa os dados para o **Repository**.
- O Repository executa duas ações:
  - Usa o **Room** para inserir a nova escola no banco de dados local.
  - Usa o **Retrofit** para enviar os dados da escola para a API remota (**POST**).


## 🔵 Read — Listar Escolas

- O fragmento de listagem (com **RecyclerView**) observa um **LiveData** ou **StateFlow** do ViewModel.
- O ViewModel solicita a lista de escolas ao **Repository**.
- O Repository busca os dados no **Room**, garantindo acesso rápido e suporte offline.
- Os dados são exibidos na lista pelo **Adapter** (como o `EditarEscolasAdapter`).
  

## 🟡 Update — Editar Escola

- Na lista de escolas, o usuário clica em uma escola para editar.
- O Adapter captura o clique e abre o fragmento de formulário, enviando o **ID** da escola.
- O formulário é preenchido automaticamente com os dados buscados do **Room** via ViewModel/Repository.
- Após editar, o usuário clica em **Salvar**. O fluxo:
  - ViewModel aciona o Repository.
  - Repository:
    - Atualiza os dados da escola no **Room** (**UPDATE**).
    - Envia uma requisição **PUT** ou **PATCH** via Retrofit para atualizar no servidor.


## 🔴 Delete — Excluir Escola

- Na lista, cada item possui um botão ou ícone para excluir.
- Ao clicar, o Adapter informa ao **ViewModel** qual escola deve ser removida.
- O ViewModel solicita que o **Repository** execute a exclusão.
- O Repository:
  - Remove a escola do **Room** (**DELETE**).
  - Envia uma requisição **DELETE** via Retrofit para remover a escola do servidor.

---

# 📋 Funções Implementadas

### ✔ Concluídas
- Cadastro de usuários (POST)
- Listagem de usuários (GET)
- Edição de dados (PUT)
- Exclusão (DELETE)
- Integração com API via Retrofit
- Navegação via fragments
- Interface clara e funcional

### 🔧 Em Desenvolvimento
- Tela de detalhes do usuário  
- Campo de pesquisa  
- Banco local com Room  
- Layout mais moderno  
- Feedbacks animados  


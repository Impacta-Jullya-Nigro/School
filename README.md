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

## 🟢 Create — Cadastrar Condutor

- O usuário preenche o formulário.
- Clica no botão "Salvar"
- A View (Fragment) envia os dados para a ViewModel
- A ViewModel chama o Repository, que salva o novo condutor no banco de dados (Room)


## 🔵 Read — Listar Condutores

- A tela principal de condutores é aberta
- A ViewModel carrega a lista de todos os condutores a partir do Repository
- O Repository busca os dados no banco de dados (Room)
- A lista é exibida em um RecyclerView na tela


## 🟡 Update — Editar Condutor

- O usuário clica em um condutor da lista
- Uma nova tela abre com os campos já preenchidos anteriormente
- O usuário altera os dados e clica em "Salvar"
- A ViewModel é notificada e manda o Repository atualizar as informações do condutor no banco de dados


## 🔴 Delete — Excluir Condutor

- Na lista, o usuário clica no ícone de lixeira ao lado do nome de um condutor
- Um alerta de confirmação aparece: "Deseja mesmo excluir?"
- Se o usuário confirmar, a ViewModel chama o Repository para remover aquele condutor do banco de dados (Room)
- A lista na tela é atualizada automaticamente

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

---

# 🛒 Lista de Mercado

Aplicativo Android desenvolvido com **Kotlin** e **Jetpack Compose** para organização de listas de compras de forma simples, moderna e intuitiva.

O projeto permite adicionar itens ao carrinho, organizar por categorias, controlar quantidades e acompanhar o progresso da compra em tempo real.

---

# 📱 Screenshots

## Tela Principal

<p align="center">
  <img src="images/home.png" width="300"/>
</p>

---

## Tela de Adicionar Item

<p align="center">
  <img src="images/add_item.png" width="300"/>
</p>

---

# ✨ Funcionalidades

- ✅ Adição de itens ao carrinho
- ✅ Organização por categorias
- ✅ Categorias expansíveis/recolhíveis
- ✅ Controle de quantidade dos itens
- ✅ Marcação de itens concluídos
- ✅ Barra de progresso dinâmica
- ✅ Interface moderna utilizando Material Design 3
- ✅ Navegação entre telas
- ✅ Componentização com Compose
- ✅ Estado reativo com Compose State

---

# 🧱 Arquitetura Utilizada

O projeto foi estruturado utilizando:

- Jetpack Compose
- Componentização de UI
- State Hoisting
- Composable Functions
- Data Classes
- Enum Classes
- Activity Result API

---

# 📂 Estrutura do Projeto

```text
📦 com.rai.listademercado
 ┣ 📂 components
 ┃ ┣ 📜 CategoryCard.kt
 ┃ ┣ 📜 Header.kt
 ┃ ┣ 📜 ItemPill.kt
 ┃ ┗ 📜 ProgressCard.kt
 ┣ 📜 MainActivity.kt
 ┣ 📜 AddItemActivity.kt
 ┣ 📜 Category.kt
 ┗ 📜 Item.kt
```

---

# 🧩 Componentes Principais

## `CategoryCard`

Componente responsável por representar uma categoria da lista:

- Frutas
- Carnes
- Padaria
- Limpeza
- etc.

Possui:
- animação de expansão
- ícone dinâmico
- cores personalizadas
- conteúdo interno reutilizável

---

## `ItemPill`

Representa visualmente cada item da lista.

Exemplo:

```text
✔ 2x Banana
```

Funcionalidades:
- marcar/desmarcar item
- exibir quantidade
- alterar aparência quando concluído

---

## `ProgressCard`

Exibe:
- quantidade de itens concluídos
- progresso total do carrinho
- barra de progresso dinâmica

---

# 🛠️ Tecnologias Utilizadas

- Kotlin
- Jetpack Compose
- Material Design 3
- Android Studio
- Navigation
- Activity Result API

---

# 📌 Conceitos Trabalhados

Durante o desenvolvimento foram aplicados conceitos importantes de desenvolvimento Android moderno:

- Estado reativo
- Recomposição
- Lambdas
- Funções de alta ordem
- Componentização
- State Hoisting
- Modifier
- Surface
- AnimatedVisibility
- remember / rememberSaveable
- Navegação entre telas
- UI declarativa

---

# 🚀 Como Executar

## 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/lista-de-mercado.git
```

---

## 2. Abra no Android Studio

Abra o projeto normalmente pelo Android Studio.

---

## 3. Execute

Conecte um dispositivo Android ou utilize um emulador.

---

# 🎯 Objetivo do Projeto

O projeto foi desenvolvido com foco em:

- prática de Jetpack Compose
- componentização
- gerenciamento de estado
- construção de interfaces modernas
- aprendizado de arquitetura declarativa

---

# 👨‍💻 Autor

Desenvolvido por **Raí Rodrigues**.

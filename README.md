# Projeto CryptoTracker - Android Kotlin

**Aluno:** Felipe Gasparetto Ohara Sato  
**RM:** 554315  

---

## Sobre o Projeto

O projeto **CryptoTracker** foi desenvolvido utilizando Kotlin no Android Studio com o objetivo de consultar e exibir a cotação atual do Bitcoin através de uma API pública de criptomoedas.

A aplicação possui uma interface simples onde o usuário pode atualizar os dados clicando em um botão, exibindo:

- Valor atual do Bitcoin
- Data e horário da última atualização

O aplicativo utiliza conceitos importantes do desenvolvimento Android moderno, como:

- Kotlin
- Retrofit
- Consumo de API REST
- Coroutines
- Manipulação de JSON
- Interface Android com Activity

---

# Estrutura do Projeto

## Arquivo: `CoinResponse.kt`

<img width="1268" height="366" alt="image" src="https://github.com/user-attachments/assets/4811d868-9944-495a-952d-40bedb9cde1f" />

### Explicação

A classe `CoinResponse` representa a resposta principal da API.

A classe `CoinTicker` contém as informações da cotação:

- `high` → maior valor do período
- `low` → menor valor
- `last` → último valor negociado
- `buy` → valor de compra
- `sell` → valor de venda
- `date` → data da cotação

---

## Arquivo: `BitcoinApi.kt`

<img width="1309" height="383" alt="image" src="https://github.com/user-attachments/assets/463349eb-9b00-4557-8523-c795a01634d2" />

### Explicação

A interface define a chamada HTTP do tipo GET utilizada para buscar os dados do Bitcoin.

O método `getBitcoinData()` é marcado com `suspend`, permitindo o uso com Coroutines para execução assíncrona.

---

## Arquivo: `ApiFactory.kt`

<img width="1307" height="415" alt="image" src="https://github.com/user-attachments/assets/b6035e62-a7d4-40e9-9eee-74c1dd28c482" />

### Explicação

O Retrofit é configurado com:

- URL base da API
- Conversor Gson para transformar JSON em objetos Kotlin

Depois disso, é criada a implementação da interface `BitcoinApi`.

---

## Arquivo: `MainActivity.kt`

<img width="836" height="630" alt="image" src="https://github.com/user-attachments/assets/b4fa1281-bc0b-4392-bd25-cb0f080cc0ee" />

<img width="798" height="524" alt="image" src="https://github.com/user-attachments/assets/57fd39eb-c63f-4602-a8a8-0acf12571555" />

<img width="780" height="507" alt="image" src="https://github.com/user-attachments/assets/f6db7037-7983-4a37-83bb-0632733ce7a8" />

### Explicação

A `MainActivity` é responsável por:

- Iniciar a interface do app
- Capturar clique do botão
- Fazer chamada na API
- Atualizar valores na tela

---

# Funcionamento do Aplicativo

1. O usuário abre o aplicativo
2. Clica no botão de atualização
3. O app faz chamada para API do Mercado Bitcoin
4. Os dados são convertidos automaticamente pelo Retrofit
5. O valor do Bitcoin e a data aparecem na tela

---

# Tecnologias Utilizadas

- Kotlin
- Android Studio
- Retrofit
- Gson
- Coroutines
- API Mercado Bitcoin

---

# Conclusão

Esse projeto permitiu praticar conceitos importantes do desenvolvimento Android, principalmente o consumo de APIs REST utilizando Retrofit e Coroutines.

Também foi possível entender melhor a manipulação de dados JSON, atualização de interface e tratamento de erros dentro de aplicações mobile utilizando Kotlin.

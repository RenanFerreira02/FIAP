# Omni-Tribo

Aplicativo Android desenvolvido como projeto PBL da disciplina de desenvolvimento mobile da FIAP.

Omni-Tribo é uma plataforma de missões comunitárias que conecta pessoas da mesma região para realizar entregas, coletas, mutirões e pedidos de ajuda, recompensando os participantes com XP e saldo em reais.

---

## Funcionalidades

- **Mapa de missões** — visualização das missões disponíveis próximas ao usuário
- **Lista de missões** — missões disponíveis, em andamento e concluídas com filtros por categoria
- **Detalhes da missão** — rota, recompensas, informações do solicitante e ação de aceitar
- **Criação de missão** — fluxo em 2 etapas: seleção de categoria e preenchimento de dados com busca de endereço por CEP
- **Carteira** — saldo de XP, saldo em reais, tokens e histórico de transações
- **Perfil** — nível, conquistas, sequência de dias e configurações do usuário

---

## Tecnologias

- **Linguagem:** Kotlin
- **UI:** Jetpack Compose + Material Design 3
- **Navegação:** Navigation Compose com `sealed class Destination`
- **Persistência local:** Room Database (SQLite)
- **API externa:** ViaCEP — busca de endereço por CEP via Retrofit 2
- **Arquitetura:** Estado gerenciado diretamente nos composables com `remember { mutableStateOf() }`

---

## Requisitos

- Android Studio Hedgehog ou superior
- SDK mínimo: API 28 (Android 9)
- SDK alvo: API 35 (Android 15)
- Kotlin 2.0.21

---

## Como executar

1. Clone o repositório
2. Abra a pasta `Omni-Tribo` no Android Studio
3. Aguarde a sincronização do Gradle
4. Execute em um emulador ou dispositivo físico com Android 9+

---

## Estrutura do projeto

```
app/src/main/java/br/com/fiap/omni_tribo/
├── components/       # Componentes compartilhados (TopBar, BottomNav, FAB)
├── dao/              # Room DAO e Database
├── model/            # Data classes (Mission, UserProfile, AddressDto)
├── navigation/       # Destination routes e NavigationRoutes
├── repository/       # Repositórios de dados e funções @Composable de listagem
├── screens/          # Telas do aplicativo
├── service/          # Retrofit e interfaces de serviço
├── ui/theme/         # Paleta de cores, tipografia e tema
└── utils/            # Funções utilitárias
```

---

## Desenvolvedores

| Nome            | RM     |
| --------------- | ------ |
| Renan Kaique    | 555833 |
| Matheus Eduardo | 558232 |

**FIAP — 2026**

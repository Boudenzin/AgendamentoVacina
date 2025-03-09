## VacinaFacil

O **VacinaFacil** é um sistema de agendamento de vacinas desenvolvido em Java, utilizando **Swing** para a interface gráfica. Inspirado no sistema de agendamento de vacinas de Recife, o projeto permite cadastrar pacientes, agendar vacinas em datas e horários específicos, e gerenciar informações de vacinação. O sistema é voltado para uso em Unidades Básicas de Saúde (UBS) e foi criado como parte do aprendizado em Java e desenvolvimento de interfaces gráficas.

---

## Funcionalidades

- **Cadastro de Pacientes**: Cadastra pacientes com informações como nome, cartão SUS e idade.
- **Agendamento de Vacinas**: Agenda vacinas para pacientes em datas e horários específicos.
- **Pesquisa de Vacinas**: Permite pesquisar vacinas por data, horário ou listar todas as vacinas de um paciente.
- **Alteração de Agendamentos**: Altera a data ou tipo de vacina agendada.
- **Remoção de Pacientes e Vacinas**: Remove pacientes do sistema ou vacinas específicas de um paciente.
- **Interface Gráfica**: Interface amigável e intuitiva para interação com o usuário.

---

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Swing**: Biblioteca para criação da interface gráfica.
- **Exceções Personalizadas**: Tratamento de erros específicos, como paciente não encontrado ou vacina não cadastrada.
- **Diagramas UML**: Diagramas de classe para documentação e planejamento do sistema.

---

## Como Executar o Projeto

### Pré-requisitos
- Java Development Kit (JDK) instalado.
- Um ambiente de desenvolvimento (IDE como IntelliJ, Eclipse, ou terminal).

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/Boudenzin/VacinaFacil.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd VacinaFacil
   ```

3. Compile o projeto:
   ```bash
   javac src/main/java/br/ufpb/dcx/romildo/vacinacao/gui/AgendamentoVacinaUBSPrimaveraGUI.java
   ```

4. Execute o arquivo Java:
   ```bash
   java br.ufpb.dcx.romildo.vacinacao.gui.AgendamentoVacinaUBSPrimaveraGUI
   ```

5. Siga as instruções na interface gráfica:
   - Use o menu para agendar vacinas, pesquisar agendamentos, alterar dados ou remover pacientes/vacinas.

---


### Detalhes do Código

- **Modelos**:
  - `Paciente`: Representa um paciente com informações como nome, cartão SUS e idade.
  - `Vacina`: Representa uma vacina com tipo, dose, data e horário.
  - `Data` e `Hora`: Classes auxiliares para manipulação de datas e horários.

- **Controladores**:
  - Controladores como `AgendarVacinaController`, `AlterarDataController`, etc., gerenciam as interações entre a interface gráfica e a lógica do sistema.

- **Interface Gráfica**:
  - Utiliza Swing para criar uma interface intuitiva com menus, botões e caixas de diálogo.

---

## Próximos Objetivos

Futuras metas a serem alcançadas:

1. **Persistência de Dados**:
   - Implementar um banco de dados (SQLite, MySQL) para armazenar pacientes e agendamentos de forma permanente.

2. **Validação de Entradas**:
   - Adicionar validações para garantir que datas, horários e informações de pacientes estejam corretos.

3. **Relatórios**:
   - Gerar relatórios em PDF ou Excel com informações sobre vacinações agendadas.

4. **Integração com APIs**:
   - Integrar com APIs de saúde para obter informações atualizadas sobre vacinas e campanhas.

5. **Testes Automatizados**:
   - Implementar testes unitários e de integração para garantir a qualidade do código.

6. **Deploy**:
   - Publicar o sistema em um servidor ou plataforma na nuvem para acesso remoto.

7. **Interface Mais Moderna**:
   - Migrar para uma interface gráfica mais moderna usando JavaFX.

---

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

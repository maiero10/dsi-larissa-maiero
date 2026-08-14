# Desenvolvimento de Software I
Aulas de Desenvolvimento de Software I com o professor João Siles utilizando Java.

### Configuração do Java no computador
1. Faça o download do **JDK (Java Development Kit)** pelo site da Oracle ou distribuições OpenJDK como Adoptium ou Eclipse Temurin. Se for **Windows**, baixe o **x64**;

2. Execute o arquivo, clique em **"Next"** até aparecer uma telinha com 4 opções onde as duas últimas estão com um **X** em vermelho, clique nelas e mude para a primeira opção que aparecer "will be installed on local hard drive", depois continue avançando até concluir a instalação;

3. Para a configuração da variável **JAVA_HOME**, pesquise no Windows "Editar as variáveis de ambiente do sistema";

4. Em **Variáveis do Sistema**, defina o nome como JAVA_HOME ao clicar em **"Novo"**, usando o caminho da pasta JDK;

5. Depois irá configurar o **Path**, selecionando essa opção com dois cliques e adicionando `%JAVA_HOME%\bin`;

6. Por fim, verifique pelo **CMD (Prompt de Comando)** se foi instalado o java, use o comando `java -version` para verificar a **JVM (Java Virtual Machine) / JRE (Java Runtime Environment)**, e `javac -version` para verificar o compilador do JDK.

### Regras básicas do Java
- Ele é **Case Sensitive**, diferencia maiúsculas de minúsculas;

- O nome do arquivo deve ser **igual** ao nome que consta no `public class`;

- Uso obrigatório de **ponto e vírgula** (`;`) no final de toda instrução;

- Uso de **chaves** (`{}`) para determinar blocos de código;

- O ponto de entrada para toda aplicação Java é o **main**;

### Como funciona o Java?
O Java é uma linguagem de programação presente em diversos lugares, como nos celulares, mas como de fato ele funciona? Ele usa um compilador para rodar seu **código-fonte** (`.java`) por um formato que faz a intermediação chamado **bytecode** que será executado pela JVM em todos os sistemas operacionais para garantir a portabilidade do Java

1. O JDK vai oferecer um kit completo para os desenvolvedores escreverem e compilarem o código java;

2. Esse código é transformado (compilado) para bytecode pelo **javac**;

3. O JRE vai fornecer as bibliotecas necessárias pra JVM rodar corretamente;

4. A JVM vai rodar o bytecode traduzindo-o para a linguagem da máquina do computador; 

# Oque é Spring Boot
  Spring Boot é um framework do java que ajuda o desenvolvedor a criar aplicações de forma rápida, simples e padronizada.

## Como configurar o Spring Boot  de 3 maneiras
###  1. Spring initializr
![enter image description here](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTP4dWwa6k_mjjvrfwSbB15cR-OCOpIdVjlHsu_yKk4Ww&s=10)

- Abra o site https://start.spring.io/
- Escolha as opções necessárias, e dependencias. (Prof recomenda usar Spring Web e Spring Boot Dev Tools)
- E crie o projeto
- Ele vai gerar um arquivo zip totalmente formatado

### 2. Vscode  
![enter image description here](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTp1XBXcsv2zHTIrC5DiGufOC6TM8YrU61nze6xwHypGw&s=10)

- Baixe o Vscode pelo link: https://code.visualstudio.com/
- Depois é só apertar ctrl + shift + P
- Busque e selecione **Spring Initializr: Create a Maven Project**
- Então é só ir configurando o seu projeto
- Ele criara uma pasta totalmente formatada e pronta para uso
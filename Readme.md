# Projeto de Controle Financeiro

Este � um projeto de controle financeiro desenvolvido em Java utilizando a plataforma JavaServer Faces (JSF) e o framework RichFaces. O projeto permite cadastrar e gerenciar despesas, empenhos e pagamentos, al�m de realizar consultas baseadas em filtros.

## Pr�-requisitos

- JDK (Java Development Kit) 8 ou superior instalado em sua m�quina.
- Apache Maven instalado em sua m�quina.
- Servidor de Aplica��o compat�vel com Java EE (ex: Apache Tomcat, WildFly, GlassFish).

## Como Executar

1. Clone este reposit�rio para a sua m�quina local:

```bash
git clone https://github.com/mdsjjorge/Controle-Financeiro-RichFaces-JSF.git
```

Navegue para o diret�rio raiz do projeto:

```bash
cd Controle-Financeiro-RichFaces-JSF
```
Compile o projeto utilizando o Maven:

```bash
mvn clean install
```
Implante o arquivo WAR gerado no passo anterior em um servidor de aplica��o compat�vel.

Acesse a aplica��o no navegador atrav�s da URL:

```bash
http://localhost:8080/Controle-Financeiro-RichFaces-JSF/
```
Funcionalidades <br>
Consulta de Despesas, Empenhos e Pagamentos utilizando filtros espec�ficos.


** C�digos SQL para cria��o do banco no PostgreSQL **

Cria��o do banco de dados

``` 
CREATE DATABASE controle_financeiro; 
```

Cria��o da tabela 'Despesa':

``` 
 CREATE TABLE despesa (
    id SERIAL PRIMARY KEY,
    numero_protocolo VARCHAR(50) UNIQUE NOT NULL,
    tipo_despesa VARCHAR(100) NOT NULL,
    data_protocolo DATE NOT NULL,
    data_vencimento DATE NOT NULL,
    credor VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor_despesa NUMERIC(10, 2) NOT NULL,
    status_despesa VARCHAR(50) NOT NULL
);
```
Cria��o da tabela 'Empenho':

``` 
 CREATE TABLE empenho (
    id SERIAL PRIMARY KEY,
    id_despesa INT REFERENCES despesa(id) ON DELETE CASCADE,
    ano_empenho INT NOT NULL,
    numero_empenho VARCHAR(50) NOT NULL,
    data_empenho DATE NOT NULL,
    valor_empenho NUMERIC(10, 2) NOT NULL,
    observacao VARCHAR(255),
    UNIQUE (ano_empenho, numero_empenho)
);
```
Cria��o da tabela 'Pagamento':

``` sql
 CREATE TABLE pagamento (
    id SERIAL PRIMARY KEY,
    id_empenho INT REFERENCES empenho(id) ON DELETE CASCADE,
    ano_pagamento INT NOT NULL,
    numero_pagamento VARCHAR(50) NOT NULL,
    data_pagamento DATE NOT NULL,
    valor_pagamento NUMERIC(10, 2) NOT NULL,
    observacao VARCHAR(255),
    UNIQUE (ano_pagamento, numero_pagamento)
);
```

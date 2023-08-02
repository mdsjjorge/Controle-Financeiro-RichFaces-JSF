

** Códigos SQL para criação do banco no PostgreSQL **

Criação do banco de dados

``` 
CREATE DATABASE controle_financeiro; 
```

Criação da tabela 'Despesa':

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
Criação da tabela 'Empenho':

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
Criação da tabela 'Pagamento':

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

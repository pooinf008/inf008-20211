CREATE TABLE CONTA (
   codigo VARCHAR(50) NOT NULL,
   nome VARCHAR(20) NOT NULL,
   saldo DOUBLE,
   tipo int
   PRIMARY KEY (codigo) 
);

CREATE TABLE LANCAMENTO (
   data DATE NOT NULL,
   descricao VARCHAR(250) NOT NULL,
   valor DOUBLE,
   credito VARCHAR(50) NOT NULL,
   debito VARCHAR(50) NOT NULL,
);
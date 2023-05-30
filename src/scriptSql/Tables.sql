
--Script Tabelas Banco de Dados


create database mercearia;

use mercearia;

create table tb_categoria(
   codigo int primary key identity(1,1), 
   nome varchar (50) not null,
   descricao varchar (100)
);

create table tb_subcategoria(
   codigo int primary key identity(1,1),
   cod_categoria int not null references tb_categoria,
   nome varchar (50) not null,
   descricao varchar (100)
);

CREATE TABLE tb_fornecedor (
	cnpj varchar(18) primary key,
	razao_social varchar(100),
	nome varchar(100),
	email varchar(50),
	endereco varchar(100),
	numero int,
	bairro varchar(50),
	cidade varchar(50),
	uf varchar(2),
	telefone varchar(15),
	celular varchar(15),
	cep varchar(10),
	complemento varchar(50),
	inscricao_estadual varchar(15),
);

create table tb_produto(
   codigo_barras varchar (13) primary key,
   descricao varchar (255) not null,
   marca varchar (30)not null,
   cod_subcategoria integer not null references tb_subcategoria,
   unidade_medida varchar(10) not null,
   quantidade decimal(10,3) not null,
   data_fabricacao datetime not null,
   data_validade datetime not null,
   lote varchar(30) not null,
   ipi decimal(6,3),
   icms decimal(6,3),
   margem_lucro decimal(6,3) not null,
   preco_custo money not null,
   preco_final money not null
);

create table tb_cliente(
   nome varchar (70) not null,
   email varchar (50) not null,
   cpf varchar (14) primary key,
   rg varchar (50) not null,
   endereco varchar (100) not null,
   telefone varchar (20) not null,
   celular varchar (20) not null,
   numero int not null,
   cep varchar (10),
   data_nascimento datetime  not null,
   bairro varchar (50) not null,
   cidade varchar (50) not null,
   uf varchar (2) not null,
   complemento varchar (30),
   limite money not null
);

create table tb_funcionario(
   nome varchar (70) not null,
   email varchar (50) not null,
   cpf char (14) primary key,
   rg varchar (12) not null,
   endereco varchar (60) not null,
   telefone varchar (20) not null,
   celular varchar (20) not null,
   numero int not null,
   cep varchar (10) not null,
   data_nascimento datetime not null,
   bairro varchar (50) not null,
   cidade varchar (50) not null,
   uf varchar (2) not null,
   complemento varchar (30),
   limite money not null,
   senha varchar(30) not null,
   cargo varchar(30) not null,
   nivel_acesso varchar (20) not null,
   pis_pasep varchar (11) not null,
   salario decimal not null,
   carteira_trabalho varchar (13) not null,
   estado_civil varchar (15) not null,
   jornada_trabalho varchar (40) not null,
   admissao datetime not null,
   demissao datetime,
   ativo varchar(7) not null
);

create table tb_forma_pagamento( 
	codigo varchar(20) primary key ,
	dinheiro money,
	cartao_credito money,
	cartao_debito money, 
	vale_alimentacao money,
	vale_refeicao money,
	pix money,
	troco money,
	total_compra money
);

create table tb_abertura_fechamento (
  codigo INT PRIMARY KEY identity,
  data_abertura DATETIME,
  data_fechamento DATETIME,
  funcionario char(14) references tb_funcionario,
  troco_inicial money,
  caixa_situacao bit
);

create table tb_venda(
  codigo varchar(20) primary key,
  cod_cliente varchar(14) references tb_cliente,
  cod_funcionario char(14) references tb_funcionario not null,
  cod_forma_pagamento varchar(20) references tb_forma_pagamento not null , 
  data_venda datetime not null,
  valor_venda money
);

  create table tb_item_venda(
   codigo int primary key identity(1,1),
   codigo_produto varchar (13) references tb_produto,
   codigo_venda varchar(20) not null references tb_venda,
   quantidade_produto decimal(10,3) not null,
   preco_unitario money not null,
   valor_total money not null
);

create table tb_produto_fornecedor(
codigo int primary key identity,
cod_produto varchar (13) references tb_produto,
cod_fornecedor varchar(18) references tb_fornecedor,
data_entrada datetime,
quantidade decimal(10,3),
preco_unitario money,
subtotal money
);
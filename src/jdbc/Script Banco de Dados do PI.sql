create database mercearia;

use mercearia;

create table tb_categorias(
   codigo int primary key identity(1,1), 
   nome varchar (50) not null,
   descricao varchar (100)
);

insert into tb_categorias values ('Alimentos Básicos','Alimentos Básicos de alimentação');
insert into tb_categorias values ('Bazar e Utilidades ','');
insert into tb_categorias values ('Bebidas ','');
insert into tb_categorias values ('Bebidas Alcoólicas ','');
insert into tb_categorias values ('Biscoitos e Salgadinhos ','');
insert into tb_categorias values ('Carnes Secas, Salgadas ou Defumadas ','');
insert into tb_categorias values ('Congelados e Resfriados ','');
insert into tb_categorias values ('Doces e Sobremesas ','');
insert into tb_categorias values ('Étnicos ','');
insert into tb_categorias values ('Feira','');
insert into tb_categorias values ('Frios e Laticínios ','');
insert into tb_categorias values ('Higiene e Cuidados Pessoais ','');
insert into tb_categorias values ('Leites e Iogurtes ','');
insert into tb_categorias values ('Limpeza','');
insert into tb_categorias values ('Matinais','');


create table tb_subcategorias(
   codigo int primary key identity(1,1),
   cod_categoria int not null references tb_categorias,
   nome varchar (50) not null,
   descricao varchar (100)
);



create table tb_produtos(
   codigo int primary key identity(1,1),
   descricao varchar (255) not null,
   codigo_barras varchar (13),
   marca varchar (30),
   cod_subcategoria integer not null references tb_subcategorias,
   unidade_medida varchar(2),
   quantidade int,
   data_fabricacao datetime,
   data_validade datetime,
   lote varchar(30),
   ipi decimal,
   icms decimal,
   margem_lucro decimal,
   preco_custo decimal,
   preco_final decimal
);

create table tb_clientes
(
   nome varchar (70),
   email varchar (50),
   cpf varchar (14) primary key,
   rg varchar (50),
   endereco varchar (100),
   telefone varchar (20),
   celular varchar (20),
   numero int,
   cep varchar (10),
   dataNascimento varchar (50),
   bairro varchar (50),
   cidade varchar (50),
   uf varchar (2),
   complemento varchar (30),
   limite decimal
);

create table tb_funcionarios(
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
   limite decimal not null,
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


create table tb_carrinho(
	codigo_carrinho int primary key,
	codigo_produto int not null references tb_produtos,
	quantidade_produto int not null
);


create table tb_pedido(
	nf_pedido varchar(15) primary key,
	cod_cliente varchar(14) references tb_clientes,
	cod_funcionario char(14) references tb_funcionarios,
   cod_carrinho int references tb_carrinho,
	forma_pagamento varchar(20),
	data_venda datetime,
	valor_venda decimal
);

create table tb_abertura_fechamento(
   cod_abertura_fechamento int primary key,
   cod_funcionario int references tb_funcionarios not null,
   data_hora_abertura datetime not null,
   data_hora_fechamento datetime,
   cod_vendas int references tb_carrinho,
   troco_inicial money,
   venda_dinheiro money,
   venda_cartao_credito money,
   venda_cartao_debito money,
   venda_cartao_alimentacao money,
   venda_cartao_refeicao money,
   venda_prazo money,
   sangria money,
   total_venda money
);











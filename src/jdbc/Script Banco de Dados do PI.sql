
--Script Banco de Dados


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
	inscricao_estadual varchar(20),
);

create table tb_produto(
   codigo_barras varchar (13) primary key,
   descricao varchar (255) not null,
   marca varchar (30)not null,
   cod_subcategoria integer not null references tb_subcategoria,
   unidade_medida varchar(5) not null,
   quantidade decimal not null,
   data_fabricacao datetime not null,
   data_validade datetime not null,
   lote varchar(30) not null,
   ipi decimal,
   icms decimal,
   margem_lucro decimal not null,
   preco_custo decimal not null,
   preco_final decimal not null
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
   limite decimal not null
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
)


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

/*
create table tb_item_venda(
   codigo int primary key identity,
   codigo_produto int not null references tb_produto,
   codigo_pedido varchar(20) not null references tb_pedido,
   quantidade_produto decimal(6,3) not null
);*/

  create table tb_item_venda(
   codigo int primary key identity(1,1),
   codigo_produto varchar (13) references tb_produto,
   codigo_venda varchar(20) not null references tb_venda,
   quantidade_produto decimal(6,3) not null,
   preco_unitario money not null,
   valor_total money not null
);




create table tb_produto_fornecedor(
codigo int primary key identity,
cod_produto varchar (13),
cod_fornecedor char(20),
data_entrada datetime,
quantidade decimal(6,3),
preco_unitario money,
subtotal money
)


----Scripts de inserts
insert into tb_categoria values ('Alimentos Básicos','Alimentos Básicos de alimentação');
insert into tb_categoria values ('Congelados e Resfriados ','frutas, legumes, carne, aves, peixes e pratos prontos, refeições congeladas');
insert into tb_categoria values ('Bebidas','Bebidas Não Alcoólicas');
insert into tb_categoria values ('Bebidas','Bebidas Alcoólicas');


insert into tb_subcategoria (cod_categoria, nome, descricao) values (1,'Grãos','diversos');
insert into tb_subcategoria (cod_categoria, nome, descricao) values (2,'Hambúrguere','diversos');
insert into tb_subcategoria (cod_categoria, nome, descricao) values (3,'Sucos','Caixinha');
insert into tb_subcategoria (cod_categoria, nome, descricao) values (1,'Arroz','diversos');
insert into tb_subcategoria (cod_categoria, nome) values (4,'Cerveja');
insert into tb_subcategoria (cod_categoria, nome, descricao) values (3,'Refrigerante','Pet');

insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Feijão carioca', '7890123456789', 'Camil', 1, 'pct', 10.0, '2022-01-01', '2023-01-01', '12345', 5.0, 10.0, 0.5, 3.0, 4.5);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final)  values  ('Arroz parboilizado', '1234567890123', 'Tio João', 4, 'pct', 5.0, '2022-01-01', '2023-01-01', '54321', 3.0, 12.0, 0.3, 2.0, 2.6);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Lentilha', '4567890123456', 'Vapza', 1, 'pct', 200.0, '2022-01-01', '2023-01-01', '67890', 0.0, 10.0, 0.4, 1.0, 1.8);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Refrigerante Coca-Cola', '7894900011517', 'Coca-Cola', 6, 'LT', 2, '2022-01-01', '2023-01-01', '123456', 10, 18, 20, 2.50, 3.00);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Cerveja Heineken', '7894900012613', 'Heineken', 5, 'UN', 1, '2022-01-01', '2023-01-01', '654321', 5, 18, 30, 3.00, 5.00);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Suco de Laranja Del Valle', '7894900011678', 'Del Valle', 3, 'ML', 200, '2022-01-01', '2023-01-01', 'ABC123', 0, 18, 40, 1.50, 2.50);


insert into tb_cliente values ('João da Silva', 'joao.silva@example.com', '111.222.333-44', '22.333.444-5', 'Rua das Flores, 123', '(19) 5555-5555', '(19) 99999-9999', 456, '13338-000', '1990-01-01', 'Jardim São Conrado', 'Indaiatuba', 'SP', 'Apto 4', 2000);
insert into tb_cliente values ('Maria da Silva', 'maria.silva@example.com', '111.222.333-55', '22.333.444-6', 'Rua das Palmeiras, 321', '(19) 5555-5555', '(19) 99999-9999', 654, '13338-000', '1995-05-10', 'Jardim São Francisco', 'Indaiatuba', 'SP', '', 1500);
insert into tb_cliente values ('Pedro Souza', 'pedro.souza@example.com', '111.222.333-66', '22.333.444-7', 'Avenida dos Bandeirantes, 456', '(19) 5555-5555', '(19) 99999-9999', 789, '13338-000', '1995-05-10', 'Centro', 'Indaiatuba', 'SP', 'Fundos', 5000);
insert into tb_cliente values  ('Carla Santos', 'carla.santos@example.com', '111.222.333-77', '22.333.444-8', 'Rua dos Girassóis, 987', '(19) 5555-5555', '(19) 99999-9999', 123, '13338-000', '1995-05-10', 'Jardim Europa', 'Indaiatuba', 'SP', '', 3500);
insert into tb_cliente values ('Ana Paula Rocha', 'ana.rocha@example.com', '111.222.333-88', '22.333.444-9', 'Rua das Margaridas, 654', '(19) 5555-5555', '(19) 99999-9999', 321, '13338-000', '1995-05-10', 'Jardim América', 'Indaiatuba', 'SP', 'Casa 2', 1000);


insert into tb_funcionario values  ('Fernando Silva', 'fernando.silva@gmail.com', '123.456.789-01', '12.345.678-9', 'Rua Padre José de Anchieta, 300', '(19) 99999-8888', '(19) 98888-7777', 50, '13330-000', '1987-10-01', 'Vila Avaí', 'Indaiatuba', 'SP', 'Apto 301', 3000, '1234', 'Gerente', 'Gerente', '12345678900', 5500, '111222333444', 'Solteiro', '44h semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values ('Maria Rodrigues', 'maria.rodrigues@gmail.com', '234.567.890-12', '23.456.789-0', 'Rua Campos Salles', '(19) 99999-7777', '(19) 98888-6666', 150, '13330-100', '1987-10-01', 'Centro', 'Indaiatuba', 'SP', 'Casa', 2500, '123456', 'Repositor', 'Estoquista', '23456789012', 3500, '2223334445', 'Casado', '40h semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Ana Clara Oliveira', 'anaclara.oliveira@gmail.com', '345.678.901-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, '147258369', 'Caixa', 'Caixa', '3456789012', 3000, '3456789', 'Casada', '36 horas semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Giovanni', 'giovanni', '345.678.901-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, '147258369', 'Caixa', 'Caixa', '3456789012', 3000, '1234', 'Casada', '36 horas semanais', '2022-01-01', NULL, 'Sim');



insert into tb_funcionario values  ('Giovanni', 'caixa', '345.678.941-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, 'caixa', 'Caixa', 'Caixa', '3456789012', 3000, 'caixa', 'Casada', '36 horas semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Giovanni', 'estoquista', '345.878.901-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, 'estoquista', 'Caixa', 'Estoquista', '3456789012', 3000, 'estoquista', 'Casada', '36 horas semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Giovanni', 'gerente', '345.978.901-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, 'gerente', 'Caixa', 'Gerente', '3456789012', 3000, 'gerente', 'Casada', '36 horas semanais', '2022-01-01', NULL, 'Sim');





insert into tb_pedido (codigo, cod_cliente, cod_funcionario, forma_pagamento, data_venda, valor_venda)
values ('P0001', '111.222.333-44', '345.678.901-23', 'Cartão de crédito', '2023-05-01 10:30:00', 120.00);
insert into tb_pedido (codigo, cod_cliente, cod_funcionario, forma_pagamento, data_venda, valor_venda)
values ('P0002', '111.222.333-44', '345.678.901-23', 'Boleto bancário', '2023-05-02 16:45:00', 80.00);
insert into tb_pedido (codigo, cod_cliente, cod_funcionario, forma_pagamento, data_venda, valor_venda)
values ('P0003', '111.222.333-88', '345.678.901-23', 'Dinheiro', '2023-05-03 09:00:00', 50.00);



insert into tb_carrinho (codigo_carrinho, codigo_produto, codigo_pedido,quantidade_produto) values (1, 1, 'P0001',4 );
insert into tb_carrinho (codigo_carrinho, codigo_produto, codigo_pedido,quantidade_produto) values (4,3,'P0001',2 );
insert into tb_carrinho (codigo_carrinho, codigo_produto, codigo_pedido,quantidade_produto) values (2,1,'P0002',10 );
insert into tb_carrinho (codigo_carrinho, codigo_produto, codigo_pedido,quantidade_produto) values (3,4,'P0003',6 );


INSERT INTO tb_fornecedor (cnpj, razao_social, nome, email, endereco, numero, bairro, cidade, uf, telefone, celular, cep, complemento, inscricao_estadual)
VALUES ('12345678901234', 'Empresa A', 'João', 'joao@empresa.com', 'Rua A', 100, 'Centro', 'São Paulo', 'SP', '1111111111', '2222222222', '12345-000', 'Sala 1', 'IE123456');
INSERT INTO tb_fornecedor (cnpj, razao_social, nome, email, endereco, numero, bairro, cidade, uf, telefone, celular, cep, complemento, inscricao_estadual)
VALUES ('98765432109876', 'Empresa B', 'Maria', 'maria@empresa.com', 'Rua B', 200, 'Vila Nova', 'Rio de Janeiro', 'RJ', '3333333333', '4444444444', '54321-000', 'Sala 2', 'IE654321');
INSERT INTO tb_fornecedor (cnpj, razao_social, nome, email, endereco, numero, bairro, cidade, uf, telefone, celular, cep, complemento, inscricao_estadual)
VALUES ('12.345.678/0001-01', 'Fornecedor A', 'João da Silva', 'joao@fornecedora.com', 'Rua dos Fornecedores', 100, 'Centro', 'São Paulo', 'SP', '(11) 1234-5678', '(11) 98765-4321', '01234-567', 'Sala 101', '123456789012345');
INSERT INTO tb_fornecedor (cnpj, razao_social, nome, email, endereco, numero, bairro, cidade, uf, telefone, celular, cep, complemento, inscricao_estadual)
VALUES ('23.456.789/0001-02', 'Fornecedor B', 'Maria Oliveira', 'maria@fornecedora.com', 'Rua das Indústrias', 200, 'Industrial', 'Belo Horizonte', 'MG', '(31) 2345-6789', '(31) 87654-3210', '23456-789', 'predio', '234567890123456');
INSERT INTO tb_fornecedor (cnpj, razao_social, nome, email, endereco, numero, bairro, cidade, uf, telefone, celular, cep, complemento, inscricao_estadual)
VALUES ('34.567.890/0001-03', 'Fornecedor C', 'Pedro Almeida', 'pedro@fornecedora.com', 'Avenida dos Comerciantes', 300, 'Comercial', 'Rio de Janeiro', 'RJ', '(21) 3456-7890', '(21) 76543-2109', '34567-890', 'Galpao', '345678901234567');
INSERT INTO tb_fornecedor (cnpj, razao_social, nome, email, endereco, numero, bairro, cidade, uf, telefone, celular, cep, complemento, inscricao_estadual)
VALUES ('45.678.901/0001-04', 'Fornecedor D', 'Ana Costa', 'ana@fornecedora.com', 'Praça das Empresas', 400, 'Empresarial', 'Recife', 'PE', '(81) 4567-8901', '(81) 65432-1098', '45678-901', 'Sala 202', '345678901234565');
INSERT INTO tb_fornecedor (cnpj, razao_social, nome, email, endereco, numero, bairro, cidade, uf, telefone, celular, cep, complemento, inscricao_estadual)
VALUES ('56.789.012/0001-05', 'Fornecedor E', 'Ricardo Santos', 'ricardo@fornecedora.com', 'Alameda das Lojas', 500, 'Shopping', 'Curitiba', 'PR', '(41) 5678-9012', '(41) 98765-4321', '56789-012', 'Loja 10', '345678901234525');







--tesdte consulta produto
select p.codigo, p.descricao, p.codigo_barras, p.marca, sc.nome as 'subcategoria', p.unidade_medida, p.quantidade, p.data_fabricacao, p.data_validade, p.lote, p.ipi, p.icms, p.margem_lucro, p.preco_custo, p.preco_final from tb_produto as p inner join tb_subcategoria as sc on (p.cod_subcategoria = sc.codigo);



SELECT * FROM tb_abertura_fechamento;


insert into tb_abertura_fechamento (dataAbertura, funcionario, trocoInicial) values('2023/05/12 08:05:50','123.456.789-01',200);

select max(codigo) codigo from tb_abertura_fechamento
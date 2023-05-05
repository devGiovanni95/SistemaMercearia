
Script Banco de Dados


create database mercearia8;

use mercearia8;

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

create table tb_produto(
   codigo int primary key identity(1,1),
   descricao varchar (255) not null,
   codigo_barras varchar (13) not null,
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

create table tb_pedido(
  codigo varchar(15) primary key,
  cod_cliente varchar(14) references tb_cliente,
  cod_funcionario char(14) references tb_funcionario not null,
  forma_pagamento varchar(20) not null, 
  data_venda datetime not null,
  valor_venda decimal
);

create table tb_carrinho(
   codigo_carrinho int primary key,
   codigo_produto int not null references tb_produto,
   codigo_pedido varchar(15) not null references tb_pedido,
   quantidade_produto decimal not null
);


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


insert into tb_funcionario values  ('Fernando Silva', 'fernando.silva@gmail.com', '123.456.789-01', '12.345.678-9', 'Rua Padre José de Anchieta, 300', '(19) 99999-8888', '(19) 98888-7777', 50, '13330-000', '1987-10-01', 'Vila Avaí', 'Indaiatuba', 'SP', 'Apto 301', 3000, '1234', 'Gerente', 'Gerente geral', '12345678900', 5500, '111222333444', 'Solteiro', '44h semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values ('Maria Rodrigues', 'maria.rodrigues@gmail.com', '234.567.890-12', '23.456.789-0', 'Rua Campos Salles', '(19) 99999-7777', '(19) 98888-6666', 150, '13330-100', '1987-10-01', 'Centro', 'Indaiatuba', 'SP', 'Casa', 2500, '123456', 'Repositor', 'Estoquista', '23456789012', 3500, '2223334445', 'Casado', '40h semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Ana Clara Oliveira', 'anaclara.oliveira@gmail.com', '345.678.901-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, '147258369', 'Caixa', 'Caixa', '3456789012', 3000, '3456789', 'Casada', '36 horas semanais', '2022-01-01', NULL, 'Sim');



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

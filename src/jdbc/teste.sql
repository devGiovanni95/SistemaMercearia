create database mercearia;

use mercearia;

create table tb_categoria(
   codigo   identity(11) 
   nome  (50) 
   descricao  (100)
);

insert o tb_categorias values ('Alimentos Básicos''Alimentos Básicos de alimentação');
insert o tb_categorias values ('Bazar e Utilidades ''');
insert o tb_categorias values ('Bebidas ''');
insert o tb_categorias values ('Bebidas Alcoólicas ''');
insert o tb_categorias values ('Biscoitos e Salgadinhos ''');
insert o tb_categorias values ('Carnes Secas Salgadas ou Defumadas ''');
insert o tb_categorias values ('Congelados e Resfriados ''');
insert o tb_categorias values ('Doces e Sobremesas ''');
insert o tb_categorias values ('Étnicos ''');
insert o tb_categorias values ('Feira''');
insert o tb_categorias values ('Frios e Laticínios ''');
insert o tb_categorias values ('Higiene e Cuidados Pessoais ''');
insert o tb_categorias values ('Leites e Iogurtes ''');
insert o tb_categorias values ('Limpeza''');
insert o tb_categorias values ('Matinais''');


create table tb_subcategoria(
   codigo
   cod_categoria   
   nome  
   descricao  
);



create table tb_produto(
   codigo   
   descricao  
   codigo_barras
   marca 
   cod_subcategoria 
   unidade_medida
   quantidade 
   data_fabricacao 
   data_validade 
   lote
   ipi 
   icms 
   margem_lucro 
   preco_custo 
   preco_final 
);

create table tb_cliente
(
   nome  
   email  
   cpf  
   rg 
   endereco 
   telefone 
   celular  
   numero 
   cep  
   dataNascimento 
   bairro 
   cidade  
   uf 
   complemento  
   limite 
);

create table tb_funcionario(
   nome   
   email  
   cpf 
   rg 
   endereco  
   telefone  
   celular  
   numero  
   cep  
   data_nascimento  
   bairro 
   cidade 
   uf  
   complemento 
   limite  
   senha  
   cargo 
   nivel_acesso  
   pis_pasep
   salario  
   carteira_trabalho  
   estado_civil  
   jornada_trabalho  
   admissao  
   demissao 
   ativo
);


create table tb_carrinho(
	codigo_carrinho  
	codigo_produto  
	quantidade_produto  
);


create table tb_pedido(
	nf_pedido 
	cod_cliente 
	cod_funcionario
   cod_carrinho  
	forma_pagamento 
	data_venda 
	valor_venda 
);

create table tb_abertura_fechamento(
   cod_abertura_fechamento  
   cod_funcionario  
   data_hora_abertura  
   data_hora_fechamento 
   cod_vendas  
   troco_inicial 
   venda_dinheiro 
   venda_cartao_credito 
   venda_cartao_debito 
   venda_cartao_alimentacao 
   venda_cartao_refeicao 
   venda_prazo 
   sangria 
   total_venda 
);



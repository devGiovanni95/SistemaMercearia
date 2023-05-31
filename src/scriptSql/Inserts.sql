----Scripts de inserts


insert into tb_categoria values ('Alimentos Básicos','Alimentos Básicos de alimentação');
insert into tb_categoria values ('Congelados e Resfriados ','frutas, legumes, carne, aves, peixes e pratos prontos, refeições congeladas');
insert into tb_categoria values ('Bebidas','Bebidas Não Alcoólicas');
insert into tb_categoria values ('Bebidas','Bebidas Alcoólicas');
Insert into tb_categoria values ('Laticínios','Leite, queijo, iogurte');
Insert into tb_categoria values ('Carnes','Carne bovina, carne suína, carne de frango');
Insert into tb_categoria values ('Pães e Cereais','Pão, cereais matinais, massas');
Insert into tb_categoria values ('Frutas','Maçãs, bananas, laranjas');
Insert into tb_categoria values ('Legumes','Tomates, cenouras, cebolas');
Insert into tb_categoria values ('Bebidas','Refrigerantes, sucos de frutas');
Insert into tb_categoria values ('Limpeza','Detergente, sabão em pó, desinfetante');
Insert into tb_categoria values ('Higiene Pessoal','Sabonete, shampoo, pasta de dentes');
Insert into tb_categoria values ('Snacks','Bolachas, batatas fritas, chocolates');
Insert into tb_categoria values ('Bebidas','Cerveja, vinho, destilados');
Insert into tb_categoria values ('Enlatados','Feijão, milho, ervilha em conserva');
Insert into tb_categoria values ('Condimentos','Sal, pimenta, azeite');
Insert into tb_categoria values ('Padaria','Bolos, tortas, pães especiais');
Insert into tb_categoria values ('Congelados','Pizza, lasanha, sorvete');
Insert into tb_categoria values ('Doces','Bombons, balas, chicletes');
Insert into tb_categoria values ('Cuidados com o Bebê','Fraldas, pomadas, mamadeiras');
Insert into tb_categoria values ('Produtos de Limpeza','Limpadores multiuso, amaciante de roupas');
Insert into tb_categoria values ('Cereais Matinais','Cereais em flocos, granola');
Insert into tb_categoria values ('Molhos','Molho de tomate, molho de soja');
Insert into tb_categoria values ('Utensílios de Cozinha','Panelas, talheres, pratos');

--verificar criacao no banco
insert into tb_subcategoria (cod_categoria, nome, descricao) values (1,'Grãos','diversos');
insert into tb_subcategoria (cod_categoria, nome, descricao) values (2,'Hambúrguere','diversos');
insert into tb_subcategoria (cod_categoria, nome, descricao) values (3,'Sucos','Caixinha');
insert into tb_subcategoria (cod_categoria, nome) values (4,'Cerveja');
insert into tb_subcategoria (cod_categoria, nome, descricao) values (3,'Refrigerante','Pet');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Arroz', 'Diversos tipos de arroz');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Feijão', 'Diversos tipos de feijão');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Milho', 'Grãos de milho');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Trigo', 'Grãos de trigo');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (22, 'Aveia', 'Grãos de aveia');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (22, 'Grão de Bico', 'Grãos de grão de bico');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Lentilha', 'Grãos de lentilha');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (22, 'Cevada', 'Grãos de cevada');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Quinoa', 'Grãos de quinoa');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (22, 'Centeio', 'Grãos de centeio');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Sorgo', 'Grãos de sorgo');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Amêndoas', 'Grãos de amêndoas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Castanhas', 'Grãos de castanhas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Pistache', 'Grãos de pistache');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Macadâmia', 'Grãos de macadâmia');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Ervilhas', 'Grãos de ervilhas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Arroz Integral', 'Diversos tipos de arroz integral');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Feijão Preto', 'Grãos de feijão preto');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Arroz Branco', 'Diversos tipos de arroz branco');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Soja', 'Grãos de soja');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (1, 'Girassol', 'Grãos de girassol');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (2, 'Hambúrguer de Camarão', 'Hambúrguer de carne de camarão');


--Conferir
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (3, 'Refrigerantes', 'Bebidas carbonatadas açucaradas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (3, 'Sucos Naturais', 'Bebidas de frutas frescas espremidas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (3, 'Chás', 'Infusões de ervas, folhas ou flores');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (3, 'Água Mineral', 'Água engarrafada sem gás');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (4, 'Cerveja', 'Bebida alcoólica fermentada de cereais');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (4, 'Vinho Tinto', 'Bebida alcoólica feita a partir de uvas vermelhas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (4, 'Vinho Branco', 'Bebida alcoólica feita a partir de uvas brancas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (4, 'Whisky', 'Bebida alcoólica destilada de cereais envelhecida');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (5, 'Leite', 'Produto lácteo líquido');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (5, 'Queijo', 'Produto derivado do leite coagulado');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (5, 'Iogurte', 'Produto lácteo fermentado');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (5, 'Manteiga', 'Produto gorduroso derivado do leite');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (6, 'Higiene Bucal', 'Produtos para higiene oral, como escovas de dentes e creme dental');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (6, 'Higiene Corporal', 'Produtos para higiene corporal, como sabonetes e loções');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (6, 'Cuidados com a Pele', 'Produtos para cuidados com a pele, como cremes e loções hidratantes');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (6, 'Cuidados com o Cabelo', 'Produtos para cuidados com o cabelo, como shampoo e condicionador');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (7, 'Limpeza Geral', 'Produtos para limpeza geral da casa, como detergentes e desinfetantes');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (7, 'Limpeza de Superfícies', 'Produtos para limpeza de superfícies específicas, como vidros e pisos');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (7, 'Lavanderia', 'Produtos para lavagem de roupas, como sabão em pó e amaciante');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (7, 'Limpeza de Banheiro', 'Produtos para limpeza de banheiros, como desinfetantes e removedores de manchas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (8, 'Snacks Salgados', 'Petiscos salgados, como batatas fritas e salgadinhos');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (8, 'Doces', 'Guloseimas doces, como chocolates e balas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (8, 'Bolachas', 'Biscoitos de diversos tipos e sabores');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (8, 'Chocolate', 'Produtos de chocolate, como barras e bombons');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (9, 'Frutas Frescas', 'Frutas frescas para consumo');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (9, 'Legumes Frescos', 'Legumes frescos para consumo');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (9, 'Verduras Frescas', 'Verduras frescas para consumo');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (9, 'Ervas Aromáticas', 'Ervas frescas para tempero e aromatização');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (10, 'Produtos de Limpeza', 'Produtos para limpeza em geral');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (10, 'Utensílios de Cozinha', 'Itens para uso na cozinha, como panelas e talheres');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (10, 'Artigos de Decoração', 'Itens decorativos para a casa');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (10, 'Produtos Eletrônicos', 'Produtos eletrônicos para uso doméstico');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (11, 'Enlatados de Vegetais', 'Vegetais enlatados, como milho e ervilha');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (11, 'Enlatados de Frutas', 'Frutas enlatadas, como pêssego e abacaxi');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (11, 'Enlatados de Peixe', 'Peixes enlatados, como sardinha e atum');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (11, 'Enlatados de Carne', 'Carnes enlatadas, como carne enlatada e presunto');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (12, 'Molhos de Tomate', 'Molhos à base de tomate para uso culinário');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (12, 'Molhos de Salada', 'Molhos para temperar saladas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (12, 'Molhos Picantes', 'Molhos com pimenta e picância intensa');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (12, 'Molhos Especiais', 'Molhos diversos para diversos usos culinários');



Insert into tb_subcategoria (cod_categoria, nome, descricao) values (3, 'Refrigerantes', 'Bebidas carbonatadas açucaradas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (3, 'Sucos Naturais', 'Bebidas de frutas frescas espremidas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (3, 'Chás', 'Infusões de ervas, folhas ou flores');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (3, 'Água Mineral', 'Água engarrafada sem gás');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (4, 'Cerveja', 'Bebida alcoólica fermentada de cereais');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (4, 'Vinho Tinto', 'Bebida alcoólica feita a partir de uvas vermelhas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (4, 'Vinho Branco', 'Bebida alcoólica feita a partir de uvas brancas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (4, 'Whisky', 'Bebida alcoólica destilada de cereais envelhecida');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (5, 'Leite', 'Produto lácteo líquido');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (5, 'Queijo', 'Produto derivado do leite coagulado');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (5, 'Iogurte', 'Produto lácteo fermentado');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (5, 'Manteiga', 'Produto gorduroso derivado do leite');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (6, 'Higiene Bucal', 'Produtos para higiene oral, como escovas de dentes e creme dental');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (6, 'Higiene Corporal', 'Produtos para higiene corporal, como sabonetes e loções');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (6, 'Cuidados com a Pele', 'Produtos para cuidados com a pele, como cremes e loções hidratantes');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (6, 'Cuidados com o Cabelo', 'Produtos para cuidados com o cabelo, como shampoo e condicionador');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (7, 'Limpeza Geral', 'Produtos para limpeza geral da casa, como detergentes e desinfetantes');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (7, 'Limpeza de Superfícies', 'Produtos para limpeza de superfícies específicas, como vidros e pisos');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (7, 'Lavanderia', 'Produtos para lavagem de roupas, como sabão em pó e amaciante');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (7, 'Limpeza de Banheiro', 'Produtos para limpeza de banheiros, como desinfetantes e removedores de manchas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (8, 'Snacks Salgados', 'Petiscos salgados, como batatas fritas e salgadinhos');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (8, 'Doces', 'Guloseimas doces, como chocolates e balas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (8, 'Bolachas', 'Biscoitos de diversos tipos e sabores');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (8, 'Chocolate', 'Produtos de chocolate, como barras e bombons');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (9, 'Frutas Frescas', 'Frutas frescas para consumo');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (9, 'Legumes Frescos', 'Legumes frescos para consumo');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (9, 'Verduras Frescas', 'Verduras frescas para consumo');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (9, 'Ervas Aromáticas', 'Ervas frescas para tempero e aromatização');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (10, 'Produtos de Limpeza', 'Produtos para limpeza em geral');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (10, 'Utensílios de Cozinha', 'Itens para uso na cozinha, como panelas e talheres');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (10, 'Artigos de Decoração', 'Itens decorativos para a casa');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (10, 'Produtos Eletrônicos', 'Produtos eletrônicos para uso doméstico');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (11, 'Enlatados de Vegetais', 'Vegetais enlatados, como milho e ervilha');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (11, 'Enlatados de Frutas', 'Frutas enlatadas, como pêssego e abacaxi');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (11, 'Enlatados de Peixe', 'Peixes enlatados, como sardinha e atum');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (11, 'Enlatados de Carne', 'Carnes enlatadas, como carne enlatada e presunto');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (12, 'Molhos de Tomate', 'Molhos à base de tomate para uso culinário');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (12, 'Molhos de Salada', 'Molhos para temperar saladas');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (12, 'Molhos Picantes', 'Molhos com pimenta e picância intensa');
Insert into tb_subcategoria (cod_categoria, nome, descricao) values (12, 'Molhos Especiais', 'Molhos diversos para diversos usos culinários');



insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Feijão carioca', '7890123456789', 'Camil', 1, 'UN', 10.0, '2022-01-01', '2023-01-01', '12345', 5.0, 10.0, 0.5, 3.0, 4.5);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final)  values  ('Arroz parboilizado', '1234567890123', 'Tio João', 4, 'UN', 5.0, '2022-01-01', '2023-01-01', '54321', 3.0, 12.0, 0.3, 2.0, 2.6);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Lentilha', '4567890123456', 'Vapza', 1, 'UN', 200.0, '2022-01-01', '2023-01-01', '67890', 0.0, 10.0, 0.4, 1.0, 1.8);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Refrigerante Coca-Cola', '7894900011517', 'Coca-Cola', 6, 'UN', 2, '2022-01-01', '2023-01-01', '123456', 10, 18, 20, 2.50, 3.00);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Cerveja Heineken', '7894900012613', 'Heineken', 5, 'UN', 1, '2022-01-01', '2023-01-01', '654321', 5, 18, 30, 3.00, 5.00);
insert into tb_produto  (descricao, codigo_barras, marca, cod_subcategoria, unidade_medida, quantidade, data_fabricacao, data_validade, lote, ipi, icms, margem_lucro, preco_custo, preco_final) values ('Suco de Laranja Del Valle', '7894900011678', 'Del Valle', 3, 'UN', 200, '2022-01-01', '2023-01-01', 'ABC123', 0, 18, 40, 1.50, 2.50);


insert into tb_cliente values ('João da Silva', 'joao.silva@example.com', '111.222.333-44', '22.333.444-5', 'Rua das Flores, 123', '(19) 5555-5555', '(19) 99999-9999', 456, '13338-000', '1990-01-01', 'Jardim São Conrado', 'Indaiatuba', 'SP', 'Apto 4', 2000);
insert into tb_cliente values ('Maria da Silva', 'maria.silva@example.com', '111.222.333-55', '22.333.444-6', 'Rua das Palmeiras, 321', '(19) 5555-5555', '(19) 99999-9999', 654, '13338-000', '1995-05-10', 'Jardim São Francisco', 'Indaiatuba', 'SP', '', 1500);
insert into tb_cliente values ('Pedro Souza', 'pedro.souza@example.com', '111.222.333-66', '22.333.444-7', 'Avenida dos Bandeirantes, 456', '(19) 5555-5555', '(19) 99999-9999', 789, '13338-000', '1995-05-10', 'Centro', 'Indaiatuba', 'SP', 'Fundos', 5000);
insert into tb_cliente values  ('Carla Santos', 'carla.santos@example.com', '111.222.333-77', '22.333.444-8', 'Rua dos Girassóis, 987', '(19) 5555-5555', '(19) 99999-9999', 123, '13338-000', '1995-05-10', 'Jardim Europa', 'Indaiatuba', 'SP', '', 3500);
insert into tb_cliente values ('Ana Paula Rocha', 'ana.rocha@example.com', '111.222.333-88', '22.333.444-9', 'Rua das Margaridas, 654', '(19) 5555-5555', '(19) 99999-9999', 321, '13338-000', '1995-05-10', 'Jardim América', 'Indaiatuba', 'SP', 'Casa 2', 1000);


insert into tb_funcionario values  ('Fernando Silva', 'fernando.silva@gmail.com', '123.456.789-01', '12.345.678-9', 'Rua Padre José de Anchieta, 300', '(19) 99999-8888', '(19) 98888-7777', 50, '13330-000', '1987-10-01', 'Vila Avaí', 'Indaiatuba', 'SP', 'Apto 301', 3000, '1234', 'Gerente', 'Gerente', '12345678900', 5500, '111222333444', 'Solteiro(a)', '44h semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values ('Maria Rodrigues', 'maria.rodrigues@gmail.com', '234.567.890-12', '23.456.789-0', 'Rua Campos Salles', '(19) 99999-7777', '(19) 98888-6666', 150, '13330-100', '1987-10-01', 'Centro', 'Indaiatuba', 'SP', 'Casa', 2500, '123456', 'Repositor', 'Estoquista', '23456789012', 3500, '2223334445', 'Casado(a)', '40h semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Ana Clara Oliveira', 'anaclara.oliveira@gmail.com', '345.678.901-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, '147258369', 'Caixa', 'Caixa', '3456789012', 3000, '3456789', 'Casado(a)', '36 horas semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Giovanni', 'giovanni', '345.678.901-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, '147258369', 'Caixa', 'Caixa', '3456789012', 3000, '1234', 'Casado(a)', '36 horas semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Giovanni', 'caixa', '345.678.941-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, 'caixa', 'Caixa', 'Caixa', '3456789012', 3000, 'caixa', 'Casado(a)', '36 horas semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Giovanni', 'estoquista', '345.878.901-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, 'estoquista', 'Caixa', 'Estoquista', '3456789012', 3000, 'estoquista', 'Casado(a)', '36 horas semanais', '2022-01-01', NULL, 'Sim');
insert into tb_funcionario values  ('Giovanni', 'gerente', '345.978.901-23', '34.567.801-2', 'Rua dos Pinheiros', '(19) 99999-9999', '(19) 98888-8888', 300, '13330-000', '1987-10-01', 'Jardim Esplanada', 'Indaiatuba', 'SP', 'Casa 2', 1800, 'gerente', 'Caixa', 'Gerente', '3456789012', 3000, 'gerente', 'Casado(a)', '36 horas semanais', '2022-01-01', NULL, 'Sim');




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

